package com.hoseo.rot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hoseo.rot.admin.AdminService;
import com.hoseo.rot.admin.Cart;
import com.hoseo.rot.member.Member;
import com.hoseo.rot.member.MemberService;

@Controller
public class MypageController {
	@Autowired
	MemberService memberService;
	@Autowired
	AdminService adminService;
	
	//레시피 노트
	@RequestMapping(value = "/recipeNote", method = { RequestMethod.GET, RequestMethod.POST })	
	public String recipeNote(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/recipeNote";
	}
	
	// 내가 쓴 게시물
	@RequestMapping(value = "/writeBoard", method = { RequestMethod.GET, RequestMethod.POST })	
	public String writeBoard(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/writeBoard";
	}
	
	// 주문조회
	@RequestMapping(value = "/orderInquiry", method = { RequestMethod.GET, RequestMethod.POST })	
	public String orderInquiry(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/orderInquiry";
	}
	
	//회원정보 보여주기
	@RequestMapping(value = "/updateMemberInfo", method = { RequestMethod.GET, RequestMethod.POST })	
	public String updateMemberInfo(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/updateMemberInfo";
	}
	
	//회원정보수정 update form
	@RequestMapping(value = "/updateMemberInfoEdit", method = { RequestMethod.GET, RequestMethod.POST })	
	public String updateMemberInfoEdit(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));	
			return "mypage/updateMemberInfoEdit";		
	}
	
	// 장바구니
	@RequestMapping(value = "/cart", method = { RequestMethod.GET, RequestMethod.POST })	
	public String cart(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
		String buyer = m.getId();
			model.put("cartList", adminService.getCart(buyer));
			model.put("userCart", adminService.userCartCount(buyer));
			
			return "mypage/cart";
	}
	
	//회원정보수정 update 완료
	@RequestMapping(value = "/updateMemberInfoEdit/update", method = { RequestMethod.GET, RequestMethod.POST })	
	public String updateUser(ModelMap model, HttpSession session, Member member) throws Exception{
		String id = (String) session.getAttribute("id");
		member.setId(id);
		if (memberService.updateUser(member)==1) {
			return "redirect:/updateMemberInfo";
		} else {
			return "mypage/updateMemberInfoEdit";
		}						
	}
	
	// 프로필 사진 수정 form
	@RequestMapping(value = "/updateProfileImg", method = { RequestMethod.GET, RequestMethod.POST })	
	public String updateProfileImg(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/updateProfileImg";
	}
	
	@Autowired
	private Environment env;
	// 프로필 사진 수정 form 완료
	@RequestMapping(value = "/updateProfileImg/update", method = { RequestMethod.GET, RequestMethod.POST })	
	public String updateUserProfileImg(ModelMap model, HttpSession session, Member member, MultipartHttpServletRequest multi) throws Exception{
		Iterator<String> imgs = multi.getFileNames();
		String path = env.getProperty("upload-img-path");
		String folderName1 = "profile/"; 
        File destinationFile = null;
        MultipartFile mFile = null; 
        
		while (imgs.hasNext()) {
			String uploadFile = imgs.next();			
			mFile = multi.getFile(uploadFile);
			String sourceFileName = mFile.getOriginalFilename();
			String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
	        String destinationFileName;        
			do { 
	            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;            	
	            	destinationFile = new File(path + folderName1 +destinationFileName);
	            	member.setProfileImg(destinationFileName);
	            	member.setProfileImgOriName(sourceFileName);
	            	member.setProfileImgUrl(path+folderName1);	
	            
	        } while (destinationFile.exists()); 
	        
	        destinationFile.getParentFile().mkdirs(); 
	        
	        try {
	        	mFile.transferTo(destinationFile);	        		            	           
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		String id = (String) session.getAttribute("id");
		member.setId(id);
			model.put("member",memberService.getMypage(id));
			if (memberService.updateUserProfileImg(member)==1) {
				return "redirect:/updateProfileImg";
			} else {
				return "mypage/updateProfileImg";
			}	
	}
	
	//문의내역
	@RequestMapping(value = "/contactHistory", method = { RequestMethod.GET, RequestMethod.POST })	
	public String contactHistory(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/contactHistory";
	}
	
	//회원탈퇴
	@RequestMapping(value = "/Withdrawal", method = { RequestMethod.GET, RequestMethod.POST })	
	public String Withdrawal(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			return "mypage/Withdrawal";
	}
	
	//주문
	@RequestMapping(value = "/cartOrder", method = { RequestMethod.GET, RequestMethod.POST })	
	public String cartOrder(ModelMap model, HttpSession session) throws Exception{
		Member m =  (Member) session.getAttribute("member");
		String id = m.getId();
			model.put("member",memberService.getMypage(id));
			
		String buyer = m.getId();
			model.put("cartList", adminService.getCart(buyer));
			return "mypage/cartOrder";
	}
}
