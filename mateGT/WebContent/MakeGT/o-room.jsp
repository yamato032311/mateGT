<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="/common/base.jsp">
    <c:param name="title">部屋一覧</c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">

        <!-- メインエリア -->
        <div class="row my-5">
            <!-- 左カラム -->
            <div class="d-flex justify-content-center align-items-center mb-4">
                <h1 class="me-3">オープン</h1>

                 <c:if test="${sessionScope.user.isAuthenticated()}">
                	<a href="O_Room_Create.action" class="btn btn-primary me-3">部屋作成</a>
                </c:if>

                <div class="form-group">
                    <label>参加設定</label><br>
                    <input type="radio" name="participation" value="possible" checked> 参加可能
                    <input type="radio" name="participation" value="not_possible"> 参加不可能
                </div>
            </div>

            <div class="d-flex align-items-center mb-4">
	           	 <label for="rateRange " class="me-3"></label>
	            <select class="form-control me-3" id="rateRange" name="rateRange">
				    <option selected hidden>レートの条件</option>
				    <option value="none">なし</option>
				    <option value="low">～1000</option>
				    <c:forEach var="i" begin="1000" end="2000" step="100">
				        <c:choose>
				            <c:when test="${i == 2000}">
				                <option value="${i}+">${i}～</option>
				            </c:when>
				            <c:otherwise>
				                <option value="${i}-${i+100}">${i}～${i+100}</option>
				            </c:otherwise>
				        </c:choose>
		    		</c:forEach>
				</select>
            	<button class=" btn btn-primary">検索</button>
            </div>

            <div class="card">
                <div class="card-footer text-center">
                    <div class="d-flex flex-column align-items-center position-relative">
                        <a href="o-room-conect.jsp" class="btn btn-primary position-absolute" style="top: 10px; right: 10px;">参加</a>
                        <img src="icon.png" alt="アイコン" class="mb-2" style="width: 50px; height: 50px;">
                        <div>ID: <span>id</span></div>
                        <div>名前: <span>名前</span></div>
                        <div class="text-muted position-absolute" style="bottom: 10px; right: 10px;">Thu Nov 07 2024</div>
                    </div>
                </div>
            </div>
        </div>

    </c:param>
</c:import>
