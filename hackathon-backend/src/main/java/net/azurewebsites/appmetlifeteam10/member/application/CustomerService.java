package net.azurewebsites.appmetlifeteam10.member.application;

import static org.springframework.http.HttpStatus.*;

import org.springframework.stereotype.Service;

import net.azurewebsites.appmetlifeteam10.common.exception.CustomException;
import net.azurewebsites.appmetlifeteam10.common.exception.ErrorCode;
import net.azurewebsites.appmetlifeteam10.member.domain.Customer;
import net.azurewebsites.appmetlifeteam10.member.dto.CustomerRequest;
import net.azurewebsites.appmetlifeteam10.member.infrastructure.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository customerRepository;

	public void create(CustomerRequest.Join request) {
		validateDuplicatedMember(request.getEmail());

		Customer customer = new Customer(
			request.getName(),
			request.getEmail(),
			request.getBirthDate(),
			request.getPassword(),
			request.getJoinedInsurance()
		);

		customerRepository.save(customer);
	}

	private void validateDuplicatedMember(String email) {
		customerRepository.findByEmail(email)
			.ifPresent(e -> {
				throw new CustomException(new ErrorCode(BAD_REQUEST, "이미 존재하는 회원입니다."));
			});
	}

	public void login(CustomerRequest.Login request) {
		Customer customer = customerRepository.findByEmail(request.getEmail())
			.orElseThrow(() -> new CustomException(new ErrorCode(BAD_REQUEST, "존재하지 않는 회원입니다.")));

		if (!customer.isMatchedPassword(request.getPassword())) {
			throw new CustomException(new ErrorCode(BAD_REQUEST, "비밀번호가 일치하지 않습니다."));
		}
	}
}
