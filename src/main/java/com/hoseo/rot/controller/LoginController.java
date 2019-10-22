package com.hoseo.rot.controller;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hoseo.rot.member.MemberService;

import lombok.extern.slf4j.Slf4j;

import com.hoseo.rot.member.Member;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	private Environment env;
	
	
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
	
	// 닉네임 중복 확인 	
	@RequestMapping("/signUp2/nicknameCheck")
    @ResponseBody
    public Map<Object, Object> nicknameCheck(@RequestBody String nickname) {
        
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = memberService.nicknameCheck(nickname);
        map.put("cnt", count);
 
        return map;
    }
	

	// 회원가입 완료
	@PostMapping("/signUp2/sign")
	public String sign(Member m, HttpSession session) {
   
		if (memberService.addMember(m) == true) {
			Member member = memberService.getUser(m);
			session.setAttribute("member", member);
			session.setAttribute("id", member.getId());
			return "redirect:/signUpComplete";
		} else {
			return "login/signUp2";
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
		m = memberService.encryp(m);
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
	
	// 아이디 비밀번호 고르기 페이지
	@GetMapping("/findIdPw")
	public String findIdPw() {
		return "login/findIdPw";
	}
	
	// 아이디 찾기 
	@GetMapping("/findId")
	public String findId() {
		return "login/findId";
	}
	
	@PostMapping("/findId")
	@ResponseBody
    public Map<Object, Object> findId(@RequestBody Member m) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(memberService.findId(m)!=null) {
        	m = memberService.findId(m);
        	map.put("id", m.getId());
        	map.put("name", m.getName());
        } else {
        	map.put("id", "");
        	map.put("name", "");
        }
        return map;
    }
	
	// 비밀번호 페이지
	@GetMapping("/findPassword")
	public String findPassword() {
		return "login/findPassword";
	}


	
}
