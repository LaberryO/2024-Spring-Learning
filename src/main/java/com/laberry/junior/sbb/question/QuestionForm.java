package com.laberry.junior.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class QuestionForm {
	@NotEmpty(message = "제목을 필수 항목입니다.")
	@Size(max = 50)
	private String subject;
	
	@NotEmpty(message = "내용은 필수 항목입니다.")
	private String content;
}
