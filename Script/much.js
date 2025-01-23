// プレイヤーが参加したと仮定して、ボタンを有効化する例
function simulatePlayerJoin() {
    const player2Div = document.getElementById('player2');
    player2Div.innerHTML = `
      <div class="card p-3 text-center">
        <img src="user2-icon.png" alt="ユーザーアイコン" class="rounded-circle mb-2" style="width: 80px; height: 80px;">
        <div class="font-weight-bold">ユーザー名2</div>
        <div class="text-muted">レート: 1300</div>
        <div class="text-muted">使用キャラ: <img src="character2-icon.png" alt="キャラアイコン" class="w-8 h-8 inline-block"></div>
        <div class="text-muted">ひとこと: \"よろしくお願いします！\"</div>
      </div>
    `;
    document.querySelectorAll('button').forEach(button => button.removeAttribute('disabled'));
  
    // モーダル表示
    const matchModal = new bootstrap.Modal(document.getElementById('matchFoundModal'));
    matchModal.show();
  }
  
  // 対戦開始ボタンのイベントリスナー
  function setupStartMatchListener() {
    const startButton = document.getElementById('startMatchButton');
    startButton.addEventListener('click', () => {
      // ボタン有効化処理
      document.querySelectorAll('button').forEach(button => button.removeAttribute('disabled'));
  
      // モーダルを閉じる
      const matchModal = bootstrap.Modal.getInstance(document.getElementById('matchFoundModal'));
      matchModal.hide();
    });
  }
  
  // 初期化処理
  function initialize() {
    setupStartMatchListener();
  
    // シミュレーションのため、3秒後にプレイヤーが参加したように見せる
    setTimeout(simulatePlayerJoin, 3000);
  }
  
  // DOM読み込み後に初期化
  document.addEventListener('DOMContentLoaded', initialize);
  