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
        	PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO t001_user (mail, pass) VALUES (?, ?)")) {
            preparedStatement.setString(1, user.getMail());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.executeUpdate();

        }
    }

    public UserBean loginUser(String mail, String pass) throws Exception{
    	  String sql = "SELECT user_id, mail, pass, user_icon, user_name, main_chara_id, comment " +
                  "FROM t001_user WHERE mail = ? AND pass = ?";

     // Try-with-resources to ensure connection, prepared statement, and result set are closed properly
     try (Connection conn = getConnection();
          PreparedStatement ps = conn.prepareStatement(sql)) {

         ps.setString(1, mail);  // Set the mail parameter
         ps.setString(2, pass);  // Set the password parameter

         try (ResultSet rs = ps.executeQuery()) {

             if (rs.next()) {
                 // If a user is found, create and populate the UserBean object
                 UserBean user = new UserBean();
                 user.setNo(rs.getInt("user_id"));
                 user.setMail(rs.getString("mail"));
                 user.setPass(rs.getString("pass"));
                 user.setIcon(rs.getInt("user_icon"));
                 user.setName(rs.getString("user_name"));
                 user.setComment(rs.getString("comment"));
                 return user;  // Return the user if found
             }
         }
     } catch (SQLException e) {
         e.printStackTrace();  // Log the exception (optional)
     }

     // Return null if no matching user is found
     return null;
 }
}

    // IDでユーザーを取得
