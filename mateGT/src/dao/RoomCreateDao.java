package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.RoomCreationBean;

public class RoomCreateDao extends Dao {

	 public static final int ROOMS_PER_PAGE = 2; // 1ページあたりの部屋数

    // 部屋を作成するメソッド
    public int createRoom(String roomNum, String pass, int createdBy, int roomIdentification, int numberApplicants, Integer rateUpper, Integer rateLower) throws Exception {
        int roomId = 0;
        String sql = "INSERT INTO t002_room_creation (room_num, pass, created_by, room_identification, number_applicants, rate_upper, rate_lower, started_at) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, roomNum);
            ps.setString(2, pass);
            ps.setInt(3, createdBy);
            ps.setInt(4, roomIdentification);
            ps.setInt(5, numberApplicants);
            ps.setInt(6, rateUpper != null ? rateUpper : 0);
            ps.setInt(7, rateLower != null ? rateLower : 0);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        roomId = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Room creation failed.", e);
        }

        return roomId;
    }

    // 全ての部屋を取得するメソッド
    public List<RoomCreationBean> getAllRooms() throws Exception {
        List<RoomCreationBean> rooms = new ArrayList<>();

        String sql = "SELECT * FROM t002_room_creation ORDER BY started_at DESC";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rooms.add(mapRoom(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("部屋一覧の取得に失敗しました。", e);
        }

        return rooms;
    }

    // ページごとに部屋を取得するメソッド (ページネーション用)
    public List<RoomCreationBean> getAllRoomsByPage(int page) throws Exception {
        List<RoomCreationBean> rooms = new ArrayList<>();
        int offset = (page - 1) * ROOMS_PER_PAGE;

        String sql = "SELECT * FROM t002_room_creation ORDER BY started_at DESC LIMIT ? OFFSET ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, ROOMS_PER_PAGE);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rooms.add(mapRoom(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("部屋一覧の取得に失敗しました。", e);
        }

        return rooms;
    }

    // 総部屋数を取得するメソッド
    public int getTotalRoomCount() throws Exception {
        String sql = "SELECT COUNT(*) FROM t002_room_creation";
        int count = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("部屋数の取得に失敗しました。", e);
        }

        return count;
    }

    // 共通のマッピングメソッド
    private RoomCreationBean mapRoom(ResultSet rs) throws SQLException {
        RoomCreationBean room = new RoomCreationBean();
        room.setRoomId(rs.getInt("room_id"));
        room.setRoomNum(rs.getString("room_num"));
        room.setPass(rs.getString("pass"));
        room.setCreatedBy(rs.getInt("created_by"));
        room.setRoomIdentification(rs.getInt("room_identification"));
        room.setNumberApplicants(rs.getInt("number_applicants"));
        room.setRateUpper(rs.getInt("rate_upper"));
        room.setRateLower(rs.getInt("rate_lower"));
        room.setStartedAt(rs.getString("started_at"));
        return room;
    }

    // `room_identification` を指定して部屋を取得（ページネーション対応）
    public List<RoomCreationBean> getRoomsByIdentification(int roomIdentification, int page) throws Exception {
        List<RoomCreationBean> rooms = new ArrayList<>();
        int offset = (page - 1) * ROOMS_PER_PAGE;

        String sql = "SELECT * FROM t002_room_creation WHERE room_identification = ? ORDER BY started_at DESC LIMIT ? OFFSET ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roomIdentification);
            ps.setInt(2, ROOMS_PER_PAGE);
            ps.setInt(3, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rooms.add(mapRoom(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("部屋一覧の取得に失敗しました。", e);
        }

        return rooms;
    }

    // 指定した `room_identification` の部屋の総数を取得
    public int getTotalRoomCountByIdentification(int roomIdentification) throws Exception {
        String sql = "SELECT COUNT(*) FROM t002_room_creation WHERE room_identification = ?";
        int count = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roomIdentification);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("部屋数の取得に失敗しました。", e);
        }

        return count;
    }

}
