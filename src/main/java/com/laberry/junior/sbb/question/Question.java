package com.laberry.junior.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.laberry.junior.sbb.answer.Answer;
import com.laberry.junior.sbb.user.SiteUser;
import com.laberry.junior.util.DateUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100)
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column
	private LocalDateTime createDate;
	
	@Column
	private LocalDateTime modifyDate;

	@Transient
	private String formattedCreateDate;
	
	@Transient
	private String formattedModifyDate;
	
	@PostLoad
	public void setFormattedDate() {
		this.formattedCreateDate = DateUtils.formatDate(this.createDate);
		this.formattedModifyDate = DateUtils.formatDate(this.modifyDate);
	}

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	@ManyToOne
	private SiteUser author;
	
	@ManyToMany
	Set<SiteUser> voter;
}
