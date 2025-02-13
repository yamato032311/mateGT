package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.RoomCreateDao;
import tool.Action;

public class O_Room_CreateExeAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        String roomNum = req.getParameter("room_num");
        String roomPass = req.getParameter("room_pass");
        int room_Identification = 1;
        int numberApplicants = Integer.parseInt(req.getParameter("number_applicants"))  ;
        Integer rateUpper = safeParseInteger(req.getParameter("rate_upper"));
        Integer rateLower = safeParseInteger(req.getParameter("rate_lower"));

        RoomCreateDao dao = new RoomCreateDao();
        int roomId;

        try {
            roomId = dao.createRoom(roomNum, roomPass, user.getNo(), room_Identification, numberApplicants, rateUpper, rateLower);
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("error.jsp?error=db");
            return;
        }

        if (roomId > 0) {
            try {
                req.getRequestDispatcher("Top_page.action").forward(req, res);
            } catch (Exception e) {
                e.printStackTrace();
                res.sendRedirect("error.jsp?error=redirect");
            }
        } else {
            res.sendRedirect("error.jsp?error=limit");
        }
    }

    // 安全な整数パース用のメソッド
    private Integer safeParseInteger(String param) {
        if (param == null || param.trim().isEmpty()) {
            return null; // 空文字またはnullならnullを返す
        }
        try {
            return Integer.valueOf(param);
        } catch (NumberFormatException e) {
            return null; // 無効な値ならnullを返す
        }
    }
}


