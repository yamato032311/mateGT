package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class UserDao  extends Dao {


	public UserBean get(String no) throws Exception {
	    UserBean user = null;
	    String sql = "SELECT user_id, user_name, comment, main_chara_id, sub_chara_id " +
	                 "FROM t001_user WHERE user_id = ?";

	    try (Connection connection = getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, no);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            user = new UserBean();
	            user.setNo(resultSet.getInt("user_id"));  // ユーザーID
	            user.setName(resultSet.getString("user_name"));  // ユーザー名
	            user.setComment(resultSet.getString("comment")); // コメント

	            // メインキャラ
	            int mainCharaId = resultSet.getInt("main_chara_id");
	            user.setMainCharaId(resultSet.wasNull() ? null : mainCharaId);

	            // サブキャラ
	            int subCharaId = resultSet.getInt("sub_chara_id");
	            user.setSubCharaId(resultSet.wasNull() ? null : subCharaId);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("ユーザー情報の取得中にエラーが発生しました。", e);
	    }

	    return user;
	}



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
        String sql = "SELECT user_id, mail, pass, user_icon, user_name, main_chara_id, sub_chara_id, comment  " +
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
                        user.setMainCharaId(rs.getInt("main_chara_id"));
                        user.setSubCharaId(rs.getInt("sub_chara_id"));
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
        String sql = "UPDATE t001_user " +
                     "SET user_name = ?, comment = ?, " +
                     "    main_chara_id = ?, sub_chara_id = ? " +
                     "WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());  // ユーザー名
            ps.setString(2, user.getComment());  // コメント

            // メインキャラクターID
            if (user.getMainCharaId() == null) {
                ps.setNull(3, java.sql.Types.INTEGER);
            } else {
                ps.setInt(3, user.getMainCharaId());
            }

            // サブキャラクターID
            if (user.getSubCharaId() == null) {
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, user.getSubCharaId());
            }

            ps.setInt(5, user.getNo());  // ユーザーID

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("ユーザー情報の更新中にエラーが発生しました。", e);
        }
    }

}



    // IDでユーザーを取得
