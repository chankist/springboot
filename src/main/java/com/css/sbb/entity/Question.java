package com.css.sbb.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

	@Id // PK 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가 옵션(AI)
	private Integer id; //int -> Integer(null 값을 가질수 없기 때문에)
	//entity 클래스에서는 멤버(필드)를 선언할때 int, double 같은 기본타입으로 선언하지 않는다
	//->Integer, Double 같은 wrapper 클래스로 선언하여야 한다.
	
	@Column(length = 200, nullable = false)
	private String subject;
	
	@Column(columnDefinition = "text", nullable = false)//255자 이상의 아주 긴글을 저장할때
	private String content;
	
	private LocalDateTime createDate;
	
//cascade = CascadeType.REMOVE->질문글이 삭제되면 질문글에 달린 답변도 같이 DB에서 삭제되는 옵션
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //1대 n 관계,(1대 다) 
	private ArrayList<Answer> answerList;
	//질문 1개에 여러개의 답변이 될수 있다
	//-> 질문 1개 객체에 여러개의 답변이 저장될수 있는 자리를 마련
	
}
