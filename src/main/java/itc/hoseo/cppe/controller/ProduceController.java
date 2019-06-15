package itc.hoseo.cppe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import itc.hoseo.cppe.member.Member;
import itc.hoseo.cppe.member.MemberService;

@Controller
public class ProduceController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/companyCI")
	public String companyCI() {
		return "produce/companyCI";
	}
	
	@GetMapping("/companyProduce")
	public String companyProduce() {
		return "produce/companyProduce";
	}
	
	@GetMapping("/serviceProduce")
	public String serviceProduce() {
		return "produce/serviceProduce";
	}


}
