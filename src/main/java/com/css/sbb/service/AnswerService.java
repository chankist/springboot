package com.css.sbb.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.sbb.entity.Answer;
import com.css.sbb.entity.Question;
import com.css.sbb.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	public void createAnswer(String content, Question question) {
		
		//답변 저장 - save
		Answer answer = new Answer();
		answer.setContent(content);//답변 내용 등록
		answer.setCreateDate(LocalDateTime.now());//현재 시간 등록
		answer.setQuestion(question);//부모 질문글 엔티티 객체 등록
		answerRepository.save(answer);
	}
	
}
