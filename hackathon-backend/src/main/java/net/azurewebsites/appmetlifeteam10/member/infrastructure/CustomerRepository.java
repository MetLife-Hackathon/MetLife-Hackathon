package net.azurewebsites.appmetlifeteam10.member.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.azurewebsites.appmetlifeteam10.member.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByEmail(String email);
}
