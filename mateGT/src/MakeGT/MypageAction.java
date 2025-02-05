package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDao;
import tool.Action;

public class MypageAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{

        HttpSession session = req.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        // ユーザーデータをデータベースから取得
        UserDao userDao = new UserDao();
        user = userDao.get(String.valueOf(user.getNo()));
        session.setAttribute("user", user);

		req.getRequestDispatcher("mypage.jsp").forward(req, res);
	}
}