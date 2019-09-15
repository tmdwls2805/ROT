
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import = "CPPE_member.CPPE_memberDao" %>
<jsp:useBean id="CPPE" class="CPPE_member.CPPE_member" />
<jsp:setProperty property="*" name="CPPE" />


<%
	String id = null;
	CPPE_memberDao dao = CPPE_memberDao.getInstance();
	id = dao.findid(CPPE);
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<%@ include file="css/CPPE_findidcomplete.css"%>
<%@ include file="css/CPPE_find.css"%>


<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="codepixer">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>카풀피풀 아이디 찾기 완료 페이지</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
            CSS
            ============================================= -->
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href=css/animate.min.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<jsp:include page="CPPE_headerbeforelogin.jsp" flush="false" />



	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12"></div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start blog-posts Area -->
	<br>
	<br>
	<br>
	<section>

		<%
			if (id == null) {
		%>

		<script type="text/javascript">
			alert("존재하지 않은 계정입니다.");
			location.href = "CPPE_findid.jsp";
		</script>

		<!-- 아이디가 이미 존재할때 이미지 -->
		<%
			} else {
		%>


		<div class="container">
			<h2>아이디 찾기 완료</h2>
			<hr class="hr" color="black">
			<br>
			<center>
				<span class="comex">고객님의 정보와 일치하는 아이디 목록입니다.</span>
				<form class="signUp" id="signupForm">
					<strong><%=id%></strong>
				</form>
				<br> <input type="button" class="comlo" value="로그인하기"
					onclick="javascript:location.href='CPPE_loginform.jsp'"> <input
					type="button" class="compw" value="비밀번호 찾기"
					onclick="javascript:location.href='CPPE_findpassword.jsp'">
			</center>
			<%
				}
			%>
		
	</section>
	<br>
	<br>
	<br>


	<!-- start footer Area -->
	<jsp:include page="CPPE_footer.jsp" flush="false" />
	<!-- End footer Area -->

	<script src="css/js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="css/js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="css/js/easing.min.js"></script>
	<script src="css/js/hoverIntent.js"></script>
	<script src="css/js/superfish.min.js"></script>
	<script src="css/js/jquery.ajaxchimp.min.js"></script>
	<script src="css/js/jquery.magnific-popup.min.js"></script>
	<script src="css/js/owl.carousel.min.js"></script>
	<script src="css/js/jquery.sticky.js"></script>
	<script src="css/js/jquery.nice-select.min.js"></script>
	<script src="css/js/waypoints.min.js"></script>
	<script src="css/js/jquery.counterup.min.js"></script>
	<script src="css/js/parallax.min.js"></script>
	<script src="css/js/mail-script.js"></script>
	<script src="css/js/main.js"></script>
</body>
</html>



