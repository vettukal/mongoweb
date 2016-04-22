package com.example.analytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Customer;
import com.example.CustomerRepository;


@Controller
public class SingleQuizAnalytics {
	
	
	@Autowired
	CustomerRepository custrepo;
	@RequestMapping(value="/get_quiz_stat2", method=RequestMethod.GET)
    public String getQuizStat2(Model model,@RequestParam("quizid") String quizid,@RequestParam("subject") String subject,@RequestParam("faculty") String faculty) {
		
		System.out.println("QuizId: "+quizid+" subject: "+subject+" faculty: "+faculty);
		model.addAttribute("subject",subject);
		
		List<Customer> cust = (List<Customer>) custrepo.findAll();
		List<String> noteid = new ArrayList<>();
		List<Customer> flist = new ArrayList<Customer>(); 
		HashSet<String> hstr = new HashSet<>();
		for (Customer custiter : cust) {
			System.out.println(custiter.getQuizid()+" user: "+custiter.getFirstName()+" seconname: "+custiter.getLastName());
			if(custiter.getQuizid().equalsIgnoreCase(quizid) && custiter.getSubject().equalsIgnoreCase(subject)&& custiter.getFaculty().equalsIgnoreCase(faculty)){
				System.out.println("--------------------------------------");
				System.out.println("Match found inside the if");
				System.out.println("QuizId: "+quizid+" subject: "+subject+" faculty: "+faculty);
				System.out.println(custiter.getQuizid()+" user: "+custiter.getFirstName()+" seconname: "+custiter.getLastName());
				System.out.println("--------------------------------------");
				
				if(!hstr.contains(custiter.getFirstName())){
					noteid.add(custiter.getFirstName());
					hstr.add(custiter.getFirstName());
					flist.add(custiter);
				}
			}
		}
		
		model.addAttribute("custlist",noteid);
		model.addAttribute("flist",flist);
		return "analytics/options2";
	}
	
	
	
	
	
	
	
	
}