package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.PartcipantBean;

public class ParticipantDao extends Dao {

    public boolean addParticipantRate(PartcipantBean participant) throws Exception {
        String checkUserSql = "SELECT rate FROM t001_user WHERE user_id = ?";
        String checkRoomSql = "SELECT room_identification FROM t002_room_creation WHERE room_id = ?";
        String checkRoomCapacitySql = "SELECT COUNT(*) FROM t003_participants WHERE room_id = ?";

        String insertSqlType1 = "INSERT INTO t003_participants (room_id, user_id, room_start_time) VALUES (?, ?, NOW())";
        String insertSqlType2 = "INSERT INTO t003_participants (room_id, user_id, entry_rate, room_start_time) VALUES (?, ?, ?, NOW())";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            int entryRate = 0;
            int roomIdentification = 0;

            // ユーザーのレート取得
            try (PreparedStatement userStmt = conn.prepareStatement(checkUserSql)) {
                userStmt.setInt(1, participant.getUserId());
                try (ResultSet rs = userStmt.executeQuery()) {
                    if (rs.next()) {
                        entryRate = rs.getInt("rate");
                    } else {
                        conn.rollback();
                        return false;
                    }
                }
            }

            // ルーム情報取得 (roomIdentification を RoomCreationBean に適用)
            try (PreparedStatement roomStmt = conn.prepareStatement(checkRoomSql)) {
                roomStmt.setInt(1, participant.getRoomId());
                try (ResultSet rs = roomStmt.executeQuery()) {
                    if (rs.next()) {
                        roomIdentification = rs.getInt("room_identification");
                    } else {
                        conn.rollback();
                        return false;
                    }
                }
            }

            // 参加者上限確認
            int maxParticipants = (roomIdentification == 1) ? 4 : 2;
            try (PreparedStatement capacityStmt = conn.prepareStatement(checkRoomCapacitySql)) {
                capacityStmt.setInt(1, participant.getRoomId());
                try (ResultSet rs = capacityStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) >= maxParticipants) {
                        conn.rollback();
                        return false;
                    }
                }
            }

            // 参加登録
            try (PreparedStatement pstmt = conn.prepareStatement(
                    roomIdentification == 1 ? insertSqlType1 : insertSqlType2)) {
                pstmt.setInt(1, participant.getRoomId());
                pstmt.setInt(2, participant.getUserId());
                if (roomIdentification == 2) pstmt.setInt(3, entryRate);
                if (pstmt.executeUpdate() <= 0) {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



        /**
         * 指定したルームに参加者を追加する
         */
        public boolean addParticipant(PartcipantBean participant) throws Exception {
            String checkRoomCapacitySql = "SELECT number_applicants FROM t002_room_creation WHERE room_id = ?";
            String countParticipantsSql = "SELECT COUNT(*) FROM t003_participants WHERE room_id = ?";
            String insertParticipantSql = "INSERT INTO t003_participants (room_id, user_id, room_start_time) VALUES (?, ?, NOW())";

            try (Connection conn = getConnection()) {
                conn.setAutoCommit(false);

                int maxParticipants = 0;
                int currentParticipants = 0;

                // ルームの最大参加者数を取得
                try (PreparedStatement pstmt = conn.prepareStatement(checkRoomCapacitySql)) {
                    pstmt.setInt(1, participant.getRoomId());
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            maxParticipants = rs.getInt("number_applicants");
                        } else {
                            conn.rollback();
                            return false;
                        }
                    }
                }

                // 現在の参加者数を取得
                try (PreparedStatement pstmt = conn.prepareStatement(countParticipantsSql)) {
                    pstmt.setInt(1, participant.getRoomId());
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            currentParticipants = rs.getInt(1);
                        }
                    }
                }

                // 参加可能か確認
                if (currentParticipants >= maxParticipants) {
                    conn.rollback();
                    return false;
                }

                // 参加者追加
                try (PreparedStatement pstmt = conn.prepareStatement(insertParticipantSql)) {
                    pstmt.setInt(1, participant.getRoomId());
                    pstmt.setInt(2, participant.getUserId());
                    if (pstmt.executeUpdate() <= 0) {
                        conn.rollback();
                        return false;
                    }
                }

                conn.commit();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
}


