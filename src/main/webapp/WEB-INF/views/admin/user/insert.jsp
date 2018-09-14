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
                    <h1 class="page-header">회원 등록</h1>
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
                        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
                        <script type="text/javascript">
                        	$(document).ready(function(){
                        		$('#change_pwd_chk').keyup(function(){
	                        		if($("#user_pwd").val() !== $('#change_pwd_chk').val()){
	                        			$('.pwdState').text('');
	                        			$('.pwdState').html('<span style="color:red;font-weight:bold;">비밀번호가 일치하지 않습니다. 다시 확인해주세요.</span>');
	                        		}else{
	                        			$('.pwdState').text('');
	                        			$('.pwdState').html('<span style="color:green;font-weight:bold;">비밀번호 확인 완료</span>');
	                        		}
                        		});
                        	});
                        	
                        	function validateFrm(){
                        		var frm = document.frm;
                        		if($("#user_pwd").val() !== $('#change_pwd_chk').val()){
                        			alert('비밀번호를 확인해주세요.');
                        			return false;
                        		}else{
                        			if(confirm('등록 하시겠습니까?')){
                        				frm.submit();
                        			}
                        		}
                        	}
                        </script>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" name="frm" method="post" action="insertDo">
                                        <div class="form-group">
                                            <label>유저아이디</label>
                                            <input type="text" class="form-control" name="userId" placeholder="아이디를 입력하세요 ">
                                            <label>유저이름 </label>
                                            <input type="text" class="form-control" name="userName" placeholder="이름을 입력하세요 ">
                                            <div style="width:45%;display:inline-block;">
	                                            <label>비밀번호</label>
	                                            <input type="password" class="form-control" id="user_pwd" name="userPwd" id="change_pwd">
	                                        </div>
	                                        <div style="width:45%;display:inline-block;">
	                                            <label>비밀번호 확인</label>
	                                            <input type="password" class="form-control" id="change_pwd_chk">
	                                        </div>
	                                        <p class="pwdState"></p>
	                                        <div>
                                            	<label>이메일 </label>
                                           	</div>
                                            <input type="text" class="form-control" name="email" placeholder="이메일을 입력해주세요 ">
                                        </div>
                                           <a class="btn btn-default" href="../user/list">이전</a>
                                           <input class="btn btn-info" type="submit" value="완료">
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
