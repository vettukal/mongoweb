package com.example.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GmobileController {
	@Autowired GmobileRepository repo;
	
	@RequestMapping(value = "/submitgmobile", method = RequestMethod.POST)
    public @ResponseBody Gmobile submitGmobile(@RequestBody Gmobile gmobile) {
		repo.save(gmobile);
		return gmobile;
	}
}