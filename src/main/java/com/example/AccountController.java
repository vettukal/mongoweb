package com.example;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.common.model.Shop;
import com.pcsma.midsem.SpringMongoConfig;
import com.pcsma.midsem.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {
	
	@Autowired
	CustomerRepository repository;
	
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Map<String, Object> hello(@RequestParam(value = "userid", defaultValue = "Boxfuse") String userid, 
    		@RequestParam(value = "link", defaultValue = "Boxfuse") String link) {
        
    	
    	// last name = userId;
    	// first name = link;
    	List<Customer> customers = repository.findByLastName(userid);
    	boolean found = false;
    	if(customers.size()>0){
    		found = true;
    	}
    	else{
    		repository.save(new Customer(link,userid));
    	}
    	Map<String, Object> result = new HashMap<>();
    	if(found){
    		result.put("greeting", "Found " + userid + "!");
    	}
    	
    	else {
    		result.put("greeting", "Invalid " + userid + "!");
    	}
        
        return result;
    }
    
    @RequestMapping(value = "/getaccount", method = RequestMethod.GET)
    public Map<String, Object> hello(@RequestParam(value = "userid", defaultValue = "Boxfuse") String userid
    		, HttpServletResponse httpServletResponse) {
        
    	
    	// last name = userId;
    	// first name = link;
    	List<Customer> customers = repository.findByLastName(userid);
    	boolean found = false;
    	if(customers.size()>0){
    		found = true;
    	}
    	
    	Map<String, Object> result = new HashMap<>();
    	if(found){
    		result.put("greeting", "Found " + userid + "!");
    		//httpServletResponse.setHeader("Location", "https://www.google.co.in");
    		
    	}
    	
    	else {
    		result.put("greeting", "Invalid " + userid + "!");
    	}
        
        return result;
    }
    
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "http://www.google.co.in");
    }
    
    @RequestMapping(value = "/redirect2", method = RequestMethod.GET)
    public ModelAndView method(@RequestParam(value = "userid", defaultValue = "Boxfuse") String userid
    		   ) {
    	// last name = userId;
    	// first name = link;
    	List<Customer> customers = repository.findByLastName(userid);
    	boolean found = false;
    	if(customers.size()>0){
    		found = true;
    	}
    	
    	Map<String, Object> result = new HashMap<>();
    	if(found){
    		
    		return new ModelAndView("redirect:" + "http://www.google.co.in");
    		
    	}
    	
    	else {
    		return new ModelAndView("redirect:" + "http://www.bing.com");
    	}
        
        
            //return new ModelAndView("redirect:" + "http://www.google.co.in");

    }
    
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
    @RequestMapping(value = "/getallmongo", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllmongo() {
    	
    	List<User> luser = mongoOperation.findAll(User.class);
    	return luser;
        //httpServletResponse.setHeader("Location", "http://www.google.co.in");
    }
    
    @RequestMapping(value = "/getjson", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> json(@RequestParam(value = "userid", defaultValue = "Boxfuse") String userid
    		, HttpServletResponse httpServletResponse) {
        
    	
    	// last name = userId;
    	// first name = link;
    	List<Customer> customers = repository.findByLastName(userid);
    	boolean found = false;
    	if(customers.size()>0){
    		found = true;
    	}
    	
    	String result = "";
    	if(found){
    		result = "{\"result\": \""+ customers.get(0).getFirstName()+ "\"}";
    		//httpServletResponse.setHeader("Location", "https://www.google.co.in");
    		
    	}
    	
    	else {
    		result = "{\"result\": \"\"}";
    	}
    	final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(result, httpHeaders, HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/mykong/{name}", method = RequestMethod.GET)
    public @ResponseBody Shop getShopInJSON2(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
		
		return shop;

	}
    
    @RequestMapping(value="/vince/{name}", method = RequestMethod.GET)
    public @ResponseBody Customer getCustomerInJSON2(@PathVariable String name) {

		Shop shop = new Shop();
		Customer customer = new Customer();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
		
		
		String userid = name;
		// last name = userId;
    	// first name = link;
    	List<Customer> customers = repository.findByLastName(userid);
    	boolean found = false;
    	if(customers.size()>0){
    		found = true;
    	}
    	
    	String result = "";
    	if(found){
    		result = "{\"result\": \""+ customers.get(0).getFirstName()+ "\"}";
    		customer = customers.get(0);
    		//httpServletResponse.setHeader("Location", "https://www.google.co.in");
    		
    	}
    	
    	else {
    		result = "{\"result\": \"\"}";
    		customer = new Customer("", userid);
    	}
    	
		
		
		return customer;

	}
    

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public @ResponseBody Iterable<Customer> getAll() {
    	return repository.findAll();
        //httpServletResponse.setHeader("Location", "http://www.google.co.in");
    }
}
