package com.packet.bisorbak.service;

import com.packet.bisorbak.domain.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAll();
    Answer getByAnswerId(long id);
    List<Answer> getAnswersByParentId(long id);
    List<Answer> getAnswersByQuestionId(long id);
    List<Answer> getAnswersByUserId(long id);
    void saveAnswer(Answer answer);
    void deleteAnswerById(long id);
}
