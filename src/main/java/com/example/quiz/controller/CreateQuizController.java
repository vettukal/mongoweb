package com.example.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Customer;
import com.example.CustomerRepository;
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
        
        List<QuizDetails> qdlist = repo.findAll();
        int max =1;
        if(qdlist!=null){
        	for (QuizDetails qditer : qdlist) {
    			int num = qditer.getQuizId();
    			if(num>max)
    				max = num;
    		}
        }
        
        quizdetails.setQuizId(max+1);
        quizdetails.setCreationTime(System.currentTimeMillis());
        quizdetails.setEndingTime(quizdetails.getCreationTime()+(60*1000*quizdetails.getMaxTime()));
        
        System.out.println(quizdetails.toString());
        //if(quizdetails.getAnon()==null)
        //	quizdetails.setAnon("iden");
        repo.save(quizdetails);
        return "quiz/quizcreated";
    }
    
    @RequestMapping(value="/createquiz2", method=RequestMethod.GET)
    public String greetingForm2(Model model,@RequestParam("subject") String subject,@RequestParam("email") String email) {
        QuizDetails qd = new QuizDetails();
        //email = email.replaceAll("@", "_");
        //email = email.replaceAll(".", "_");
        System.out.println("Subject in GET is: "+subject);
        System.out.println("email in the createquiz2 is:"+email);
        qd.setSubject(subject);
    	model.addAttribute("quizdetails", qd);
    	model.addAttribute("subjectind",subject);
    	model.addAttribute("testatt","testatt");
    	model.addAttribute("quizid",getQuizid(subject,email));
    	model.addAttribute("email",email);
        return "quiz/createpage2";
    }

    @Autowired
    CustomerRepository custrepo;
	private Integer getQuizid(String subject,String email) {
		List<Customer> list = (List<Customer>) custrepo.findAll();
		int max = 0;
		
		for (Customer customer : list) {
			System.out.println(customer.getQuizid());
		}
		for (Customer customer : list) {
			if(customer.getFaculty().equalsIgnoreCase(email)&&customer.getSubject().equalsIgnoreCase(subject)){
				if(Integer.parseInt(customer.getQuizid())>max){
					max = Integer.parseInt(customer.getQuizid());
				}
			}
			
		}
		return max+1;
	}

}