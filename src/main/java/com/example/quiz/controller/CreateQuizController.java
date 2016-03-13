package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quiz.repository.QuizDetails;
import com.example.quiz.repository.QuizDetailsRepository;



@Controller
public class CreateQuizController {
	@Autowired QuizDetailsRepository repo;
	
    @RequestMapping(value="/createquiz", method=RequestMethod.GET)
    public String greetingForm(Model model,@RequestParam("subject") String subject) {
        QuizDetails qd = new QuizDetails();
        System.out.println("Subject in GET is: "+subject);
        qd.setSubject(subject);
    	model.addAttribute("quizdetails", qd);
        return "quiz/createpage";
    }

    @RequestMapping(value="/createquiz", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute QuizDetails quizdetails, Model model) {
        model.addAttribute("quizdetails", quizdetails);
        if(quizdetails.getMaxTime()==null){
        	quizdetails.setMaxTime(1);
        }
        quizdetails.setCreationTime(System.currentTimeMillis());
        quizdetails.setEndingTime(quizdetails.getCreationTime()+(60*1000*quizdetails.getMaxTime()));
        
        System.out.println(quizdetails.toString());
        //if(quizdetails.getAnon()==null)
        //	quizdetails.setAnon("iden");
        repo.save(quizdetails);
        return "quiz/quizcreated";
    }

}