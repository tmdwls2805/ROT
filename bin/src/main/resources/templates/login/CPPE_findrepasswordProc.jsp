<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="CPPE_member.CPPE_memberDao"%>
<jsp:useBean id="CPPE" class="CPPE_member.CPPE_member"
	scope="application" />
<jsp:setProperty property="*" name="CPPE" />

<%
  int password = 0;
CPPE_memberDao dao = CPPE_memberDao.getInstance();
 	password = dao.findrepassword(CPPE);
%>


<%if(password==0){ %>
<script type="text/javascript">
alert("비밀번호 재설정을 실패하였습니다.");
location.href="CPPE_findpassword.jsp";
</script>


<%}else{ %>
<script type="text/javascript">
alert("비밀번호가 재설정 되었습니다.");
location.href="CPPE_loginform.jsp";
</script>

<%} %>