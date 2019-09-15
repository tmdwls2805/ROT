<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="CPPE_member.CPPE_memberDao"%>
<%
     int rst = 0;
     request.setCharacterEncoding("UTF-8");
     String id = (String)request.getParameter("id");
     String password = (String)request.getParameter("password");
    String name = (String)request.getParameter("name");
     
     CPPE_memberDao dao = CPPE_memberDao.getInstance();
     rst = dao.loginCheck(id, password);
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01

 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카풀피풀</title>
</head>
<body>
	<%
 if(rst == 2){  /* 아이디와 비밀번호와 이름을 가져온다 */
  session.setAttribute("loginId", id);
  session.setAttribute("loginPassword", password);
	session.setAttribute("name", name);
session.setMaxInactiveInterval(60*60);
%>
	<script type="text/javascript">
location.href="index.jsp";   /* 로그인 완료 시 index로 이동 */
</script>
	<%  }else if(rst == 1){ %>  <!-- 비밀번호가 틀리다면 -->
	<script type="text/javascript">
alert("비밀번호 틀렸습니다");           
history.go(-1);                   /* 로그인 폼으로 돌아감 */
</script>
	<%  }else{ %>
	<script type="text/javascript">     /*  아이디가 틀리다면 */
alert("존재하지 않은 계정입니다.");
history.go(-1);                     /* 로그인 폼으로 돌아감 */
</script>
	<%  } %>
</body>
</html>