package com.packet.bisorbak.service;

import com.packet.bisorbak.domain.Question;
import com.packet.bisorbak.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question getQuestionById(long id){
        if(questionRepository.findById(id).isPresent()){
            return questionRepository.findById(id).get();
        }
        System.out.println("Not found");
        return null;
    }
    @Override
    public List<Question> getQuestionByUserId(long id) {
        return questionRepository.findByUserId(id);
    }

    @Override
    public List<Question> getAll() {
        return (List<Question>) questionRepository.findAll();
    }

    @Override
    public void deleteById(long id){
        questionRepository.deleteById(id);
    }

    @Override
    public void saveQuestion(Question q) {
        questionRepository.save(q);
    }

}
