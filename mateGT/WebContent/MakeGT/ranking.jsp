<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/ranking.css">
<c:import url="/common/base.jsp">
    <c:param name="title">ランキング</c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">


		<body>
		    <!-- Sidebar -->
		    <div class="sidebar">
		        <div class="ranking-title">ランキング</div>
		        <div class="ranking-description">ランキングページの説明欄</div>
		    </div>

		    <!-- Main Content -->
		    <div class="content">
		        <!-- Header -->
		        <div class="ranking-header">
		            <select>
		                <option>ソートの条件</option>
		                <option>条件1</option>
		                <option>条件2</option>
		            </select>
		            <button>変更</button>
		        </div>

		        <!-- Ranking Table -->
		        <table class="ranking-table">
		            <thead>
		                <tr>
		                    <th>順位</th>
		                    <th>使用キャラ</th>
		                    <th>条件の内容</th>
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach var="rank" items="${ranks}">
		                    <tr>
		                        <td>${rank.position}</td>
		                        <td><img src="${rank.iconPath}" alt="Icon" class="icon"></td>
		                        <td><div class="line"></div></td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
		    </div>
		</body>
		</html>
 	</c:param>
 </c:import>