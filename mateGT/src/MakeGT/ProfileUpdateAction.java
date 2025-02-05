package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDao;
import tool.Action;

public class ProfileUpdateAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        int userId = user.getNo();
        String mainCharacterIdStr = req.getParameter("main_character_id");
        String subCharacterIdStr = req.getParameter("sub_character_id");
        String username = req.getParameter("username");
        String comment = req.getParameter("comment");

        Integer mainCharacterId = (mainCharacterIdStr != null && !mainCharacterIdStr.isEmpty()) ?
                Integer.parseInt(mainCharacterIdStr) : null;
        Integer subCharacterId = (subCharacterIdStr != null && !subCharacterIdStr.isEmpty()) ?
                Integer.parseInt(subCharacterIdStr) : null;

        UserDao userDao = new UserDao();

        user.setNo(userId);
        user.setName(username);
        user.setComment(comment);
        user.setMainCharaId(mainCharacterId);
        user.setSubCharaId(subCharacterId);

        boolean updateResult = userDao.updateUser_1(user);

        if (updateResult) {
            res.sendRedirect("Mypage.action");
        } else {
            req.setAttribute("errorMessage", "更新に失敗しました。");
            req.getRequestDispatcher("Profile.action").forward(req, res);
        }
    }
}
