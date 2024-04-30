package com.question.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.question.data.Question;
import com.question.question.data.QuestionDTO;
import com.question.question.service.QuestionService;



@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	Environment environment;
	
	@GetMapping("getAllQuestions")
	public List<Question> getAllQuestions()
	{
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.getAllQuestions();
	}
	
	@GetMapping("getAllQuestionsByCategory/{category}")
	public List<Question> getAllQuestionsByCategory(@PathVariable String category)
	{
		return questionService.getAllQuestionsByCategory(category);
	}
	
	@PostMapping("/add")
	public String addQuestion(@RequestBody Question question)
	{
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/generate")
	public List<Integer> generateQuestionForQuiz()
	{
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.generateQuestionForQuiz("Java", 5);
	}
	
	@PostMapping("/getQuestions")
	public List<Question> getQuestions(@RequestBody List<Integer> questionId)
	{
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.getQuestions(questionId);
	}
}
