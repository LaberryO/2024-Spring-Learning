package com.laberry.junior.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	@Size(min = 3, max = 25)
	@NotBlank(message = "사용자명은 필수 항목입니다.")
	private String username;
	
	@NotBlank(message = "비밀번호는 필수 항목입니다.")
	private String password;
	
	@NotBlank(message = "비밀번호 확인은 필수 항목입니다.")
	private String checkPassword;
	
	@NotBlank(message = "이메일은 필수 항목입니다.")
	@Email(message = "이메일 형식이 올바르지 않습니다.")
	private String email;
}
