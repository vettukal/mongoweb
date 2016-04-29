package com.example.gps.pothole;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gps.GmobileRepository;
import com.example.gps.inter.InterGPS;
import com.example.gps.inter.InterGPSRepository;

import scala.collection.mutable.HashSet;


@Controller
public class CalcPothole  {
	@Autowired GmobileRepository repo;
	@Autowired InterGPSRepository interrepo;
	@Autowired PotholeRepository potrepo;
	
	@RequestMapping(value="/calcpothole", method=RequestMethod.GET)
    public @ResponseBody List<Pothole> calcpothole() throws Exception {
		
		ArrayList<Pothole> plist = new ArrayList<>();
	 
		HashSet<String> hs = new HashSet<>();
		List<Pothole> potlist = potrepo.findAll();
		
		for (Pothole piter : potlist) {
			String append = piter.getLattitude()+"A"+piter.getLongitude()+"O";
			hs.add(append);
		}
		
		List<InterGPS> iglist = interrepo.findAll();
		
		for (InterGPS interGPS : iglist) {
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
					Pothole pothole = new Pothole();
					pothole.setLattitude(latt);
					pothole.setLongitude(longi);
					pothole.setGmobileId(gmobileId);
					pothole.setDiff(diff);
					
					potrepo.save(pothole);
					plist.add(pothole);
				}
			}
		}
		return plist;
	}
	
	@RequestMapping(value="/delpothole", method=RequestMethod.GET)
    public @ResponseBody long delpothole() throws Exception {
	 
	 potrepo.deleteAll();
	 
	 return System.currentTimeMillis();
 }
	
}