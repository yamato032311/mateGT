package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CharacterBean;
import bean.UserBean;
import dao.CharacterDao;
import tool.Action;

public class MypageAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{

        HttpSession session = req.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        // 未ログインでアクセスを試みた場合の処理
        if (user == null) {
        	// TOPページに強制的に遷移
        	res.sendRedirect("Login.action");
        } else {
        	CharacterDao characterDao = new CharacterDao();

        	// メイン
        	if (user.getMainCharaId() != null) {
        	    CharacterBean mainCharacter = characterDao.getCharacter(user.getMainCharaId());
        	    if (mainCharacter != null) {  // NULL チェックを追加
        	        req.setAttribute("imagePathMain", mainCharacter.getCharaIcon());
        	    }
        	}

        	// サブキャラの処理
        	if (user.getSubCharaId() != null) {
        	    CharacterBean subCharacter = characterDao.getCharacter(user.getSubCharaId());
        	    if (subCharacter != null) {  // NULL チェックを追加
        	        req.setAttribute("imagePathSub", subCharacter.getCharaIcon());
        	    }
        	}

        	req.getRequestDispatcher("mypage.jsp").forward(req, res);
        }

	}
}