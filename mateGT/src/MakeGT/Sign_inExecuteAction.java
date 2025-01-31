package MakeGT;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;
import tool.Action;

public class Sign_inExecuteAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws SQLException,Exception{

		String mail;
		String pass;
		String pass_tes;
		String name;
		UserDao userDao = new UserDao();

		mail = req.getParameter("mail");
        pass = req.getParameter("pass");
        pass_tes = req.getParameter("pass_tes");
        name = req.getParameter("name");


        // パスワードが一致するか確認
        if (pass.equals(pass_tes)) {
            // UserBeanを作成
            UserBean user = new UserBean();
            user.setMail(mail);
            user.setPass(pass);
            user.setName(name);// 必要であればパスワードをハッシュ化してください


                // insertUserメソッドを呼び出してユーザーをデータベースに保存
            userDao.insertUser(user);

                // 登録が成功した場合のリダイレクト
            res.sendRedirect("Login.action");  // 成功ページへリダイレクト
            } else {
            // パスワードが一致しない場合
            res.sendRedirect("Sign_in.action"); // パスワード不一致ページへリダイレクト
        }
    }
	}