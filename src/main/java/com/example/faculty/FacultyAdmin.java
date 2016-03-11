package com.example.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class FacultyAdmin {
	@Autowired FacultyRepository repo;
	
    @RequestMapping(value="/register/faculty", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "registerfaculty";
    }

    @RequestMapping(value="/register/faculty", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Faculty faculty, Model model) {
        model.addAttribute("faculty", faculty);
        System.out.println(faculty.geteMail());
        System.out.println(faculty.getSubjectlist());
        
        repo.save(faculty);
        return "successregister";
    }

}