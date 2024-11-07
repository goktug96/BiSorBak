package com.packet.bisorbak.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    @Query("select a from Answer a where a.owner = ?1")
    List<Answer> findByUserId(long id);

    List<Answer> findByQuestionId(long id);

    List<Answer> findByParentId(long id);
}
