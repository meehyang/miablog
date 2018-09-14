<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kor">
	<head>
		<title>Meehyang Photo</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="css/main.css" />
		<link rel="shortcut icon" href="favicon.ico">
		<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/animate.css">
		<link rel="stylesheet" href="css/icomoon.css">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/modernizr-2.6.2.min.js"></script>
		<script src="js/jquery.min.js"></script>
	</head>
	<body>
	<%@ include file="../inc/header.jsp" %>
	<!-- END #fh5co-header -->
	<script type="text/javascript">
		function goPrev(prevIdx){
			if(prevIdx == 0){
				alert("이전 게시물이 없습니다.");
			}else{
				location.href='view?idx='+prevIdx;
			}
		}
		function goNext(nextIdx){
			if(nextIdx == 0){
				alert("마지막 게시물입니다.");
			}else{
				location.href='view?idx='+nextIdx;
			}
		}
	</script>
	<a href="#" onclick="goPrev('${boardNum.prevIdx}'); return false;" class="fh5co-post-prev"><span><i class="icon-chevron-left"></i> Prev</span></a>
	<a href="#" onclick="goNext('${boardNum.nextIdx}'); return false;" class="fh5co-post-next"><span>Next <i class="icon-chevron-right"></i></span></a>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				<figure class="animate-box">
					<c:set var="attachFile" value="${attachView.attachFile }" />
					<c:if test="${!empty attachFile}">
							<img src="${attachView.attachFile}" alt="Image" class="img-responsive">
					</c:if>
					<c:if test="${empty attachFile}">
							<img src="images/single_1.jpg" alt="default" class="img-responsive">
					</c:if>
				</figure>
				<span class="fh5co-meta animate-box"><h4 class="fh5co-article-title animate-box">${boardView.title}</h4></span>
				<span class="fh5co-meta fh5co-date animate-box">${boardView.insertDate }</span>
				
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
					<div class="row" style="text-align: center;">
						${boardView.content}
					</div>
					
				</div>
			</article>
		</div>
	</div>
	<%@ include file="../inc/footer.jsp" %>
	</body>
</html>

