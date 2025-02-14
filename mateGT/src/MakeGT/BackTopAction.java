package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class BackTopAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		req.getRequestDispatcher("Top_page.action").forward(req, res);
	}
}