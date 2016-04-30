package com.example.gps.pothole;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gps.Gmobile;
import com.example.gps.GmobileRepository;
import com.example.gps.inter.InterGPS;
import com.example.gps.inter.InterGPSRepository;

import scala.collection.mutable.HashSet;


@Controller
public class CalcPothole  {
	@Autowired GmobileRepository repo;
	@Autowired InterGPSRepository interrepo;
	@Autowired PotholeRepository potrepo;
	@Autowired PotholeDoubleRepository pdrepo;
	
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
	
	@RequestMapping(value="/demovalpothole", method=RequestMethod.GET)
    public @ResponseBody PotholeDouble demovals() throws Exception {
		
		PotholeDouble pd = new PotholeDouble();
		pd.setGmobileId("5722ff4ee4b0d5fc7c1fbb0c");
		pd.setLattitude(28.5460402);
		pd.setLongitude(77.2682501);
		
		pd.setDiff(1.046165109291218);
		pdrepo.save(pd);
		
		pd = new PotholeDouble();
		pd.setGmobileId("5722ff4ee4b0d5fc7c1fbb0d");
		pd.setLattitude(28.5461402);
		pd.setLongitude(77.2685501);
		
		pd.setDiff(1.046165109291218);
		pdrepo.save(pd);
		
		pd = new PotholeDouble();
		pd.setGmobileId("5722ff4ee4b0d5fc7c1fbb0e");
		pd.setLattitude(29.5461402);
		pd.setLongitude(78.2685501);
		
		pd.setDiff(1.046165109291218);
		pdrepo.save(pd);
		
		pd = new PotholeDouble();
		pd.setGmobileId("5722ff4ee4b0d5fc7c1fbb10");
		pd.setLattitude(28.5561402);
		pd.setLongitude(77.2785501);
		
		pd.setDiff(1.046165109291218);
		pdrepo.save(pd);
		
		pd = new PotholeDouble();
		pd.setGmobileId("5722ff4ee4b0d5fc7c1fbb11");
		pd.setLattitude(28.5461409);
		pd.setLongitude(77.2685508);
		
		pd.setDiff(1.046165109291218);
		pdrepo.save(pd);
		
		return pd;
	}
	
	@RequestMapping(value="/getpotholeparam", method=RequestMethod.GET)
    public @ResponseBody List<PotholeDouble> demovalsparam(@RequestParam("lattitude") Double latt, @RequestParam("longitude") Double longi) throws Exception {
		double latt1 = latt-.005;
		double latt2 = latt+.005;
		
		double longi1 = longi - .005;
		double longi2 = longi + .005;
		
		return pdrepo.findByLattitudeBetweenAndLongitudeBetween(latt1, latt2, longi1, longi2);
		//return pdrepo.findByLattitudeBetweenAndLongitudeBetween(20, 30, 40, 90);
		
		
	}
	
}