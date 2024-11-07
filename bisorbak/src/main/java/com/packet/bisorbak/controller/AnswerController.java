package com.packet.bisorbak.controller;

import com.packet.bisorbak.domain.Answer;
import com.packet.bisorbak.domain.Question;
import com.packet.bisorbak.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    AnswerServiceImpl answerService;

    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public List<Answer> getAnswers(){
        return answerService.getAll();
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
    public Answer getAnswerById(@PathVariable long id){
        return answerService.getByAnswerId(id);
    }

    @RequestMapping(value = "/answer/user/{id}", method = RequestMethod.GET)
    public List<Answer> getAnswerByUserId(@PathVariable long id){
        return answerService.getAnswersByUserId(id);
    }

    @RequestMapping(value = "/answer/question/{id}", method = RequestMethod.GET)
    public List<Answer> getAnswerByQuestionId(@PathVariable long id){
        return answerService.getAnswersByQuestionId(id);
    }

    @RequestMapping(value = "/answer/parent/{id}", method = RequestMethod.GET)
    public List<Answer> getAnswersByParentId(@PathVariable long id){
        return answerService.getAnswersByParentId(id);
    }

    @RequestMapping(value = "/answer/save", method = RequestMethod.POST)
    public void saveAnswer(Answer answer){
        answerService.saveAnswer(answer);
    }

    @RequestMapping(value = "/answer/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAnswerById(@PathVariable long id){
        answerService.deleteAnswerById(id);
    }
}
