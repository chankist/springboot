package com.css.sbb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

	@NotBlank(message = "답변은 필수 입력사항입니다.")
	@Size(min=5, max=100, message="답변은 5자이상 100자 이하 입니다.")//답변 최소 5글자 최대 100글자
	private String content;//답변글
	
}
