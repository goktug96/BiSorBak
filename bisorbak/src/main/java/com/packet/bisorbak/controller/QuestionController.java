package com.packet.bisorbak.controller;

import com.packet.bisorbak.domain.Question;
import com.packet.bisorbak.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public List<Question> getQuestions(){
        return questionService.getAll();
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestionById(@PathVariable long id){
        return questionService.getQuestionById(id);
    }

    @RequestMapping(value = "/question/user/{id}", method = RequestMethod.GET)
    public List<Question> getQuestionByUserId(@PathVariable long id){
        return questionService.getQuestionByUserId(id);
    }

    @RequestMapping(value = "/question/save", method = RequestMethod.POST)
    public void saveQuestion(Question q){
        questionService.saveQuestion(q);
    }

    @RequestMapping(value = "/question/delete/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable long id){
        questionService.deleteById(id);
    }
}
