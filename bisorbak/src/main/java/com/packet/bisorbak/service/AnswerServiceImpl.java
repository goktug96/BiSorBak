package com.packet.bisorbak.service;

import com.packet.bisorbak.domain.Answer;
import com.packet.bisorbak.domain.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> getAll() {
        return (List<Answer>) answerRepository.findAll();
    }

    @Override
    public Answer getByAnswerId(long id) {
        if(answerRepository.findById(id).isPresent()){
            return answerRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public List<Answer> getAnswersByParentId(long id) {
        return answerRepository.findByParentId(id);
    }

    @Override
    public List<Answer> getAnswersByQuestionId(long id) {
        return answerRepository.findByQuestionId(id);
    }

    @Override
    public List<Answer> getAnswersByUserId(long id) {
        return answerRepository.findByUserId(id);
    }

    @Override
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void deleteAnswerById(long id) {
        answerRepository.deleteById(id);
    }
}
