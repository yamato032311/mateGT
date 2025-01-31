<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>キャラ詳細</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  <style>
    /* 動画全体を縮小 */
    .video-container {
      display: inline-block;
      transform: scale(0.4); /* 0.4倍に縮小 */
      transform-origin: top left; /* 縮小時の基準位置 */
    }
  </style>
</head>
<body class="bg-gray-100">

  <main class="container mx-auto p-8">
    <div class="bg-white p-6 rounded shadow">
      <div class="flex flex-wrap md:flex-nowrap">
        <!-- 左側：サイドバー -->
        <div class="w-full md:w-1/3 mb-6 md:mb-0">
          <!-- 画像 -->
          <img src="<%= request.getContextPath() %>/PNG_JPG/13SS.jpg" alt="キャラ詳細" class="w-full rounded mb-4">

          <!-- プロフィール説明 -->
          <div>
            <h3 class="text-lg font-bold mb-2">プロフィール説明</h3>
            <p><%= request.getAttribute("profileDescription") != null ? request.getAttribute("profileDescription") : "ここにキャラの詳細プロフィールが表示されます。" %></p>
          </div>
          <div class="mt-4">
            <a href="characters.jsp" class="text-blue-500">他のキャラを見る</a>
          </div>
        </div>

        <!-- 右側：他の要素 -->
        <div class="w-full md:w-2/3 md:ml-6">
          <h2 class="text-2xl font-bold mb-2">#67b5b7</h2>
          <p class="mb-4">基本情報: <%= request.getAttribute("basicInfo") != null ? request.getAttribute("basicInfo") : "" %></p>
          <p class="mb-4">アビリティ: <%= request.getAttribute("abilities") != null ? request.getAttribute("abilities") : "ゲージ必中、超マインスイーパーEL、ライトポジションキラーM" %></p>
          <p class="mb-4">ストライクショット: <%= request.getAttribute("strikeShot") != null ? request.getAttribute("strikeShot") : "" %></p>
          <button class="bg-blue-500 text-white px-4 py-2 rounded mb-4">つよい</button>
          <button class="bg-yellow-500 text-white px-4 py-2 rounded">よわい</button>

          <!-- 動画の位置 -->
          <div class="mt-6">
            <h3 class="text-lg font-bold mb-2">キャラ紹介動画</h3>
            <div class="video-container">
              <video class="w-full rounded" controls>
                <source src="<%= request.getContextPath() %>/MP4/13.mp4" type="video/mp4">
                お使いのブラウザは動画再生に対応していません。
              </video>
            </div>
          </div>
        </div>
      </div>

    </div>
  </main>

</body>
</html>
