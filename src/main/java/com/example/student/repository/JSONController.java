package com.example.student.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.common.model.Shop;


@RestController
public class JSONController implements Jason {
	@Autowired StudentRepository studrepo;
	
	@RequestMapping(value="/kfc/{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
		
		return shop;

	}
	
	@RequestMapping(value = "/hellokfc", method = RequestMethod.GET)
    public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "Boxfuse") String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("greeting", "Hello " + name + "!");
        return result;
    }
	
	@RequestMapping(value = "/hellosave", method = RequestMethod.POST)
    public @ResponseBody Student hellosave(@RequestBody Student student) {
        return studrepo.save(student);
    }
	
	@RequestMapping(value = "/hellosave", method = RequestMethod.GET)
    public @ResponseBody List<Student> hellosave() {
		return studrepo.findAll();
    }

	
}