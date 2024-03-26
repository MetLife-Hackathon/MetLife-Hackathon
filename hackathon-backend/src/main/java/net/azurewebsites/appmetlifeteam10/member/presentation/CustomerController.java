package net.azurewebsites.appmetlifeteam10.member.presentation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.azurewebsites.appmetlifeteam10.member.application.CustomerService;
import net.azurewebsites.appmetlifeteam10.member.dto.CustomerRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<Void> join(@RequestBody CustomerRequest.Join request) {
		customerService.create(request);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody CustomerRequest.Login request) {
		customerService.login(request);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
