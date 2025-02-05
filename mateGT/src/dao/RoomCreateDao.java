package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.RoomCreationBean;
import bean.UserBean;

public class RoomCreateDao extends Dao {

    public int createRoom(String roomNum, String pass, int createdBy, Integer numberApplicants, int roomIdentification, Integer rateUpper, Integer rateLower) throws Exception{
        int roomId = -1;
        String sql = "INSERT INTO t002_room_creation (room_num, pass, created_by, number_applicants, room_identification, rate_upper, rate_lower, started_at) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW()) RETURNING room_id";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, roomNum);
            ps.setString(2, pass);
            ps.setInt(3, createdBy);
            ps.setInt(4, numberApplicants != null ? numberApplicants : 1);
            ps.setInt(5, roomIdentification);
            ps.setInt(6, rateUpper != null ? rateUpper : 0);
            ps.setInt(7, rateLower != null ? rateLower : 0);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                roomId = rs.getInt("room_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomId;
    }

    public RoomCreationBean getRoomById(int roomId) throws Exception {
        RoomCreationBean room = null;
        String sql = "SELECT * FROM t002_room_creation WHERE room_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                room = new RoomCreationBean();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomNum(rs.getString("room_num"));
                room.setPass(rs.getString("pass"));
                room.setCreatedBy(rs.getInt("created_by"));
                room.setNumberApplicants(rs.getInt("number_applicants"));
                room.setRateUpper(rs.getObject("rate_upper") != null ? rs.getInt("rate_upper") : null);
                room.setRateLower(rs.getObject("rate_lower") != null ? rs.getInt("rate_lower") : null);
                room.setRoomIdentification(rs.getInt("room_identification") == 0 ? "オープンルーム" : "リクエストルーム");
                room.setStartedAt(rs.getString("started_at"));
                room.setFinishedAt(rs.getString("finished_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public UserBean getUserById(int userId) throws Exception {
        UserBean user = null;
        String sql = "SELECT * FROM t001_user WHERE user_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserBean();
                user.setNo(rs.getInt("user_id"));
                user.setMail(rs.getString("mail"));
                user.setPass(rs.getString("password")); // パスワードカラム名は仮置き
                user.setIcon(rs.getInt("user_icon"));
                user.setName(rs.getString("user_name"));
                user.setChara_id(rs.getInt("main_chara_id")); // main_chara_id を chara_id にマッピング
                user.setComment(rs.getString("comment"));
                user.setAuthenticated(true); // 認証済みとする場合
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
