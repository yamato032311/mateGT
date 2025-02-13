<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>オープンルーム待機画面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- BootstrapとJavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        let participants = [
            { id: 1, name: "ユーザー名1", rate: 1200, character: "character1-icon.png", message: "頑張ります！" }
        ]; // 初期プレイヤー1

        function addParticipant(newPlayer) {
            const playerList = document.getElementById('players');

            let playerCard =
                <div class="col-md-6">
                    <div class="card p-3 text-center">
                        <img src="user-icon.png" alt="ユーザーアイコン" class="rounded-circle mb-2" style="width: 80px; height: 80px;">
                        <div class="fw-bold">${newPlayer.name}</div>
                        <div class="text-muted">レート: ${newPlayer.rate}</div>
                        <div class="text-muted">使用キャラ: <img src="${newPlayer.character}" alt="キャラアイコン" class="w-8 h-8 inline-block"></div>
                        <div class="text-muted">ひとこと: "${newPlayer.message}"</div>
                    </div>
                </div>
            ;

            playerList.innerHTML += playerCard;
        }

        function simulatePlayerJoin() {
            const newPlayer = {
                id: participants.length + 1,
                name: "ユーザー名" + (participants.length + 1),
                rate: 1100 + (participants.length * 100),
                character: "character2-icon.png",
                message: "よろしくお願いします！"
            };

            participants.push(newPlayer);
            addParticipant(newPlayer);

            if (participants.length > 1) {
                document.querySelectorAll('button').forEach(button => button.removeAttribute('disabled'));
                const matchModal = new bootstrap.Modal(document.getElementById('matchFoundModal'));
                matchModal.show();
            }
        }

        document.addEventListener('DOMContentLoaded', () => {
            setTimeout(simulatePlayerJoin, 3000);
            setTimeout(simulatePlayerJoin, 6000);
        });
    </script>
</head>
<body>
    <div class="container my-5">
        <!-- 参加者セクション -->
        <div class="text-center mb-4">
            <h2>参加者</h2>
        </div>
        <div class="row" id="players">
            <!-- 初期プレイヤー1 -->
            <div class="col-md-6">
                <div class="card p-3 text-center">
                    <img src="user1-icon.png" alt="ユーザーアイコン" class="rounded-circle mb-2" style="width: 80px; height: 80px;">
                    <div class="fw-bold">ユーザー名1</div>
                    <div class="text-muted">レート: 1200</div>
                    <div class="text-muted">使用キャラ: <img src="character1-icon.png" alt="キャラアイコン" class="w-8 h-8 inline-block"></div>
                    <div class="text-muted">ひとこと: "頑張ります！"</div>
                </div>
            </div>
        </div>

        <!-- 退出ボタン -->
        <div class="text-center my-4">
            <a href="BackTop.action" class="btn btn-danger">退出</a>
        </div>

        <!-- ルーム情報 -->
        <div class="text-center mb-4">
            <p>ルームID: 12345</p>
            <p>パスワード: 1234</p>
        </div>

        <!-- チャットセクション -->
        <div class="text-center mb-4">
            <h3>チャット</h3>
        </div>
        <div class="card p-4 shadow-sm">
            <div>
                <p><span class="fw-bold">ユーザー名1:</span> こんにちは！よろしくお願いします。</p>
            </div>
        </div>
    </div>

    <!-- モーダル -->
    <div class="modal fade" id="matchFoundModal" tabindex="-1" aria-labelledby="matchFoundModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="matchFoundModalLabel">対戦相手が見つかりました！</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    対戦相手とマッチングしました。ゲームを開始しますか？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">キャンセル</button>
                    <button type="button" class="btn btn-primary" id="startMatchButton">対戦開始</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
