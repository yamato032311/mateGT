<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ホーム画面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/base.css">

</head>
<body>
    <header class="d-flex justify-content-between align-items-center p-3 border-bottom bg-light">
        		<a href="Top_page.action">
            		<img src="../images/mate-GT-2024-11-20.png" class="logoimg" alt="アイコン" >

            	</a>


        <div>
         <c:choose>
                <c:when test="${sessionScope.user.isAuthenticated()}">
                    <a href="Logout.action" class="text-primary text-decoration-none mx-2">ログアウト</a>
                </c:when>

			    <c:otherwise>
			        <a href="Login.action" class="text-primary text-decoration-none mx-2">ログイン</a>
                    <a href="Sign_in.action" class="text-primary text-decoration-none mx-2">新規登録</a>
			    </c:otherwise>
		</c:choose>




        </div>
    </header>


		<br>
		<br>
		<br>
		<br>
		<br>

		<div class="menu d-flex justify-content-center">
			<a href="mypage.jsp">
		    	<img src="https://via.placeholder.com/50" alt="アイコン" class="img-fluid">
		     </a>
		</div>







