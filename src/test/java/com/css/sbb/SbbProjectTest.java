package com.css.sbb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.css.sbb.entity.Answer;
import com.css.sbb.entity.Question;
import com.css.sbb.repository.AnswerRepository;
import com.css.sbb.repository.QuestionRepository;
import com.css.sbb.service.QuestionService;

import jakarta.transaction.Transactional;

@SpringBootTest
class SbbProjectTest {

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	
//	@Test
//	@DisplayName("답변글 저장 테스트")
//	void test1() {
//		//답변글이 달릴 질문글이 존재해야만 답변이 저장될수 있따
//		//1. 답변이 달릴 질문글 레코드를 db에서 가져온다
//		//2. 해당 질문글에 답변이 달리도록 answer 테이블에 저장
//		
//		//2번 질문글에 답변달기
//		//부모 질문글 5번 가져오기(답변이 달릴 질문글 5번)
//		Optional<Question> op = questionRepository.findById(5);
//		if(op.isPresent()) {
//			Question question = op.get();
//			
//			Answer answer = new Answer();
//			answer.setContent("2번째 답변 네 자동으로 생성됩니다.");
//			answer.setQuestion(question);//질문이 달릴 질문글 entity를 setter로 저장
//			answer.setCreateDate(LocalDateTime.now());
//			answerRepository.save(answer);		
//		}
//	}
	
	
//	@Test
//    void testJpa() {
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(5, a.getQuestion().getId());
//    }
//	@Transactional
//	@Test
//	@DisplayName("5번 질문글에 달린 답변들 확인 테스트")
//	void testJpa() {
//		Optional<Question> op5 = questionRepository.findById(5);//5번 질문글 가져오기
//		if(op5.isPresent()) {//참이면 5번 질문글 존재확인
//			Question q5 = op5.get();//5번 질문글 가져오기
//			
//			List<Answer> answeList = q5.getAnswerList();//5번 질문글에 달린 답변글들 list
//			System.out.println(answeList.get(0).getContent());
//			//5번 질문글에 달린 답변중 첫번째 답변의 내용 출력
//			System.out.println(answeList.get(1).getContent());
//			//5번 질문글에 달린 답변중 두번째 답변의 내용 출력
//		}
//	}
	
	@Test
	@DisplayName("dummy data 300개 생성")
	public void testJpa() {
		for(int i=1;i<=300;i++) {
			String subject = "테스트 질문 데이터입니다. -" +i;
            String content = "테스트 질문 내용 입니다. -" +i;
            questionService.createQuestion(subject, content);
		}
		
	}
	
	
}
