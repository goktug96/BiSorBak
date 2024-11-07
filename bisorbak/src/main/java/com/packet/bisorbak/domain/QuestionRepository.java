package com.packet.bisorbak.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository <Question, Long>{
    @Query("select q from Question q where q.owner = ?1")
    List<Question> findByUserId(long id);
}
