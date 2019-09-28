package com.hoseo.rot.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoseo.rot.member.MemberService;
import com.hoseo.rot.member.Member;


@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	// 약관동의
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}

	
	// 회원가입 페이지로 이동
	@PostMapping("/signUp2")
	public String signUp2() {
		return "login/signUp2";
	}
	
	// 아이디 중복 확인 	
	@RequestMapping("/signUp2/idCheck")
    @ResponseBody
    public Map<Object, Object> idCheck(@RequestBody String id) {
      
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = memberService.idCheck(id);
        map.put("cnt", count);
 
        return map;
    }
	
	// 이메일 중복 확인 	
	@RequestMapping("/signUp2/emailCheck")
    @ResponseBody
    public Map<Object, Object> emailCheck(@RequestBody String email) {
        
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = memberService.emailCheck(email);
        map.put("cnt", count);
 
        return map;
    }
	
	// 회원가입 완료
	@PostMapping("/signUp2/sign")
	public String sign(Member m, HttpSession session) {
		if (memberService.addMember(m) == 1) {
			Member member = memberService.getUser(m);
			session.setAttribute("member", member);
			session.setAttribute("id", member.getId());
			return "redirect:/signUpComplete";
		} else {
			return "login/signup2";
		}
	}
	
	// 회원가입 완료
	@GetMapping("/signUpComplete")
	public String signUpComplete() {
		return"login/signUpComplete";
	}
	
	// 로그인
	@GetMapping("/loginForm")
	public String login() {
		return "login/loginForm";
	}
	
	// 로그인 유효성 검사
	@PostMapping("/validIdPw")
	@ResponseBody
    public Map<Object, Object> vaildIdPw(@RequestBody Member member) {
		boolean isValid = false;
        Map<Object, Object> map = new HashMap<Object, Object>();
        member = memberService.encryp(member);	
        if(memberService.isValidUser(member)) {
        	isValid = true;
        	map.put("valid", isValid);
        } else {
        	map.put("valid", isValid);
        }
        return map;
    }
	
	// 로그인 완료
	@PostMapping("/loginForm")
	public String login(Member m, HttpSession session) {
		if (memberService.isValidUser(m) == false) {
			return "login/loginForm";
		}
		Member member = memberService.getMember(m);
		session.setAttribute("member", member);
		session.setAttribute("id", member.getId());
		return "redirect:index";
	}
	
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("/logout2")
	public String logout2(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm";
	}

}
