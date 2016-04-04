package com.example.quiz.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.sql.HSQLCaseFragment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.faculty.Faculty;
import com.example.faculty.FacultyRepository;
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
        if(qd.getAnon()!=null){
        	if(qd.getAnon().equalsIgnoreCase("anon")){
            	// we have to make two qm and quizsub as anon@anon.com
            	qm.setEmail("anon@anon.com");
            	quizsub.setEmail("anon@anon.com");
            }
        }
        
        
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

	@Override
	@RequestMapping(value="/getaverage", method=RequestMethod.GET)
	public @ResponseBody Float getDone(@RequestParam("subject") String subject) {
		List<QuizMarks> qmlist = markrepo.findBySubject(subject);
		Float correct = (float) 0.0;
		Float total = (float) 0.0;
		for (QuizMarks qiter : qmlist) {
			if(qiter==null)
				continue;
			if(qiter.getMarks()==null)
				continue;
			if(qiter.getMarks()==1)
				correct++;
			total++;
		}
		return correct/total;
	}

	@Autowired
	FacultyRepository facrepo;
	
	@Override
	@RequestMapping(value="/getsubjects", method=RequestMethod.GET)
	public @ResponseBody List<String> getSubject(@RequestParam("subject") String subject) {
		List<Faculty> list = facrepo.findAll();
		List<String> subjects = new ArrayList<String>();
		
		HashSet<String> hs = new HashSet();
		subjects.add("pcsma");
		for (Faculty faculty : list) {
			System.out.println(faculty);
			List<String> subiterlist = faculty.getSubjectlist();
			if(subiterlist!=null){
				for (String siter : subiterlist) {
					hs.add(siter);
					System.out.println(siter);
				}
			}
		}
		
		for (String siter : hs) {
			subjects.add(siter);
		}
		/**
		for (Faculty faciter : list) {
			if(faciter!=null){
				for (String siter : faciter.getSubjectlist()) {
					if(siter!=null){
						subjects.add(siter);
					}
					
				}
			}
			
		}
		*/
		return subjects;
	}

	@Override
	@RequestMapping(value="/getstudsubjects", method=RequestMethod.GET)
	public List<String> getStudSubject(@RequestParam("subject") String subject) {
//		
//		List<Student> studlist = studrepo.findAll();
//		for (Student student : studlist) {
//			if(student.getEmail()==null){
//				continue;
//			}
//			if(student.getSubjects()==null)
//				continue;
//				
//			if(student.getEmail().equalsIgnoreCase(subject)){
//				return student.getSubjects();
//			}
//		}
		return null;
	}
	
	@Override
	@RequestMapping(value="/getaverage2done", method=RequestMethod.GET)
	public @ResponseBody List<String> getDone2(@RequestParam("subject") String subject) {
		
		List<Student> studlist = studrepo.findAll();
		for (Student student : studlist) {
			if(student.getEmail()==null){
				continue;
			}
			if(student.getSubjects()==null)
				continue;
				
			if(student.getEmail().equalsIgnoreCase(subject)){
				return student.getSubjects();
			}
		}
		return null;
	}

    

}