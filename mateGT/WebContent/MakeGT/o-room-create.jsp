<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>オープンルーム作成</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: left;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input, select, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ced4da;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>オープンルーム作成</h1>
        <form action="CreateRoomServlet" method="post">
            <!-- Room ID -->
            <label for="roomId">ルームID (5桁)</label>
            <input type="text" id="roomId" name="roomId" placeholder="ルームIDを入力" maxlength="5" required>

            <!-- Password -->
            <label for="password">パスワード (4桁)</label>
            <input type="password" id="password" name="password" placeholder="4桁のパスワード" maxlength="4" required>

            <!-- Number of Members -->
            <label for="members">募集人数</label>
            <select id="members" name="members" required>
                <option value="2">2人</option>
                <option value="3">3人</option>
                <option value="4">4人</option>
            </select>

            <!-- Submit Button -->
            <button type="submit">ルーム作成</button>
        </form>
    </div>
</body>
</html>
