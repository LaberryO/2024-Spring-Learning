package com.laberry.junior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.laberry.junior.sbb.answer.Answer;
import com.laberry.junior.sbb.answer.AnswerRepository;
import com.laberry.junior.sbb.answer.AnswerService;
import com.laberry.junior.sbb.question.Question;
import com.laberry.junior.sbb.question.QuestionRepository;
import com.laberry.junior.sbb.question.QuestionService;

@SpringBootTest
class JuniorApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Test
//	@Transactional
	void testJpa() {
		for(int i=1; i<=300; i++) {
			String subject = String.format("고유번호 [%03d]번 데이터입니다.", i);
			String content = "테스트 상세 내용입니다. 감사합니다.";
			this.questionService.create(subject, content);
		}
//		Question q1 = new Question();
//		q1.setSubject("스프링 부트의 이름은 어떠한 뜻입니까?");
//		q1.setContent("스프링 부트의 사용법이 궁금합니다?");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("JPA가 무엇입니까?");
//		q2.setContent("JPA의 사용법이 궁금합니다.");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(5, all.size());
		
//		List<Question> test1 = this.questionRepository.findAll();
//		assertEquals("스프링 부트의 이름은 어떠한 뜻입니까?", test1.get(0).getSubject());
		
//		Optional<Question> q = this.questionRepository.findById(3);
//		if (q.isPresent()) {
//			Question qs = q.get();
//			assertEquals("스프링 부트의 사용법이 궁금합니다.", qs.getContent());
//		}
		
//		List<Question> q = this.questionRepository.findBySubject("JPA가 무엇입니까?");
		
//		Question q = this.questionRepository.findBySubjectAndContent("스프링 부트의 이름은 어떠한 뜻입니까?", "스프링 부트의 사용법이 궁금합니다?");
//		assertEquals(17, q.getId());
		
//		List<Question> ql = this.questionRepository.findBySubjectLike("%JPA%");
//		Question q = ql.get(1);
//		assertEquals(6, q.getId());
//		assertEquals(7, ql.size());
		
//		short qc = this.questionRepository.countBySubjectLike("%JPA%");
//		assertEquals(7, qc);
		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
		
//		long count = this.questionRepository.count();		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(count-1, this.questionRepository.count());
		
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("답변입니다.");
//		a.setCreateDate(LocalDateTime.now());
//		a.setQuestion(q);
//		this.answerRepository.save(a);
		
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
		
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> la = q.getAnswerList();
//		assertEquals(1, la.size());
//		assertEquals("답변입니다.", la.get(0).getContent());
	}

}
