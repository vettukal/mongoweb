package com.example.faculty.signup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

@SessionAttributes("mycounter")
public class CounterController {

  // Checks if there's a model attribute 'mycounter', if not create a new one.
  // Since 'mycounter' is labelled as session attribute it will be persisted to
  // HttpSession
  @RequestMapping(value="counterget",method = RequestMethod.GET)
  public String get(Model model) {
    if(!model.containsAttribute("mycounter")) {
      model.addAttribute("mycounter", new MyCounter(25));
    }
    return "redirect:/counterpost";
  }

  // Obtain 'mycounter' object for this user's session and increment it
  @RequestMapping(value="counterpost",method = RequestMethod.GET)
  public String post(@ModelAttribute("mycounter") MyCounter myCounter) {
    myCounter.increment();
    System.out.println(myCounter.number);
    return "redirect:/register/faculty2";
  }
}