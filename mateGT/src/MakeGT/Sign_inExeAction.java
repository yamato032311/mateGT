package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class Sign_inExeAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		req.getRequestDispatcher("top_page.jsp").forward(req, res);
	}
}