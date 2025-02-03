package MakeGT;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CharacterBean;
import dao.CharacterDao;
import tool.Action;

public class ProfileAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		CharacterDao Cdao = new CharacterDao();
        List<CharacterBean> characters = Cdao.getAllCharacters();
        req.setAttribute("characters", characters);

        // profile.jspに転送
        req.getRequestDispatcher("profile.jsp").forward(req, res);
	}
}