package com.question.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.question.dao.QuestionDAO;
import com.question.question.data.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questionDAO;
	public List<Question> getAllQuestions()
	{
		return questionDAO.findAll();
	}
	public List<Question> getAllQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		 return questionDAO.findAllByCategory(category);
	}
	
	public String addQuestion(Question question) {
		// TODO Auto-generated method stub
		  questionDAO.save(question);
		  return "success";
	}
	public List<Integer> generateQuestionForQuiz(String category, Integer numberOfQuestions) {
		return questionDAO.findRandomQuestionId(category);
		
	}
	public List<Question> getQuestions(List<Integer> questionId) {
		// TODO Auto-generated method stub
		return questionDAO.findAllById(questionId);
	}

}
