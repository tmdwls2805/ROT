
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="css/CPPE_login.css"%>
<%@ include file="css/CPPE_find.css"%>
<script language="JavaScript" src="css/js/CPPE_findid.js"></script>

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
<title>카풀피풀</title>

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
	<section>
		<br>
		<br>
		<br>

		<div class="container">
			<h2>아이디를 잊어버리셨습니까?</h2>
			<hr class="hr" color="black">
			<br>
			<form action="CPPE_findIdProc.jsp" th:action="@{/findIdProc.html}" method="post" name="form">
				<center>
					<table>
						<tr class="tr">

							<td class="find2"><input class="name" type="text"
								name="name" placeholder="이름" size="15" maxlength="5" required></td>
						</tr>
						<tr class="tr">

							<td class="find2"><input class="email" type="text" size="15"
								name="email1" placeholder="이메일" required>@<input
								class="email" type="text" size="15" name="email2" required>
							</td>
						</tr>
						<tr class="tr">

							<td class="find2"><select name="ph1" class="select">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="019">019</option>
							</select> - <input class="select" type="text" size="4" maxlength="4"
								name="ph2" required> - <input class="select" type="text"
								size="4" maxlength="4" name="ph3" required> </select></td>
						</tr>
						<tr>
					</table>
					<br> <input class="findIdButton" type="submit" value="아이디 찾기"
						onclick="findid()">
				</center>
			</form>

		</div>

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



