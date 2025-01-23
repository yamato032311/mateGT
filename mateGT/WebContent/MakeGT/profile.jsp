<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/profile.css">

  <title>プロフィール編集</title>
</head>
<body>
  <div class="container">
    <h1>プロフィール</h1>

    <div class="section">
      <label for="username">ユーザー名</label>
      <input type="text" id="username" name="username">
    </div>

    <div class="section">
      <label for="main-character">使用キャラ</label>
      <select id="main-character" name="main-character">
        <option value="">メインキャラ - 必須</option>
      </select>
      <img src="gear-icon.png" alt="Character Icon">
    </div>

    <div class="section">
      <label for="sub-character">使用キャラ２</label>
      <select id="sub-character" name="sub-character">
        <option value="">サブキャラ</option>
      </select>
      <img src="gear-icon.png" alt="Sub Character Icon">
    </div>

    <div class="section">
      <label for="comment">一言コメント</label>
      <textarea id="comment" name="comment" rows="3"></textarea>
    </div>

    <button type="button">変更</button>
  </div>
</body>
</html>
