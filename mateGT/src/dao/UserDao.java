package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class UserDao  extends Dao {


    // ユーザーを追加
    public void insertUser(UserBean user) throws Exception {
        try (
        	Connection connection=getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO t001_user (mail, pass, user_name) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, user.getMail());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, user.getName());
            preparedStatement.executeUpdate();

        }
    }

    public UserBean loginUser(String mail, String pass) throws Exception {
        String sql = "SELECT user_id, mail, pass, user_icon, user_name, main_chara_id, comment " +
                     "FROM t001_user WHERE mail = ? AND pass = ?";

        try (Connection conn = getConnection();  // DaoのgetConnection()を利用
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mail);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                {
                        UserBean user = new UserBean();
                        user.setNo(rs.getInt("user_id"));
                        user.setMail(rs.getString("mail"));
                        user.setPass(rs.getString("pass"));  // セキュリティ上、返さないほうが良い
                        user.setIcon(rs.getInt("user_icon"));
                        user.setName(rs.getString("user_name"));
                        user.setChara_id(rs.getInt("main_chara_id"));
                        user.setComment(rs.getString("comment"));
                        return user;
                    }
                }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("データベースエラーが発生しました。");
        }
        return null;  // ユーザーが見つからない場合
    }

    public boolean updateUser_1(UserBean user) throws Exception {
        String sql = "UPDATE t001_user u LEFT JOIN T010_character c1 ON u.chara_main_id = c1.chara_id "+
                 "LEFT JOIN T010_character c2 ON u.chara_sub_id = c2.chara_id " +
                 "SET u.user_name = ?, u.comment = ?, u.chara_sub_id = ? u.sub_id = ? WHERE u.user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());// ユーザー名
            ps.setString(2, user.getComment());   // コメント

            if (user.getChara_id() == null) {
                ps.setNull(5, java.sql.Types.INTEGER); // NULL をセット
            } else {
                ps.setInt(5, user.getChara_id());
            }

            // chara_sub_id の処理
            if (user.getSub_id() == null) {
                ps.setNull(6, java.sql.Types.INTEGER);
            } else {
                ps.setInt(6, user.getSub_id());
            }
            ps.setInt(5, user.getNo());           // 更新対象のユーザーID

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // 1行以上更新されたら成功
        }
    }
}

    // IDでユーザーを取得
