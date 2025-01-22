<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            padding: 0;
            margin: 0;
            background-color: #f8f9fa;
        }
        .form-signin {
            max-width: 330px;
            padding: 15px;
        }
        .form-signin .form-floating:focus-within {
            z-index: 2;
        }
        .form-signin input[type="email"],
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-radius: 0;
        }
        .logo {
            width: 72px;
            height: 72px;
            display: block;
            margin: 0 auto 10px;
        }
    </style>
</head>
<body>
    <main class="form-signin text-center">
        <form action="LoginExe.action" method="post">
            <img class="logo mb-4" src="https://getbootstrap.jp/docs/4.3/assets/brand/bootstrap-solid.svg" alt="Bootstrap logo">
            <h1 class="h3 mb-3 fw-normal">ログイン</h1>

            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required>
                <label for="floatingInput">メールアドレス</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
                <label for="floatingPassword">パスワード</label>
            </div>

            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">ログイン</button>
            <p class="mt-5 mb-3 text-muted">© mateGT</p>
        </form>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
