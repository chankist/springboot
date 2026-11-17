package com.css.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.css.sbb.entity.Question;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
		// 제목으로 질문글 찾기 메소드
		List<Question> findBySubject(String subject);
		
		// 제목에 특정 키워드가 포함되어 있는 질문글 찾기 메소드 (수정됨)
		// select * from question where subject like ?
		List<Question> findBySubjectLike(String subject);
		
		// select * from question where subject like '%?%'
		List<Question> findBySubjectContaining(String subject);
		
		// select * from question where subject like ? or content like ?
		List<Question> findBySubjectLikeOrContentLike(String subject, String content);
		
		// select * from question where subject like ? or content ? like order by creat_date asc;
		List<Question> findBySubjectLikeOrContentLikeOrderByCreateDateAsc(String subject, String content);
		
		//delete from question where subject like ?;
		void deleteBySubjectLike(String keyword);
	
}
