package com.example.gps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.repository.QuizSubmission;


@Controller
public class GmobileController implements GmobileSvc {
	@Autowired GmobileRepository repo;
	
	@RequestMapping(value = "/submitgmobile", method = RequestMethod.POST)
    public @ResponseBody Gmobile submitGmobile(@RequestBody Gmobile gmobile) {
		repo.save(gmobile);
		return gmobile;
	}

	@Override
	@RequestMapping(value = "/submitgmobilelist", method = RequestMethod.POST)
	public String submitGmobileList(List<Gmobile> mobile) {
		for (Gmobile gmobile : mobile) {
			repo.save(gmobile);
		}
		return "success";
	}

	
}