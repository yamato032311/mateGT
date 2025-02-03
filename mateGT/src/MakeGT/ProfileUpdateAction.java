package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;
import tool.Action;

public class ProfileUpdateAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{

		int main_character_id =Integer.parseInt(req.getParameter("main_character_id"));
		int sub_character_id=Integer.parseInt(req.getParameter("sub_character_id"));
		String username=req.getParameter("username");
		String comment=req.getParameter("comment");
		boolean count;

        UserDao userDao = new UserDao();
        UserBean user=new UserBean();

        user.setName(username);
        user.setComment(comment);
        user.setChara_id(main_character_id);
        user.setSub_id(sub_character_id);

        count=userDao.updateUser_1(user);

        if (count= true) {
            res.sendRedirect("Mypage.action");
        } else {
            req.setAttribute("errorMessage", "メールアドレスまたはパスワードが間違っています。");
            req.getRequestDispatcher("Profile.action").forward(req, res);
		}



	}
}