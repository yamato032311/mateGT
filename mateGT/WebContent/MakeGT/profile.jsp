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
   <script>
    function updateCharacterImage(selectElement, imgElement) {
      // 選択されたオプションの値を取得
      var selectedOption = selectElement.options[selectElement.selectedIndex];

      // 選択されたキャラクターのアイコン画像のパスを取得
      var selectedImage = selectedOption.getAttribute("data-icon");

      // 画像のsrcを選択されたキャラクターのアイコン画像に更新
      imgElement.src = selectedImage;
    }
  </script>
</head>
<body>
  <div class="container">
  	<form action="ProfileUpdate.action" method="post">
	    <h1>プロフィール</h1>

	    <div class="section">
	      <label for="username">ユーザー名</label>
	      <input type="text" id="username" name="username">
	    </div>

	    <div class="section">
	      <label for="main-character">使用キャラ</label>
        <select id="main-character" name="main_character_id" onchange="updateCharacterImage(this, document.getElementById('main-character-image'))">
          <option value="" hidden>メインキャラ - 必須</option>
          <!-- 使用キャラ1にcharactersを割り当て -->
          <c:forEach var="character" items="${characters}">
            <option value="${character.charaId}" data-icon="${character.charaIcon}">${character.charaName}</option>
          </c:forEach>
        </select>
        <!-- 使用キャラ1のアイコン画像 -->
        <img id="main-character-image" src="" alt="Character Icon" style="width: 100px; height: 100px;">
      </div>


	    <div class="section">
        <label for="sub-character">使用キャラ２</label>
        <select id="sub-character" name="sub_character_id" onchange="updateCharacterImage(this, document.getElementById('sub-character-image'))">
          <option value="">サブキャラ</option>
          <!-- 使用キャラ2にcharactersを割り当て -->
          <c:forEach var="character" items="${characters}">
            <option value="${character.charaId}" data-icon="${character.charaIcon}">${character.charaName}</option>
          </c:forEach>
        </select>
        <!-- 使用キャラ2のアイコン画像 -->
        <img id="sub-character-image" src="" alt="Sub Character Icon" style="width: 100px; height: 100px;">
      </div>


	    <div class="section">
	      <label for="comment">一言コメント</label>
	      <textarea id="comment" name="comment" rows="3"></textarea>
	    </div>

	    <button type="button">変更</button>
    </form>

  </div>
</body>
</html>
