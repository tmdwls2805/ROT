package itc.hoseo.cppe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import itc.hoseo.cppe.member.Member;
import itc.hoseo.cppe.member.MemberService;

@Controller
public class MypageController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/mypage", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypage(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("user",memberService.getUser(id));
			return "mypage/mypage";
	}
	
	@RequestMapping(value = "/mypageEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypageEdit(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("user",memberService.getUser(id));
			return "mypage/mypageEdit";
	}
	
	@RequestMapping(value = "/mypageEdit/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypageEdit1(ModelMap model, HttpSession session, Member member) {
		String id = (String) session.getAttribute("id");
		member.setId(id);
		if (memberService.updateUser(member)==1) {
			return "redirect:/";
		} else {
			return "mypage/mypageEdit";
		}
	}
}
