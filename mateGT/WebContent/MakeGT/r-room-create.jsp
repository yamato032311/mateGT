<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>オープンルーム作成</title>
     <link rel="stylesheet" href="<%=request.getContextPath() %>/css/o-room.css">
</head>

<body>
    <div class="container">
        <h1>レートルーム作成</h1>
        <form action="O_Room_CreateExe.action" method="post">
            <!-- Room ID -->
            <label for="roomId">部屋番号 (5桁)</label>
            <input type="text" id="roomId" name="roomId" placeholder="部屋番号を入力" maxlength="5" required>

            <!-- Password -->
            <label for="password">パスワード (4桁)</label>
            <input type="password" id="password" name="password" placeholder="4桁のパスワード" maxlength="4" required>

            <!-- Number of Members -->
            <label for="members">募集人数</label>
            <select id="members" name="members" required>
                <option value="2">1人</option>
              </select>

            <!-- Submit Button -->
            <button type="submit">ルーム作成</button>
        </form>
    </div>
</body>
</html>
