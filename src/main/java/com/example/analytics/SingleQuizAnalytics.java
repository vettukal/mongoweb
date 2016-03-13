package com.example.analytics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quiz.repository.QuizMarks;
import com.example.quiz.repository.QuizMarksRepository;
import com.example.quiz.repository.QuizSubmission;
import com.example.quiz.repository.QuizSubmissionRepository;

@Controller
public class SingleQuizAnalytics {
	@Autowired QuizSubmissionRepository repo;
	@Autowired QuizMarksRepository markrepo;
	@RequestMapping(value="/get_quiz_stat", method=RequestMethod.GET)
    public String getQuizStat(Model model,@RequestParam("quizid") Integer quizid,@RequestParam("subject") String subject) {
		List<QuizSubmission> qmlist = repo.findByQuizIdAndSubject(quizid, subject);
		String[] labels = {"A","B","C","D"};
		for (int i = 0; i < labels.length; i++) {
			//labels[i] = "\""+labels[i]+"\"";
		}
		Integer[] data = new Integer[4];
		data[0]=0;
		data[1]=0;
		data[2]=0;
		data[3]=0;
		
		for (QuizSubmission quizSubmission : qmlist) {
			if(quizSubmission.getOption()==null)
				continue;
			if(quizSubmission.getOption().equalsIgnoreCase("a")){
				data[0]++;
			}
			else if(quizSubmission.getOption().equalsIgnoreCase("b")){
				data[1]++;
			}
			else if(quizSubmission.getOption().equalsIgnoreCase("c")){
				data[2]++;
			}
			else if(quizSubmission.getOption().equalsIgnoreCase("d")){
				data[3]++;
			}
		}
		
		int total = 0;
		for (Integer iter : data) {
			total += iter;
		}
		for (int i = 0; i < data.length; i++) {
			if(total==0) continue;
			data[i] = (data[i]*100)/total;
		}
		model.addAttribute("labelpr","ABCD");
		model.addAttribute("datapr",Arrays.toString(data));
		model.addAttribute("arrayString",labels);
		model.addAttribute("arrayData",data);
		model.addAttribute("subject",subject);
		model.addAttribute("quizid",quizid);
		
		
		
		return "analytics/options";
	}
	
	@RequestMapping(value="/get_sem_stat", method=RequestMethod.GET)
	public String getSemester(Model model,@RequestParam("subject") String subject) {
		
		// we have to map the percentage of students who have correct or incorrect.
		// we will have to use the mark repository.
		
		
		HashSet<Integer> hs = new HashSet<>();
		HashMap<Integer,Integer> hmcorrect = new HashMap<>();
		HashMap<Integer, Integer> hmwrong = new HashMap<>();
		
		List<QuizMarks> qm = markrepo.findBySubject(subject);
		for (QuizMarks qiter : qm) {
			if(qiter.getMarks()==null)
				continue;
			
			Integer id = qiter.getQuizId();
			hs.add(id);
			
			
			if(qiter.getMarks()==1){
				if(hmcorrect.get(id)==null){
					hmcorrect.put(id, 1);
				}
				else{
					int value = hmcorrect.get(id);
					hmcorrect.put(id, value+1);
				}
			}
			
			else {
				if(hmwrong.get(id)==null){
					hmwrong.put(id, 1);
				}
				else {
					int value = hmwrong.get(id);
					hmwrong.put(id, value+1);
				}
			}
		}
		
		// loop through hs and hm
		for (Map.Entry<Integer, Integer> entry : hmcorrect.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println("hmcorrect: "+key+" : "+value);
		}
		
		for (Map.Entry<Integer, Integer> entry : hmwrong.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println("hmwrong: "+key+" : "+value);
		}
		
		for (Integer iter : hs) {
			System.out.println("hs :"+iter);
		}
		
		Integer[] cdata = new Integer[hs.size()];
		Integer[] wdata = new Integer[hs.size()];
		
		for (int i = 0; i < wdata.length; i++) {
			wdata[i] = 0;
			cdata[i] = 0;
		}
		
		int i =0;
		if(hmcorrect==null)
			System.out.println("hmcorrect is null");
		
		//System.out.println(hs.contains(304));
		//System.out.println(hmcorrect.get(304));
		String[] labels = new String[hs.size()];
		for (Integer key : hs) {
			System.out.println("the key from hs: "+key);
			if(key==null)
				continue;
			Integer cor = hmcorrect.get(key);
			Integer wro = hmwrong.get(key);
			if(cor==null || wro==null){
				if(cor==null)
					cor = 0;
				else if(wro==null)
					wro = 0;
				else 
					continue;
			}
		
			int total = cor+wro;
			if((cor+wro) == 0)
				continue;
			
			System.out.println("cor: "+cor);
			System.out.println("wro: "+wro);
			cdata[i] = (cor*100)/total;
			wdata[i] = (wro*100)/total;
			labels[i] = key.toString();
			i++;
		}
		
		
		
		
		
		System.out.println("Labels: "+Arrays.toString(labels));
		System.out.println("cdata: "+Arrays.toString(cdata));
		System.out.println("wdata: "+Arrays.toString(wdata));
		model.addAttribute("arrayString",labels);
		model.addAttribute("arraycdata",cdata);
		model.addAttribute("arraywdata",wdata);
		
		return "analytics/semester";
	}
}