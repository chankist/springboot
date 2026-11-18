package com.css.sbb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.css.sbb.entity.Question;
import com.css.sbb.repository.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/question/list")//모든 질문 목록 요청
	public String list(Model model) {
		List<Question> questionList = questionRepository.findAll();
		//model 객체에 질문 리스트 List 객체에 전송해주기
		model.addAttribute("questionList", questionList);
		
		return "question_list";//.html은 쓰지 않음
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 25);
	
		return "test";
	}
}
