package com.packet.bisorbak.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 1024)
    private String question;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="question")
    @JsonIgnore
    private List<Answer> answers;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name="owner")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User owner;

    public Question(){}

    public Question(String question, User owner){
        super();
        this.question = question;
        this.owner = owner;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
