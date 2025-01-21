package com.laberry.junior.sbb.answer;

import java.time.LocalDateTime;

import com.laberry.junior.sbb.question.Question;
import com.laberry.junior.util.DateUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@Transient
	private String formattedCreateDate;
	
	@PostLoad
	public void setFormattedCreateDateFromCreateDate() {
		this.formattedCreateDate = DateUtils.formatDate(this.createDate);
	}
	
	@ManyToOne
	private Question question;
}
