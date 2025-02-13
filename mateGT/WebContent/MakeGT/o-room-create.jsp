<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>オープンルーム作成</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/o-room.css">
</head>
<body>
    <div class="container">
        <h1>オープンルーム作成</h1>
        <form action="O_Room_CreateExe.action" method="post">

            <!-- ルームID -->
            <label for="roomId">部屋番号 (5桁)</label>
            <input type="text" id="roomId" name="room_num" placeholder="部屋番号を入力" maxlength="5" required>

            <!-- パスワード -->
            <label for="password">パスワード (4桁)</label>
            <input type="password" id="password" name="room_pass" placeholder="4桁のパスワード" maxlength="4" required>


            <!-- 募集人数 -->
            <label for="members">募集人数</label>
            <select id="members" name="number_applicants" required>
                <option value="1">1人</option>
                <option value="2">2人</option>
                <option value="3">3人</option>
            </select>

            <!-- レート設定 -->
            <label for="rateUpper">最大レート</label>
            <input type="number" id="rateUpper" name="rate_upper" min="0">

            <label for="rateLower">最小レート</label>
            <input type="number" id="rateLower" name="rate_lower" min="0">

            <!-- 送信ボタン -->
            <button type="submit">ルーム作成</button>
        </form>
    </div>
</body>
</html>
