package com.question.question.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.question.question.data.Question;



@Repository
@Component
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	//List<Question> findAll();
	List<Question> findAllByCategory(String category);
	//void save(Question question);
	@Query(value="select q.id from Question q where category=:category limit 5", nativeQuery = true)
	List<Integer> findRandomQuestionId(String category);

}
