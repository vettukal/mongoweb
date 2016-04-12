package com.example.faculty.login;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
import com.example.faculty.Faculty;
import com.example.quiz.repository.QuizDetails;
import com.example.quiz.repository.QuizDetailsRepository;

@Controller
public class SubjectController 
{
	@Autowired QuizDetailsRepository detailrepo;
	@RequestMapping(value="/subjectpage", method=RequestMethod.GET)
    public String greetingForm(@ModelAttribute Faculty faculty , @RequestParam(value = "item") String item ,  Model model) 
    {
		model.addAttribute("subject" , item);
		
		System.out.println(item);
		
		List<QuizDetails> qdlist = detailrepo.findAll();
		HashSet<Integer> hs = new HashSet<>();
		for (QuizDetails qiter : qdlist) {
			hs.add(qiter.getQuizId());
		}
		
		ArrayList<Integer> qidlist = new ArrayList<>();
		for (Integer iter : hs) {
			qidlist.add(iter);
		}
		Collections.sort(qidlist);
		model.addAttribute("qlist",qidlist);
        return "subject";
    }
	
	@RequestMapping(value="/subjectpage2", method=RequestMethod.GET)
    public String greetingForm2(@ModelAttribute Faculty faculty , @RequestParam(value = "item") String item ,  Model model) 
    {
		model.addAttribute("subject" , item);
		
		System.out.println(item);
		
		List<QuizDetails> qdlist = detailrepo.findAll();
		HashSet<Integer> hs = new HashSet<>();
		for (QuizDetails qiter : qdlist) {
			hs.add(qiter.getQuizId());
		}
		
		ArrayList<Integer> qidlist = new ArrayList<>();
		for (Integer iter : hs) {
			qidlist.add(iter);
		}
		Collections.sort(qidlist);
		model.addAttribute("qlist",qidlist);
        return "subject";
    }
	
	@Autowired
	CustomerRepository custrepo;
	@RequestMapping(value="/subjectpage3", method=RequestMethod.GET)
    public String greetingFor3(@ModelAttribute Faculty faculty , @RequestParam(value = "item") String item ,   @RequestParam(value = "email") String email ,Model model) 
    {
		model.addAttribute("subject" , item);
		model.addAttribute("email",email);
		System.out.println("Email inside the subjectpage3 is:"+email);
		System.out.println(item);
		
		List<QuizDetails> qdlist = detailrepo.findAll();
		HashSet<Integer> hs = new HashSet<>();
		for (QuizDetails qiter : qdlist) {
			hs.add(qiter.getQuizId());
		}
		
		ArrayList<Integer> qidlist = new ArrayList<>();
		for (Integer iter : hs) {
			qidlist.add(iter);
		}
		Collections.sort(qidlist);
		model.addAttribute("qlist",qidlist);
		
		List<Customer> custlist = (List<Customer>) custrepo.findAll();
		List<Integer> finallist =  new ArrayList<>();
		for (Customer cust : custlist) {
			System.out.println(cust.getFaculty() +" : "+cust.getQuizid() +" : "+cust.getSubject());
		}
		
		HashSet<Integer> hashset = new HashSet<>();
		for (Customer customer : custlist) {
			if(customer.getFaculty().equalsIgnoreCase(email)&& customer.getSubject().equalsIgnoreCase(item)){
				System.out.println("Inside the double if condition satisfied");
				System.out.println(customer.getFaculty() +" : "+customer.getQuizid() +" : "+customer.getSubject());
				int cqid = Integer.parseInt(customer.getQuizid());
				if(!hs.contains(cqid)){
					hs.add(cqid);
					finallist.add(Integer.parseInt(customer.getQuizid()));
				}
				
			}
		}
		
		model.addAttribute("custlist",finallist);
		for (Integer integer : finallist) {
			System.out.println("finallist: "+integer);
		}
        return "subject2";
    }

}
