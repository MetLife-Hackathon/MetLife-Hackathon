package net.azurewebsites.appmetlifeteam10.consulting.domain;

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
public class Consulting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long consultantId;

	private Long customerId;

	private String summary;

	public Consulting(Long consultantId, Long customerId, String summary) {
		this.consultantId = consultantId;
		this.customerId = customerId;
		this.summary = summary;
	}
}
