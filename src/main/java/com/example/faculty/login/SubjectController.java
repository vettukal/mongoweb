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

}
