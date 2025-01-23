<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>プロフィール</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/base.css">
</head>
<body>
    <div class="container mt-5">
    	 <img src="/path/to/icon.png" alt="ユーザーアイコン" class="profile-icon mb-3">
        <div class="main-section">
            <!-- Profile Section -->
            <div class="profile-section">

                <h3>ユーザーID</h3>
                <h3 class="mt-4">プロフィール
                	<a href="profile.jsp" class="btn btn-primary  mb-3 mt-2">プロフィール編集</a>
                </h3>

                <ul>
                    <li>ユーザー名: サンプル名</li>
                    <li>レート: 1234</li>
                    <li>使用キャラ:</li>
                    	<img src="/path/to/character.png" alt="キャラクターアイコン" class="profile-icon">
                    <li>一言コメント:</li>
                    <textarea class="form-control" rows="3">ここにコメントを入力</textarea>
                </ul>
            </div>

            <!-- History Section -->
            <div class="history-section">
                <h4>歴代の勝敗 昨日との差分</h4>

                <h5>対戦履歴</h5>
                <table class="table">
                    <thead>
                        <tr>
                            <th>対戦相手の名前</th>
                            <th>勝敗</th>
                            <th>レート増減</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><img src="/path/to/icon.png" alt="相手アイコン" class="profile-icon"> 対戦相手1</td>
                            <td>勝ち</td>
                            <td>+10</td>
                        </tr>
                        <tr>
                            <td><img src="/path/to/icon.png" alt="相手アイコン" class="profile-icon"> 対戦相手2</td>
                            <td>負け</td>
                            <td>-15</td>
                        </tr>
                    </tbody>
                </table>
                <nav>
                    <ul class="pagination justify-content-center">
                        <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                    </ul>
                </nav>

                <div class="diary-list">
                    <h4>今までの日記一覧</h4>
                    <div class="diary-item">
                        <h5>Title</h5>
                        <p class="text-muted">Mon Nov 11 2024</p>
                        <p>日記の内容をここに表示します...</p>
                    </div>
                    <div class="diary-item">
                        <h5>Title</h5>
                        <p class="text-muted">Tue Nov 12 2024</p>
                        <p>日記の内容をここに表示します...</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
