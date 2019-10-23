package com.hoseo.rot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	
	
	//레시피 노트
	@GetMapping("/recipeNote")
	public String recipeNote() {
		return "mypage/recipeNote";
	}
	
	// 프로필 사진 수정
	@GetMapping("/updateProfileImg")
	public String updateProfileImg() {
		return "mypage/updateProfileImg";
	}
	
	// 내가 쓴 게시물
	@GetMapping("/writeBoard")
	public String writeBoard() {
		return "mypage/writeBoard";
	}
	
	// 주문조회
	@GetMapping("/orderInquiry")
	public String orderInquiry() {
		return "mypage/orderInquiry";
	}
	
	// 장바구니
	@GetMapping("/cart")
	public String cart() {
		return "mypage/cart";
	}
	
	//회원정보수정
	@GetMapping("/updateMemberInfo")
	public String MyHome() {
		return "mypage/updateMemberInfo";
	}
	
	//문의내역
	@GetMapping("/contactHistory")
	public String contactHistory() {
		return "mypage/contactHistory";
	}	
	

}
