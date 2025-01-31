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
}

    // IDでユーザーを取得
