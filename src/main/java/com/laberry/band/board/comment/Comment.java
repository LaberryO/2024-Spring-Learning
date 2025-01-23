package com.laberry.band.board.comment;

import java.time.LocalDateTime;

import com.laberry.band.board.post.Post;
import com.laberry.band.util.DateUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String content;
	
	@Column
	private LocalDateTime createDate;
	
	@Transient
	private String formattedCreateDate;

	public void setFormattedCreateDateFromCreateDate() {
		this.formattedCreateDate = DateUtils.formatDate(this.createDate);
	}
	
	@ManyToOne
	private Post post;	
}
