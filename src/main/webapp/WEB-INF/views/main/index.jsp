<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kor">
<html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Meehyang Photo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />
	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
	
	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">
	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
	<!-- Animate -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon -->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	
	<link rel="stylesheet" href="css/style.css">
	
	
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
		<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	</head>
	<body>
	<%@ include file="../inc/header.jsp" %>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry">
			<c:forEach items="${boardList}" var="boardVO">
				<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
					<figure>
						<a href="view?idx=${boardVO.idx}">
							<c:set var="attachFile" value="${boardVO.attachFile }" />
							<c:if test="${!empty attachFile}">
	 							<img src="${boardVO.attachFile}" alt="Image" class="img-responsive">
							</c:if>
							<c:if test="${empty attachFile}">
	 							<img src="images/pic_1.jpg" alt="default" class="img-responsive">
							</c:if>
						</a>
					</figure>
					<span class="fh5co-meta"><a href="single.html">${boardVO.cate}</a></span>
					<h2 class="fh5co-article-title">
						<a href="view?idx=${boardVO.idx}">
							<c:choose>
								<c:when test="${fn:length(boardVO.title) gt 12}">
									<c:out value="${fn:substring(boardVO.title, 0, 13)}">
									</c:out>
									...
								</c:when>
								<c:otherwise>
									<c:out value="${boardVO.title}">
									</c:out>
								</c:otherwise>
							</c:choose>
						</a>
					</h2>
					<span class="fh5co-meta fh5co-date">${boardVO.insertDate}</span>
				</article>
  			</c:forEach>
			<div class="clearfix visible-xs-block"></div>
		</div>
	</div>
	<%@ include file="../inc/footer.jsp" %>
	</body>
</html>

