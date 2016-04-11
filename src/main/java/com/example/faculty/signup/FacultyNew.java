package com.example.faculty.signup;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.faculty.Faculty;
import com.example.faculty.FacultyRepository;



@Controller
@SessionAttributes("mycounter")
public class FacultyNew {
	@Autowired FacultyRepository repo;
	
	
	
    @RequestMapping(value="/register/faculty2", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        //model.addAttribute("faculty", new Faculty());
    	if(!model.containsAttribute("mycounter")) {
    	      model.addAttribute("mycounter", new MyCounter(50));
    	    }
    	SecondPage spage = SecondPage.getInstance();
        model.addAttribute("spage",spage);
        return "signup/multi1";
    }

    @RequestMapping(value="/register/faculty2", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute("mycounter") MyCounter myCounter,@ModelAttribute SecondPage spage, final BindingResult mapping1BindingResult,
            final Model model, 
            final RedirectAttributes redirectAttributes) {
    	
    	
    	
        model.addAttribute("spage", spage);
        System.out.println(spage.getEmail());
        System.out.println(spage.getPassword());
        System.out.println(spage.getPassword2());
        
        myCounter.setEmail(spage.getEmail());
        myCounter.setPassword(spage.getPassword());
        
        if(!spage.getPassword().contentEquals(spage.getPassword2())){
        	return "signup/errorpass";
        }
        
//        repo.save(faculty);
        //redirectAttributes.addFlashAttribute("fpage", fpage);
        model.addAttribute("spage", spage);
        //model.addAttribute("semail",fpage.getEmail());
        //model.addAttribute("spass",fpage.getPassword());
		//return "redirect:/register/faculty3";
        return "signup/multi2";
        //return "redirect:/register/faculty3";
    }
    
    /**
    @RequestMapping(value="/register/faculty3", method=RequestMethod.GET)
    public String greetingFormPage3(Model model) {
        //model.addAttribute("faculty", new Faculty());
    	System.out.println("888888888 inside the second page GET");
        
        String semail = (String) model.asMap().get("semail");
        String spass = (String) model.asMap().get("spass");
        
        System.out.println("email:"+semail);
        System.out.println("pass:"+spass);
        model.addAttribute("spage", new SecondPage());
        model.addAttribute("femail",semail);
        
        return "signup/multi2";
    }
    */
    @RequestMapping(value="/register/faculty3", method=RequestMethod.POST)
    public String greetingSubmitPage2(@ModelAttribute("mycounter") MyCounter myCounter,@ModelAttribute SecondPage spage, final BindingResult mapping1BindingResult,
            final Model model, 
            final RedirectAttributes redirectAttributes) {
        model.addAttribute("spage", spage);
        
        System.out.println("888888888 inside the second page POST");
        System.out.println("spage email:"+spage.getEmail());
        System.out.println("spage pass:"+spage.getPassword());
        
        System.out.println(spage.getFirstName());
        System.out.println(spage.getLastName());
        
        myCounter.setFirstName(spage.getFirstName());
        myCounter.setLastName(spage.getLastName());
        
        
        
//        repo.save(faculty);
        redirectAttributes.addFlashAttribute("spage", spage);
        model.addAttribute("tpage", new ThirdPage());
		//return "redirect:/register/faculty3";
		
        return "signup/multi3";
    }
    
    @RequestMapping(value="/register/faculty4", method=RequestMethod.POST)
    public String greetingSubmitPage3(@ModelAttribute("mycounter") MyCounter myCounter,@ModelAttribute ThirdPage tpage, final BindingResult mapping1BindingResult,
            final Model model, 
            final RedirectAttributes redirectAttributes) {
       // model.addAttribute("spage", spage);
        
        System.out.println("888888888 inside the Third page POST");
        System.out.println("spage email:"+tpage.getSubject1());
        //System.out.println("spage pass:"+spage.getPassword());
         
        //System.out.println(spage.getFirstName());
        //System.out.println(spage.getLastName());
        
        myCounter.setSubject1(tpage.getSubject1());
        myCounter.setSubject2(tpage.getSubject2());
        myCounter.setSubject3(tpage.getSubject3());
        myCounter.setSubject4(tpage.getSubject4());
        myCounter.setSubject5(tpage.getSubject5());
        

        
		//return "redirect:/register/faculty3";
		
        return "redirect:/register/counterfinal";
    }
    
    @RequestMapping(value="/register/counterfinal", method=RequestMethod.GET)
    public String greetingFormCounter(@ModelAttribute("mycounter") MyCounter myCounter, Model model) {
        //model.addAttribute("faculty", new Faculty());
    	 myCounter.increment();
    	    System.out.println(myCounter.number);
    	    System.out.println(myCounter.getEmail());
    	    System.out.println(myCounter.getPassword());
    	    System.out.println(myCounter.getFirstName());
    	    System.out.println(myCounter.getLastName());
    	    System.out.println(myCounter.getSubject1());
    	    System.out.println(myCounter.getSubject2());
    	    System.out.println(myCounter.getSubject3());
    	   
    	    Faculty fac = new Faculty();
    	    fac.seteMail(myCounter.getEmail());
    	    fac.setName(myCounter.getFirstName()+" "+myCounter.getLastName());
    	    fac.setPassword(myCounter.getPassword());
    	    
    	    ArrayList<String> sublist = new ArrayList<>();
    	    
    	    if(!myCounter.getSubject1().contentEquals("")){
    	    	sublist.add(myCounter.getSubject1());
    	    }
    	    if(!myCounter.getSubject2().contentEquals("")){
    	    	sublist.add(myCounter.getSubject2());	
    	    }
    	    if(!myCounter.getSubject3().contentEquals("")){
    	    	sublist.add(myCounter.getSubject3());
    	    }
    	    if(!myCounter.getSubject4().contentEquals("")){
    	    	sublist.add(myCounter.getSubject4());
    	    }
    	    if(!myCounter.getSubject5().contentEquals("")){
    	    	sublist.add(myCounter.getSubject5());
    	    }
    	    
    	    fac.setSubjectlist(sublist);
    	    System.out.println(myCounter.getSubject4());
    	    System.out.println(myCounter.getSubject5());
    	    repo.save(fac);
    	    return "signup/success2";
    	
       
      
    }
    
    
    
    
    /**
    @RequestMapping(value="/logOutex", method = RequestMethod.GET )
    public String logOut(Model model, RedirectAttributes redirectAttributes)  {
        redirectAttributes.addFlashAttribute("message", "success logout");
        System.out.println("/logOut");
        return "redirect:/homeex";
    }
    
    @RequestMapping(value="/homeex", method = RequestMethod.GET )
    public String showHomePage(Model model)  {
    	 String some = (String) model.asMap().get("message");
    	System.out.println("inside the showhomepage homeex: "+some);
        return "/register/faculty2";
    }
	*/
}