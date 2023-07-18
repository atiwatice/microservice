package com.buyer.profile.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.buyer.profile.utils.UtilityTool;



@Controller
public class TestController {

	@Autowired
	UtilityTool util;

	@GetMapping("test")
	public String test1() {
		TestObjectW test = TestObjectW.builder().obje1("ob1").obje2("ob2").obje3("ob3").obje4("0b5").build();
		TestObjectW test2 = TestObjectW.builder().obje1("ob1").obje2("ob4").obje3("ob3").obje4("0b4").build();
		Map<String, String> diff = util.checkDiffObjectString(test, test2);
		String ss = "dsa";
		
		return "test";
	}
}
