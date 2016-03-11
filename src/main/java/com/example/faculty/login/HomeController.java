package com.example.faculty.login;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.faculty.Faculty;
import com.example.faculty.FacultyRepository;





@Controller
public class HomeController {
	@Autowired FacultyRepository repo;
	
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String greetingForm(@ModelAttribute Faculty faculty, Model model) {
        model.addAttribute("faculty", faculty);
        System.out.println(faculty.geteMail());
        return "home";
    }

    

}