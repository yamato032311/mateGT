<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.ParticipantDao, bean.PartcipantBean" %>

<%
    int roomId = 9; // 仮のルームID
    ParticipantDao participantDao = new ParticipantDao();
    PartcipantBean participant = participantDao.getParticipantByRoom(roomId);
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>レート対戦待機画面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <div class="text-center mb-4">
            <h2>参加者</h2>
        </div>

        <div class="row">
            <div class="col-md-6">
                <% if (participant != null) { %>
                    <div class="card p-3 text-center">
                        <div class="font-weight-bold">ユーザーID: <%= participant.getUserId() %></div>
                        <div class="text-muted">レート: <%= participant.getEntryRate() %></div>
                        <div class="text-muted">参加時刻: <%= participant.getRoomStartTime() %></div>
                    </div>
                <% } else { %>
                    <div class="card p-3 text-center text-muted">プレイヤーが参加していません。</div>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>
