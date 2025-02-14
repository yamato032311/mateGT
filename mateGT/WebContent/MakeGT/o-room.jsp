<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="/common/base.jsp">
    <c:param name="title">オープン部屋</c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">

        <div class="row my-5">
            <!-- 左カラム -->
            <div class="d-flex justify-content-center align-items-center mb-4">
                <h1 class="me-3">オープン</h1>

                <c:if test="${sessionScope.user.isAuthenticated()}">
                    <a href="R_Room_Create.action" class="btn btn-primary me-3">部屋作成</a>
                </c:if>

                <div class="form-group">
                    <label>参加設定</label><br>
                    <input type="radio" name="participation" value="possible" checked> 参加可能
                    <input type="radio" name="participation" value="not_possible"> 参加不可能
                </div>
            </div>

            <div class="d-flex align-items-center mb-4">
                <label for="rateRange" class="me-3"></label>
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
                <button class="btn btn-primary">検索</button>
            </div>

            <!-- 部屋一覧 -->
            <c:forEach var="room" items="${rooms}">
                <div class="card mb-3 mt-1" style="max-width: 1100px;">
                    <div class="card-footer position-relative p-2">
                        <div class="d-flex align-items-center">
                            <img src="icon.png" alt="アイコン" class="me-2" style="width: 100px; height: 40px;">
                            <div class="d-flex flex-column">
                                <div>部屋ID: <span>${room.roomId}</span></div>
                                <div>作成者ID: <span>${room.createdBy}</span></div>
                                <div>募集人数: <span>${room.numberApplicants} 人</span></div>
                            </div>
                        </div>

                        <!-- 現在のユーザーが部屋の作成者と同じでない場合のみ「参加」ボタンを表示 -->
                        <c:if test="${sessionScope.user.no ne room.createdBy}">
                            <form action="Join_O_room.action" method="post" class="position-absolute top-0 end-0 mt-2 me-2">
                                <input type="hidden" name="room_id" value="${room.roomId}">
                                <button type="submit" class="btn btn-primary btn-sm">参加</button>
                            </form>
                        </c:if>

                        <div class="text-muted small text-end mt-2">${room.startedAt}</div>
                    </div>
                </div>
            </c:forEach>

            <c:if test="${empty rooms}">
                <p>現在、部屋はありません。</p>
            </c:if>

            <!-- ページネーション -->
            <div class="pagination d-flex justify-content-center text-center mt-4">
                <c:if test="${currentPage > 1}">
                    <a href="R_Room.action?page=${currentPage - 1}" class="btn btn-secondary mx-2">前のページ</a>
                </c:if>

                <span class="align-self-center mx-3">ページ ${currentPage} / ${totalPages}</span>

                <c:if test="${currentPage < totalPages}">
                    <a href="R_Room.action?page=${currentPage + 1}" class="btn btn-secondary mx-2">次のページ</a>
                </c:if>
            </div>

        </div>
    </c:param>
</c:import>
