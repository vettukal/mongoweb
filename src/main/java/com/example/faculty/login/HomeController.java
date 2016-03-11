package com.example.faculty.login;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String greetingForm(@ModelAttribute Faculty faculty, 
    		final BindingResult mapping1BindingResult,
            final Model model) {
        model.addAttribute("faculty", faculty);
        System.out.println("home controller: "+faculty.geteMail());
        return "home";
    }

    

}