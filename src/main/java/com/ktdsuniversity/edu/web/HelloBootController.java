package com.ktdsuniversity.edu.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBootController {
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello Spring!", HttpStatus.OK);
	}
	
	@GetMapping("/hello/2")
	public ResponseEntity<String> hello2() {
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head><title>Hello Boot!</title>");
		html.append("<style type='text/css'>div {font-weight: bold;font-size: 16pt;}</style></head>");
		html.append("<body>");
		html.append("<div>안녕하세요.</div>");
		html.append("<div>Spring Boot에서 응답되었습니다!</div>");
		html.append("</body>");
		html.append("</html>");
		return new ResponseEntity<>(html.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/hello/3")
	public String helloJsp() {
		return "helloboot";
	}
	
	@GetMapping("hello/4")
	public ModelAndView helloModelAndView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("helloboot");
		view.addObject("myname", "Spring Boot (´･ω･`)?");
		return view;
	}

	@GetMapping("hello/5")
	public String helloModel(Model model) {
		model.addAttribute("myname", "Spring Boot (´･ω･`)?");
		return "helloboot";
	}





}