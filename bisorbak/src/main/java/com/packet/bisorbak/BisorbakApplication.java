package com.packet.bisorbak;

import com.packet.bisorbak.domain.*;
import com.packet.bisorbak.service.AnswerServiceImpl;
import com.packet.bisorbak.service.QuestionServiceImpl;
import com.packet.bisorbak.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BisorbakApplication {
	@Autowired
	private QuestionServiceImpl questionService;
	@Autowired
    private UserServiceImpl userService;
	@Autowired
    private AnswerServiceImpl answerService;

	public BisorbakApplication() {
		questionService = new QuestionServiceImpl();
		userService = new UserServiceImpl();
		answerService = new AnswerServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(BisorbakApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
		    User user1 = new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "deneme@hotmail.com", "USER");
            User user2 = new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "deneme2@hotmail.com", "ADMIN");
            userService.saveUser(user1);
			userService.saveUser(user2);
			Question question1 = new Question("testSorusu", user1);
			Question question2 = new Question("testSorusu2", user2);
			questionService.saveQuestion(question1);
			questionService.saveQuestion(question2);
            Answer answer1 = new Answer("cevap1", user1, question1, null);
            Answer answer2 = new Answer("cevap2", user2, question1, answer1);
			Answer answer3 = new Answer("cevap3", user1, question1, answer2);
            answerService.saveAnswer(answer1);
            answerService.saveAnswer(answer2);
			answerService.saveAnswer(answer3);
		};
	}
}
