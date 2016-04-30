package com.example.gps.inter2;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gps.Gmobile;
import com.example.gps.GmobileRepository;
import com.example.quiz.repository.QuizDetails;
import com.example.quiz.repository.QuizSubmission;


@Controller
public class CalcInter2  {
	@Autowired GmobileRepository repo;
	@Autowired InterGPSRepository2 interrepo;
	
	

	

	 
	 @RequestMapping(value="/delinter2", method=RequestMethod.GET)
	    public @ResponseBody long delinter() throws Exception {
		 
		 interrepo.deleteAll();
		 
		 return System.currentTimeMillis();
	 }
	 
//	 @RequestMapping(value="/demovals", method=RequestMethod.GET)
//	    public @ResponseBody Gmobile demovals() throws Exception {
//		 
//		 Gmobile gm1 = new Gmobile();
//		 gm1.setXaxis("1.04387199878693");
//		 gm1.setYaxis("8.14028549194336");
//		 gm1.setZaxis("8.16901588439941");
//		 
//		 gm1.setLattitude("28.5464372");
//		 gm1.setLongitude("77.2644328");
//		 
//		 repo.save(gm1);
//		 
//		 gm1 = new Gmobile();
//		 gm1.setXaxis("1.8674772977829");
//		 gm1.setYaxis("9.03092861175537");
//		 gm1.setZaxis("8.41801357269287");
//		 
//		 gm1.setLattitude("28.5464372");
//		 gm1.setLongitude("77.2694328");
//		 
//		 repo.save(gm1);
//		 
//		 gm1 = new Gmobile();
//		 gm1.setXaxis("1.33117616176605");
//		 gm1.setYaxis("6.6271505355835");
//		 gm1.setZaxis("9.73003578186035");
//		 
//		 gm1.setLattitude("28.5468372");
//		 gm1.setLongitude("77.2594328");
//		 
//		 repo.save(gm1);
//		 
//		 gm1 = new Gmobile();
//		 gm1.setXaxis("0.24899697303772");
//		 gm1.setYaxis("2.00155258178711");
//		 gm1.setZaxis("9.79707336425781");
//		 
//		 gm1.setLattitude("28.5464372");
//		 gm1.setLongitude("77.2694328");
//		 
//		 repo.save(gm1);
//		 
//		 gm1 = new Gmobile();
//		 gm1.setXaxis("0.24899697303772");
//		 gm1.setYaxis("3.00155258178711");
//		 gm1.setZaxis("7.79707336425781");
//		 
//		 gm1.setLattitude("28.5464362");
//		 gm1.setLongitude("77.2694348");
//		 
//		 repo.save(gm1);
//		 
//		 return gm1;
//		 
//	 }
	 
	 @RequestMapping(value = "/submitinter2", method = RequestMethod.POST)
	    public @ResponseBody InterGPS2 submitInter(@RequestBody InterGPS2 quizsub) {
			
			interrepo.save(quizsub);
			return quizsub;
			
		}
	 
	 @RequestMapping(value = "/submitinterlist2", method = RequestMethod.POST)
	    public @ResponseBody List<InterGPS2> submitInterList(@RequestBody List<InterGPS2> quizsublist) {
			
		 for (InterGPS2 quizsub : quizsublist) {
			 interrepo.save(quizsub);
		}
			
			
			return quizsublist;
			
		}
	 
	 
	 
	 

	
}