package com.example.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.repository.QuizDetails;
import com.example.quiz.repository.QuizDetailsRepository;
import com.example.quiz.repository.QuizMarks;
import com.example.quiz.repository.QuizMarksRepository;
//import com.example.quiz.repository.QuizMarks;
//import com.example.quiz.repository.QuizMarksRepository;
import com.example.quiz.repository.QuizSubmission;
import com.example.quiz.repository.QuizSubmissionRepository;
import com.example.student.repository.Student;
import com.example.student.repository.StudentRepository;

import retrofit.http.GET;
import retrofit.http.Query;



@Controller
public class ActiveQuizController implements QuizSvc{
	@Autowired QuizDetailsRepository repo;
	@Autowired StudentRepository studrepo;
	@Autowired QuizSubmissionRepository subrepo;
	@Autowired QuizMarksRepository markrepo;
    @RequestMapping(value="/activequiz", method=RequestMethod.GET)
    public @ResponseBody QuizDetails greetingForm(@RequestParam("email") String email) {
    	Long time = System.currentTimeMillis();
        List<QuizDetails> qdlist = repo.findByEndingTimeGreaterThan(time);
        
        List<Student> studlist = studrepo.findByEmail(email);
        List<String> subjects = studlist.get(0).getSubjects();
        
        for(QuizDetails qiter : qdlist){
        	for(String siter : subjects){
        		if(siter.equalsIgnoreCase(qiter.getSubject()))
        			return qiter;
        	}
        }
        
        return null;
    }
    
    @RequestMapping(value = "/submitquiz", method = RequestMethod.POST)
    public @ResponseBody QuizSubmission submitQuiz(@RequestBody QuizSubmission quizsub) {
        Long time = System.currentTimeMillis();
        
    	QuizMarks qm = new QuizMarks();
    	qm.setEmail(quizsub.getEmail());
    	qm.setQuizId(quizsub.getQuizId());
    	qm.setRollNo(quizsub.getRollNo());
    	qm.setSubject(quizsub.getSubject());
    	
    	String subject = quizsub.getSubject();
        Integer quizId = quizsub.getQuizId();
        List<QuizDetails> qdlist = repo.findByQuizIdAndSubject(quizId, subject);
        QuizDetails qd = qdlist.get(0);
        if(qd.getEndingTime()<time){
        	return null;
        }
        String answer = qd.getAnswer();
        if(quizsub.getOption().equalsIgnoreCase(answer)){
        	qm.setMarks(1);
        }
        else{
        	qm.setMarks(0);
        }
        
        System.out.println("this is markrepo save:"+markrepo.save(qm));
    	return subrepo.save(quizsub);
    }
    
    @RequestMapping(value="/getmarks", method=RequestMethod.GET)
	public @ResponseBody List<QuizMarks> getMarks(@RequestParam("subject") String subject
			,@RequestParam("email") String email){
    	
    	return markrepo.findBySubjectAndEmail(subject, email);
    }

	@Override
	@RequestMapping(value="/isdone", method=RequestMethod.GET)
	public @ResponseBody Boolean isDone(@RequestParam("email") String email) {
		QuizDetails qd = greetingForm(email);
		if(qd==null)
			return false;
		List<QuizSubmission> qs = subrepo.findByQuizIdAndSubjectAndEmail(qd.getQuizId(), qd.getSubject(), email);
		if(qs.size()>0)
			return true;
		else
			return false;
	}

    

}