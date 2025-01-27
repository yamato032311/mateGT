package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class O_Room_CreateAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		req.getRequestDispatcher("o-room-create.jsp").forward(req, res);
	}
}