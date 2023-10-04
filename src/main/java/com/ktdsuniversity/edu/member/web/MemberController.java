package com.ktdsuniversity.edu.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.member.service.MemberService;
import com.ktdsuniversity.edu.member.vo.MemberVO;

import jakarta.validation.Valid;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberregist";
	}
	
	@PostMapping("/member/regist")
	public ModelAndView registMember(@Valid @ModelAttribute MemberVO memberVO
									, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("member/memberregist");
			modelAndView.addObject("memberVO", memberVO);
			return modelAndView;
		}
		
		boolean isSuccess = memberService.createNewMember(memberVO);
		if (isSuccess) {
			modelAndView.setViewName("redirect:/member/login");
			return modelAndView;
		}
		modelAndView.setViewName("member/memberregist");
		modelAndView.addObject("memberVO", memberVO);
		return modelAndView;
	}
	
	@ResponseBody
	@GetMapping("/member/regist/available")
	public Map<String, Object> checkAvailableEmail(@RequestParam String email) {
		
		boolean isAvailableEmail = memberService.checkAvailableEmail(email);
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("email", email);
		responseMap.put("available", isAvailableEmail);
		// Map을 반환하면 @ResponseBody에 의해 JSON으로 변환되어 응답.
		return responseMap;
	}
	
}
