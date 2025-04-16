package com.laberry.junior.sbb.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	
	@NotBlank(message = "제목은 필수 항목입니다.")
	@Size(max = 50)
	private String subject;
	
	@NotBlank(message = "내용은 필수 항목입니다.")
	private String content;
}
