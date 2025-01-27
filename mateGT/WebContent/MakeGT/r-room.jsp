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
                <div class="col-md-6">
	               	<div class="d-flex justify-content-center align-items-center mb-4">
			      		<h1 class="me-3">オープン</h1>
			     		<a href="O_Room_Create.action" class="btn btn-primary me-3">部屋作成</a>
			  	 	</div>

                   <div class="card">
                       <div class="card-body">
                            <div class="form-group">
                                <label>参加設定</label><br>
                                <input type="radio" name="participation" value="possible" checked> 参加可能
                                <input type="radio" name="participation" value="not_possible"> 参加不可能
                            </div>
                            <div class="form-group">
                                <label for="rateRange">レート帯</label>
                                <select class="form-control" id="rateRange" name="rateRange">
                                    <option value="low">低</option>
                                    <option value="medium">中</option>
                                    <option value="high">高</option>
                                </select>
                            </div>
                            <button class="btn btn-primary w-100">検索する</button>
                        </div>
                        <div class="card-footer text-center">
                            <div class="d-flex flex-column align-items-center">
                                <img src="icon.png" alt="アイコン" class="mb-2" style="width: 50px; height: 50px;">
                                <div>ID: <span>id</span></div>
                                <div>名前: <span>名前</span></div>
                                <div class="text-muted">Thu Nov 07 2024</div>
                                <a href="o-room-conect.jsp" class="btn btn-primary mt-2">参加</a>
                            </div>
                        </div>
                    </div>
                </div>


 <div class="row my-5">
                <!-- 左カラム -->
                <div class="col-md-6">
	               	<div class="d-flex justify-content-center align-items-center mb-4">
			      		<h1 class="me-3">オープン</h1>
			     		<a href="O_Room_Create.action" class="btn btn-primary me-3">部屋作成</a>
			  	 	</div>

                   <div class="card">
                       <div class="card-body">
                            <div class="form-group">
                                <label>参加設定</label><br>
                                <input type="radio" name="participation" value="possible" checked> 参加可能
                                <input type="radio" name="participation" value="not_possible"> 参加不可能
                            </div>
                            <div class="form-group">
                                <label for="rateRange">レート帯</label>
                                <select class="form-control" id="rateRange" name="rateRange">
                                    <option value="low">低</option>
                                    <option value="medium">中</option>
                                    <option value="high">高</option>
                                </select>
                            </div>
                            <button class="btn btn-primary w-100">検索する</button>
                        </div>
                        <div class="card-footer text-center">
                            <div class="d-flex flex-column align-items-center">
                                <img src="icon.png" alt="アイコン" class="mb-2" style="width: 50px; height: 50px;">
                                <div>ID: <span>id</span></div>
                                <div>名前: <span>名前</span></div>
                                <div class="text-muted">Thu Nov 07 2024</div>
                                <a href="o-room-conect.jsp" class="btn btn-primary mt-2">参加</a>
                            </div>
                        </div>
                    </div>
                </div>




                <!-- 右カラム -->
                <div class="col-md-6">
                 	<div class="d-flex justify-content-center  align-items-center mb-4">
						<h1 class="me-3">レート</h1>
				      <a  href="R_Room_Create.action" class="btn btn-primary me-3">部屋作成</a>
				     </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="form-group">
                                <label>参加設定</label><br>
                                <input type="radio" name="participation2" value="possible" checked> 参加可能
                                <input type="radio" name="participation2" value="not_possible"> 参加不可能
                            </div>
                            <div class="form-group">
                                <label for="rateRange2">レート帯</label>
                                <select class="form-control" id="rateRange2" name="rateRange2">
                                    <option value="low">低</option>
                                    <option value="medium">中</option>
                                    <option value="high">高</option>
                                </select>
                            </div>
                            <button class="btn btn-primary w-100">検索する</button>
                        </div>
                        <div class="card-footer text-center">
                            <div class="d-flex flex-column align-items-center">
                                <img src="icon.png" alt="アイコン" class="mb-2" style="width: 50px; height: 50px;">
                                <div>ID: <span>id</span></div>
                                <div>名前: <span>名前</span></div>
                                <div class="text-muted">Thu Nov 07 2024</div>
                                <a href="r-room-conect.jsp" class="btn btn-primary mt-2">参加</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- ページネーション -->
            <div class="d-flex justify-content-center mt-4">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#"><<</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">>></a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </c:param>
</c:import>
