package com.example.gps.pothole2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.event.spi.PostDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.gps.GmobileRepository;

import com.example.gps.inter2.InterGPS2;
import com.example.gps.inter2.InterGPSRepository2;

import scala.collection.mutable.HashSet;


@Controller
public class CalcPothole2  {
	@Autowired GmobileRepository repo;
	@Autowired InterGPSRepository2 interrepo;
	@Autowired PotholeRepository2 potrepo;
	@Autowired PotholeDoubleRepository2 pdrepo;
	
	@RequestMapping(value="/calcpothole2", method=RequestMethod.GET)
    public @ResponseBody List<Pothole2> calcpothole() throws Exception {
		
		ArrayList<Pothole2> plist = new ArrayList<>();
	 
		HashSet<String> hs = new HashSet<>();
		List<Pothole2> potlist = potrepo.findAll();
		
		for (Pothole2 piter : potlist) {
			String append = piter.getLattitude()+"A"+piter.getLongitude()+"O";
			hs.add(append);
		}
		
		List<InterGPS2> iglist = interrepo.findAll();
		
		for (InterGPS2 interGPS2 : iglist) {
			System.out.println("interGPS2 inside the calcpothole2: "+interGPS2.getLattitude()+" : "+interGPS2.getLongitude());
		}
		
		for (InterGPS2 interGPS : iglist) {
			String latt = interGPS.getLattitude();
			String longi = interGPS.getLongitude();
			String diff = interGPS.getDiff();
			String gmobileId = interGPS.getGmobileId();
			
			String append = latt+"A"+longi+"O";
			
			if(hs.contains(append))
				continue;
			else {
				if(Double.parseDouble(diff)>1){
					hs.add(append);
					Pothole2 pothole = new Pothole2();
					pothole.setLattitude(latt);
					pothole.setLongitude(longi);
					pothole.setGmobileId(gmobileId);
					pothole.setDiff(diff);
					
					PotholeDouble2 potdouble = new PotholeDouble2();
					potdouble.setLattitude(Double.parseDouble(latt));
					potdouble.setLongitude(Double.parseDouble(longi));
					potdouble.setGmobileId(gmobileId);
					potdouble.setDiff(Double.parseDouble(diff));
					
					potrepo.save(pothole);
					pdrepo.save(potdouble);
					plist.add(pothole);
				}
			}
		}
		return plist;
	}
	
	@RequestMapping(value="/delpothole2", method=RequestMethod.GET)
    public @ResponseBody long delpothole() throws Exception {
	 
	 potrepo.deleteAll();
	 pdrepo.deleteAll();
	 
	 return System.currentTimeMillis();
 }
	
	
	
	@RequestMapping(value="/getpotholeparam2", method=RequestMethod.GET)
    public @ResponseBody List<PotholeDouble2> demovalsparam(@RequestParam("lattitude") Double latt, @RequestParam("longitude") Double longi) throws Exception {
		double latt1 = latt-.005;
		double latt2 = latt+.005;
		
		double longi1 = longi - .005;
		double longi2 = longi + .005;
		
		return pdrepo.findByLattitudeBetweenAndLongitudeBetween(latt1, latt2, longi1, longi2);
		//return pdrepo.findByLattitudeBetweenAndLongitudeBetween(20, 30, 40, 90);
		
		
	}
	
	@RequestMapping(value="/getpotholelatlngdec", method=RequestMethod.GET)
    public @ResponseBody List<PotholeDouble2> getpotholelatlngdec(@RequestParam("lattitude") Double latt, @RequestParam("longitude") Double longi,@RequestParam("dec") Double dec) throws Exception {
		
		double latt1 = latt-dec;
		double latt2 = latt+dec;
		
		double longi1 = longi - dec;
		double longi2 = longi + dec;
		
		return pdrepo.findByLattitudeBetweenAndLongitudeBetween(latt1, latt2, longi1, longi2);
		//return pdrepo.findByLattitudeBetweenAndLongitudeBetween(20, 30, 40, 90);
		
		
	}
	
	@RequestMapping(value="/getpothole2", method=RequestMethod.GET)
    public @ResponseBody List<Pothole2> getpothole() throws Exception {
		return potrepo.findAll();
		
	}
	
	
	@RequestMapping(value="/delnearltlgdec", method=RequestMethod.GET)
    public @ResponseBody List<PotholeDouble2> delnearltlgdec(@RequestParam("dec") Double dec) throws Exception {
		
		List<PotholeDouble2> list = pdrepo.findAll();
		List<PotholeDouble2> dellist = pdrepo.findAll();
		for (PotholeDouble2 anchor : list) {
			List<PotholeDouble2> nearlist = getpotholelatlngdec(anchor.getLattitude(),anchor.getLongitude(),dec);
			if(nearlist==null) continue;
			for (int i = 1; i < nearlist.size(); i++) {
				pdrepo.delete(nearlist.get(i));
				dellist.add(nearlist.get(i));
			}
		}
		return dellist;
		
	}
	
	
}