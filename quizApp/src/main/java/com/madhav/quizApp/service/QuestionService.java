package com.madhav.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.madhav.quizApp.DAO.QuestionDAO;
import com.madhav.quizApp.entities.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllquestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
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
