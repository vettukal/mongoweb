package com.example.faculty.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.faculty.Faculty;

@Controller
public class SubjectController 
{
	@RequestMapping(value="/subjectpage", method=RequestMethod.GET)
    public String greetingForm(@ModelAttribute Faculty faculty , @RequestParam(value = "item") String item) 
    {
		System.out.println(item);
        return "subject";
    }

}
