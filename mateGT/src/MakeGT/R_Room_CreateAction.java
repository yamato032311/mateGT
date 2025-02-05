package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class R_Room_CreateAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{

		req.getRequestDispatcher("r-room-create.jsp").forward(req, res);
	}
}