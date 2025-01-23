package com.laberry.band.board.post;

import java.time.LocalDateTime;
import java.util.List;

import com.laberry.band.board.comment.Comment;
import com.laberry.band.util.DateUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String subject;
	
	@Column(nullable = false)
	private String content;
	
	@Column
	private Integer liked;
	
	@Column
	private LocalDateTime createDate;
	
	@Transient
	private String formattedCreateDate;

	public void setFormattedCreateDateFromCreateDate() {
		this.formattedCreateDate = DateUtils.formatDate(this.createDate);
	}
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	private List<Comment> commentList;
}
