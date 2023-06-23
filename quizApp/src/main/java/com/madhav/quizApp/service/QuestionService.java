package com.madhav.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhav.quizApp.DAO.QuestionDAO;
import com.madhav.quizApp.entities.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllquestions() {
        return questionDAO.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return "success";
        } catch (Exception e) {
            return "failure: " + e; 
        }
    }

    public String deleteQuestion(Integer id) {
        try {
            questionDAO.deleteById(id);
            return "success";
        } catch (Exception e) {
            return "failure: " + e; 
        }
    }

    public String updateQuestion(Question question) {
         try {
            questionDAO.save(question);
            return "success";
        } catch (Exception e) {
            return "failure: " + e; 
        }
    }
    
}
