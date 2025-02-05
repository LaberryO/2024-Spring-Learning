package com.laberry.junior.sbb.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.laberry.junior.sbb.question.Question;
import com.laberry.junior.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public void create(String content, Question question, SiteUser author) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		this.answerRepository.save(answer);
	}
}
