package net.azurewebsites.appmetlifeteam10.member.dto;

import lombok.Data;
import lombok.Getter;

public class CustomerRequest {

	@Data
	public static class Join {
		private String name;
		private String email;
		private String birthDate;
		private String password;
		private String joinedInsurance;
	}

	@Getter
	public static class Login {
		private String email;
		private String password;
	}
}
