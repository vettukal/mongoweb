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
public class FacultyLogin {
	@Autowired FacultyRepository repo;
	
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Faculty faculty,
    		final BindingResult mapping1BindingResult,
            final Model model, 
            final RedirectAttributes redirectAttributes) {
        model.addAttribute("faculty", faculty);
        List<Faculty> list = repo.findByEMail(faculty.geteMail());
        if(list.size()>0){
        	Faculty fiter = list.get(0);
        	if(fiter.getPassword().contentEquals(faculty.getPassword())){
        		redirectAttributes.addFlashAttribute("faculty", faculty);
        		return "redirect:home";
        	}
        	else
        		return "loginerror";
        }
        return "redirect:student";
    }

}