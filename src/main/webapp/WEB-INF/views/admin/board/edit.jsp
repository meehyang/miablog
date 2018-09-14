<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div id="wrapper">
        <%@ include file="../inc/header.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${boardView.title}  
	                    <a class="btn btn-default" href="../board/view?idx=${boardView.idx}">이전</a>
	                    <a class="btn btn-danger" href="../board/delete?idx=${boardView.idx}">삭제</a>
                    </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic Form Elements
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" name="frm" method="post" action="editDo" enctype="multipart/form-data">
                                    	<input type="hidden" name="idx" value="${boardView.idx}">
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input type="text" class="form-control" name="title" value="${boardView.title}">
                                            <label>유저이름 </label>
                                            <input type="text" class="form-control" value="${boardView.userName}" name="userName">
                                            <p style="margin-top:10px;"><label>카테고리</label></p>
	                                        <select name="cate" class="form-control">
	                                        	<option ${boardView.cate == 'music' ? 'selected="selected"':''}>music</option>
	                                        	<option ${boardView.cate == 'life' ? 'selected="selected"':''}>life</option>
	                                        	<option ${boardView.cate == 'people' ? 'selected="selected"':''}>people</option>
	                                        	<option ${boardView.cate == 'trip' ? 'selected="selected"':''}>trip</option>
	                                        	<option ${boardView.cate == 'etc' ? 'selected="selected"':''}>etc</option>
	                                        </select>
                                            <c:set var="attachFile" value="${attachView.attachFile }" />
											<c:if test="${!empty attachFile}">
											    <p><label>첨부파일</label></p>
												<input type="file" class="form-control" name="attachFileOrg">
												<img src="../../${attachView.attachFile }" width="300px;">
											</c:if>
											<p><label>내용</label></p>
											<textarea name="content" class="form-control" id="summernote">${boardView.content}</textarea>
                                            <p><label>작성일 </label></p>
                                            <p class=help-block">${boardView.insertDate }</p>
                                        </div>
                                        <button class="btn btn-info" type="submit">완료</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
