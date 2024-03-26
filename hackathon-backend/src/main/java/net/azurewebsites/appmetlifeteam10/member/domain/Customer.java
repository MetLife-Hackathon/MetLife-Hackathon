package net.azurewebsites.appmetlifeteam10.member.domain;

import java.time.LocalDateTime;
import java.util.StringTokenizer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
	private final static String BIRTH_DATE_DELIMITER = "-";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String birthDate;

	private String password;

	private String insurances;

	public Customer(String name, String email, String birthDate, String password, String insurances) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.password = password;
		this.insurances = insurances;
	}

	public boolean isMatchedPassword(String password) {
		return this.password.equals(password);
	}

	public int calculateAge() {
		final int currentYear = LocalDateTime.now().getYear();
		final StringTokenizer stringTokenizer = new StringTokenizer(birthDate, BIRTH_DATE_DELIMITER);
		final int birthYear = Integer.parseInt(stringTokenizer.nextToken());

		return currentYear - birthYear + 1;
	}
}
