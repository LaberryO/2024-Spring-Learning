package com.laberry.band;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.laberry.band.board.post.PostService;

@SpringBootTest
class SelfExBandApplicationTests {
	@Autowired
	private PostService postService;
	
	@Test
	void contextLoads() {
		for(int i=1; i<=10; i++) {
			String subject = String.format("%03d번 테스트 제목입니다.", i);
			String content = "테스트 내용입니다.";
			this.postService.create(subject, content);
		}
	}

}
