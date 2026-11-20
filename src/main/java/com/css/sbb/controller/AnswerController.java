package com.css.sbb.controller;

import com.css.sbb.repository.QuestionRepository;
import com.css.sbb.service.AnswerService;
import com.css.sbb.service.QuestionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.css.sbb.dto.AnswerForm;
import com.css.sbb.entity.Question;
import com.css.sbb.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {
	
	private final AnswerService answerService;
	
	private final QuestionService questionService;

	@PostMapping("/create/{id}")
	//id -> 답변이 달릴 부모질문글의 번호
	public String createAnswer(@PathVariable("id") Integer id, 
			@RequestParam(value = "content") String content,
			@Valid AnswerForm answerForm, BindingResult bindingResult, Model model) {
		
		Question question = questionService.getQuestion(id);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		}
		
		answerService.createAnswer(answerForm.getContent(), question);//답변내용, 부모 질문글 엔티티 객체
				
		return "redirect:/question/detail/"+id;
	}
	
	

}
