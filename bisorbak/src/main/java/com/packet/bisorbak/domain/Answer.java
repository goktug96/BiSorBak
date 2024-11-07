package com.packet.bisorbak.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 1024)
    private String answer;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Answer parent;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name="owner")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User owner;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name="question_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Question question;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Answer> children;

    public Answer(){}

    public Answer(String answer, User owner, Question question, Answer parent){
        super();
        this.question = question;
        this.answer = answer;
        this.parent = parent;
        this.owner = owner;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer getParent() {
        return parent;
    }

    public void setParent(Answer parent) {
        this.parent = parent;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getChildren() {
        return children;
    }

    public void setChildren(List<Answer> children) {
        this.children = children;
    }
}


