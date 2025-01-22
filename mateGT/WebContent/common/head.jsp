<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ホーム画面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <header class="d-flex justify-content-between align-items-center p-3 border-bottom bg-light">
        	<div class="icon mb-3">
        		<a href="Top_page.action">
            		<img src="./images/mate-GT-2024-11-20.png" alt="アイコン" >
            	</a>
        	</div>

        <div>
            <a href="" class="text-primary text-decoration-none mx-2">利用規約</a>
            <a href="" class="text-primary text-decoration-none mx-2">対戦ルール</a>
        </div>
        <div>
        	<c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="${pageContext.request.contextPath}/logout.jsp" class="text-primary text-decoration-none mx-2">ログアウト</a>
                </c:when>
                <c:otherwise>
                    <a href="Login.action" class="text-primary text-decoration-none mx-2">ログイン</a>
                    <a href="Sign_in.action" class="text-primary text-decoration-none mx-2">新規登録</a>
                </c:otherwise>
           </c:choose>
        </div>
    </header>

        <div class="search-bar mb-4 my-5">
            <form action="<%= request.getContextPath() %>/search" method="get">
                <input type="text" name="query" class="form-control w-75 mx-auto" placeholder="検索...">
            </form>
        </div>


		<div class="menu d-flex justify-content-center">
			<a href="mypage.jsp">
		    	<img src="https://via.placeholder.com/50" alt="アイコン" class="img-fluid">
		     </a>
		</div>


        <div class="menu d-flex justify-content-center gap-4 my-5">
            <a href="O_Room.action" class="btn btn-danger" >オープンマッチ</a>
            <a class="btn btn-danger" href="R_Room.action">レートマッチ</a>
            <button class="btn btn-danger" href="">掲示板</button>
            <a href="Ranking.action" class="btn btn-danger" >ランキング</a>
        </div>





