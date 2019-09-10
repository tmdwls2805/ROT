package com.hoseo.rot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.hoseo.rot.member.Member;


public interface XMLConfigMapper {
	/*
	 * public int getBookCount();
	 * 
	 * public Book getBook(int id);
	 * 
	 * public List<Book> getBooks();
	 */
	 public boolean insertMember(Member member);
}
