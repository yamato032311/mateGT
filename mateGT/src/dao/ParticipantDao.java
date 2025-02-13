package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PartcipantBean;

public class ParticipantDao extends Dao {

    // 参加者を追加する
    public boolean addParticipant(PartcipantBean participant) throws Exception {
        String checkUserSql = "SELECT rate FROM t001_user WHERE user_id = ?";
        String checkRoomSql = "SELECT room_indification FROM t002_room_creation WHERE room_id = ?";
        String checkRoomCapacitySql = "SELECT COUNT(*) FROM t003_participants WHERE room_id = ?";
        String insertSql = "INSERT INTO t003_participants (user_id, room_id, entry_rate, user_win_flag, room_start_time) VALUES (?, ?, ?, ?, NOW())";
        String updateRateSql = "UPDATE t001_user SET rate = rate + 10 WHERE user_id = ?"; // entry_rate変更用
        String updateWinFlagSql = "UPDATE t003_participants SET win_flag = 1 WHERE user_id = ? AND room_id = ?"; // win_flag変更用

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            int entryRate = 0;
            int roomIndification = 0;

            // ユーザーが存在するか確認 & レート取得
            try (PreparedStatement userStmt = conn.prepareStatement(checkUserSql)) {
                userStmt.setInt(1, participant.getUserId());
                try (ResultSet rs = userStmt.executeQuery()) {
                    if (rs.next()) {
                        entryRate = rs.getInt("rate");
                    } else {
                        conn.rollback();
                        System.err.println("Error: user_id " + participant.getUserId() + " does not exist.");
                        return false;
                    }
                }
            }

            // ルームの情報を取得 (room_indification を取得)
            try (PreparedStatement roomStmt = conn.prepareStatement(checkRoomSql)) {
                roomStmt.setInt(1, participant.getRoomId());
                try (ResultSet rs = roomStmt.executeQuery()) {
                    if (rs.next()) {
                        roomIndification = rs.getInt("room_indification");
                    } else {
                        conn.rollback();
                        System.err.println("Error: room_id " + participant.getRoomId() + " does not exist.");
                        return false;
                    }
                }
            }

            // ルームの参加人数を確認 (上限は room_indification によって異なる)
            int maxParticipants = (roomIndification == 1) ? 4 : 2;

            try (PreparedStatement capacityStmt = conn.prepareStatement(checkRoomCapacitySql)) {
                capacityStmt.setInt(1, participant.getRoomId());
                try (ResultSet rs = capacityStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) >= maxParticipants) {
                        conn.rollback();
                        System.err.println("Error: room_id " + participant.getRoomId() + " is full (max " + maxParticipants + " players).");
                        return false;
                    }
                }
            }

            // 参加者情報を追加
            int winFlag = 0;
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setInt(1, participant.getUserId());
                pstmt.setInt(2, participant.getRoomId());
                pstmt.setInt(3, entryRate);
                pstmt.setInt(4, winFlag);

                int result = pstmt.executeUpdate();
                if (result <= 0) {
                    conn.rollback();
                    return false;
                }
            }

            // ルーム種別が 2 の場合は entry_rate と win_flag を変更
            if (roomIndification == 2) {
                // entry_rate を変更
                try (PreparedStatement updateRateStmt = conn.prepareStatement(updateRateSql)) {
                    updateRateStmt.setInt(1, participant.getUserId());
                    updateRateStmt.executeUpdate();
                }

                // win_flag を更新
                try (PreparedStatement updateWinFlagStmt = conn.prepareStatement(updateWinFlagSql)) {
                    updateWinFlagStmt.setInt(1, participant.getUserId());
                    updateWinFlagStmt.setInt(2, participant.getRoomId());
                    updateWinFlagStmt.executeUpdate();
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 指定されたルームの参加者リストを取得
    public List<PartcipantBean> getParticipantsByRoom(int roomId) throws Exception {
        String sql = "SELECT * FROM t003_participants WHERE room_id = ?";
        List<PartcipantBean> participants = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PartcipantBean participant = new PartcipantBean();
                    participant.setParticipantId(rs.getInt("participant_id"));
                    participant.setRoomId(rs.getInt("room_id"));
                    participant.setUserId(rs.getInt("user_id"));
                    participant.setEntryRate(rs.getInt("entry_rate"));
                    participant.setUserWinFlag(rs.getInt("win_flag")); // win_flag を追加
                    participant.setRoomStartTime(rs.getTimestamp("room_start_time"));
                    participants.add(participant);
                }
            }
        }
        return participants;
    }
}
