package kr.or.hoseo.springproject.chapter4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.hoseo.springproject.chapter4.service.MemeberService;

@Controller
public class HelloController {
	@Autowired
	MemeberService memberService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", memberService.getAllMemebers());
		return "index";
	}
}
