package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class O_RoomAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		req.getRequestDispatcher("o-room.jsp").forward(req, res);
	}
}