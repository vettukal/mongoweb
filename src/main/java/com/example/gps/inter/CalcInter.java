package com.example.gps.inter;

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
public class CalcInter  {
	@Autowired GmobileRepository repo;
	@Autowired InterGPSRepository interrepo;
	
	

	
//	@RequestMapping(value = "/submitgmobilelist", method = RequestMethod.POST)
//	public @ResponseBody String submitGmobileList(@RequestBody List<Gmobile> mobile) {
//		for (Gmobile gmobile : mobile) {
//			repo.save(gmobile);
//		}
//		return "success";
//	}
	
	 @RequestMapping(value="/calcinter", method=RequestMethod.GET)
	    public @ResponseBody long greetingForm() throws Exception {
		 
		 long starttime = System.currentTimeMillis();
		 
		 List<Gmobile> gmlist = repo.findAll();
		 
		 String[] gmids = new String[gmlist.size()];
		 for (int i = 0; i < gmids.length; i++) {
			gmids[i] = gmlist.get(i).getId();
		 }
		 
		 List<InterGPS> iglist = interrepo.findAll();
		 HashSet<String> hs = new HashSet<>();
		 for (InterGPS interGPS : iglist) {
			hs.add(interGPS.getGmobileId());
		}
		 
		 for (int i = 0; i < gmids.length; i++) {
			if(hs.contains(gmids[i]))
				continue;
			else {
				InterGPS intergps = new InterGPS();
				Gmobile giter = gmlist.get(i);
				
				if(!gmids[i].equalsIgnoreCase(giter.getId())){
					throw new Exception();
				}
				
				intergps.setGmobileId(giter.getId());
				intergps.setXaxis(giter.getXaxis());
				intergps.setYaxis(giter.getYaxis());
				intergps.setZaxis(giter.getZaxis());
				intergps.setLattitude(giter.getLattitude());
				intergps.setLongitude(giter.getLongitude());
				
				double xaxis = Double.parseDouble(giter.getXaxis());
				double yaxis = Double.parseDouble(giter.getYaxis());
				double zaxis = Double.parseDouble(giter.getZaxis());
				
				
				intergps.setX2(xaxis*xaxis+"");
				intergps.setY2(yaxis*yaxis+"");
				intergps.setZ2(zaxis*zaxis+"");
				
				double sum = xaxis*xaxis+yaxis*yaxis+zaxis*zaxis;
				double squareroot = Math.sqrt(sum);
				
				intergps.setSquaresum(squareroot+"");
				if(i==0){
					intergps.setDiff("0");
				}
				else{
					List<InterGPS> iglastlist = interrepo.findAll();
					InterGPS lastinter = iglastlist.get(iglastlist.size()-1);
					
					double lastsqrt = Double.parseDouble(lastinter.getSquaresum());
					double diff = Math.abs(squareroot - lastsqrt);
					
					intergps.setDiff(diff+"");
				}
				
				interrepo.save(intergps);
				
			}
				
		}
		 long endtime = System.currentTimeMillis();
		 return endtime - starttime;
				 
	 }
	 
	 @RequestMapping(value="/delinter", method=RequestMethod.GET)
	    public @ResponseBody long delinter() throws Exception {
		 
		 interrepo.deleteAll();
		 
		 return System.currentTimeMillis();
	 }
	 
	 @RequestMapping(value="/demovals", method=RequestMethod.GET)
	    public @ResponseBody Gmobile demovals() throws Exception {
		 
		 Gmobile gm1 = new Gmobile();
		 gm1.setXaxis("1.04387199878693");
		 gm1.setYaxis("8.14028549194336");
		 gm1.setZaxis("8.16901588439941");
		 
		 gm1.setLattitude("28.5464372");
		 gm1.setLongitude("77.2644328");
		 
		 repo.save(gm1);
		 
		 gm1 = new Gmobile();
		 gm1.setXaxis("1.8674772977829");
		 gm1.setYaxis("9.03092861175537");
		 gm1.setZaxis("8.41801357269287");
		 
		 gm1.setLattitude("28.5464372");
		 gm1.setLongitude("77.2694328");
		 
		 repo.save(gm1);
		 
		 gm1 = new Gmobile();
		 gm1.setXaxis("1.33117616176605");
		 gm1.setYaxis("6.6271505355835");
		 gm1.setZaxis("9.73003578186035");
		 
		 gm1.setLattitude("28.5468372");
		 gm1.setLongitude("77.2594328");
		 
		 repo.save(gm1);
		 
		 gm1 = new Gmobile();
		 gm1.setXaxis("0.24899697303772");
		 gm1.setYaxis("2.00155258178711");
		 gm1.setZaxis("9.79707336425781");
		 
		 gm1.setLattitude("28.5464372");
		 gm1.setLongitude("77.2694328");
		 
		 repo.save(gm1);
		 
		 gm1 = new Gmobile();
		 gm1.setXaxis("0.24899697303772");
		 gm1.setYaxis("3.00155258178711");
		 gm1.setZaxis("7.79707336425781");
		 
		 gm1.setLattitude("28.5464362");
		 gm1.setLongitude("77.2694348");
		 
		 repo.save(gm1);
		 
		 return gm1;
		 
	 }
	 
	 @RequestMapping(value = "/submitinter", method = RequestMethod.POST)
	    public @ResponseBody InterGPS submitInter(@RequestBody InterGPS quizsub) {
			
			interrepo.save(quizsub);
			return quizsub;
			
		}
	 
	 @RequestMapping(value = "/submitinterlist", method = RequestMethod.POST)
	    public @ResponseBody List<InterGPS> submitInterList(@RequestBody List<InterGPS> quizsublist) {
			
		 for (InterGPS quizsub : quizsublist) {
			 interrepo.save(quizsub);
		}
			
			
			return quizsublist;
			
		}
	 
	 
	 
	 

	
}