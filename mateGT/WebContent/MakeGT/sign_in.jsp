<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <main class=" text-center">
        <form action="Sign_inExecute.action" method="post">
            <h1>新規登録</h1>

            <div class="form-floating mb-1">
                <input type="email" class="form-control" id="floatingInput"   placeholder="半角でご入力ください"
                name="mail" required>
                <label for="floatingInput">メールアドレス</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="半角でご入力ください"
                name="pass" required>
                <label for="floatingPassword">パスワード</label>
            </div>

			<div class="form-floating">
               <input type="password" class="form-control" id="floatingPassword"  placeholder="半角でご入力ください"
               name="pass_tes" required>
               <label for="floatingPassword">パスワードの確認</label>
            </div>

            <div class="form-floating">
               <input type="text" class="form-control" id=""  placeholder="名前の入力をしてください"
               name="name" required>
               <label for="floating">名前の入力をしてください</label>
            </div>

            <button class=" btn btn-lg btn-primary" type="submit">新規登録</button>
        </form>
    </main>

    <footer>
    	<p class="mt-5 mb-3 text-muted text-center">© mateGT</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
