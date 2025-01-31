package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDao;
import tool.Action;

public class LoginExeAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String mail = req.getParameter("mail");
        String pass = req.getParameter("pass");
        UserDao userDao = new UserDao();
        UserBean user = userDao.loginUser(mail, pass);

        if (user != null) {
        	user.setAuthenticated(true);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            res.sendRedirect("Top_page.action"); // ホーム画面へ
        } else {
            req.setAttribute("errorMessage", "メールアドレスまたはパスワードが間違っています。");
            req.getRequestDispatcher("Login.action").forward(req, res);
		}
	}
}
