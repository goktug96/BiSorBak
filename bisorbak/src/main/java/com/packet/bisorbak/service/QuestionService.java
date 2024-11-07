package com.packet.bisorbak.service;

import com.packet.bisorbak.domain.Question;

import java.util.List;

public interface QuestionService {
    Question getQuestionById(long id);
    List<Question> getQuestionByUserId(long id);
    List<Question> getAll();
    void deleteById(long id);
    void saveQuestion(Question q);

}
