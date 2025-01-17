package com.laberry.junior.sbb.question;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	short countBySubjectLike(String subject);
	
}
