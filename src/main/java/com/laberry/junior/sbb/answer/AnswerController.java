package com.laberry.junior.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laberry.junior.sbb.question.Question;
import com.laberry.junior.sbb.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;

	@PostMapping("/create/{id}")
	public String createAnswer(@Valid AnswerForm answerForm, BindingResult bindingResult, Model model,
			@PathVariable("id") Integer q_id) {
		Question question = this.questionService.getQuestion(q_id);
		model.addAttribute("question", question);
		if (bindingResult.hasErrors()) {
			return "question_detail";
		}
		this.answerService.create(answerForm.getContent(), question);
		return String.format("redirect:/question/detail/%s", q_id);
	}
}
