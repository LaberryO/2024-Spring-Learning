package com.laberry.junior.sbb.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	
	@NotBlank(message = "공백을 등록할 수 없습니다.")
	private String content;
}
