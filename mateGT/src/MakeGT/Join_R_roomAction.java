package MakeGT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PartcipantBean;
import bean.UserBean;
import dao.ParticipantDao;
import tool.Action;

public class Join_R_roomAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        // ユーザーがログインしているか確認
        if (user == null || !user.isAuthenticated()) {
            res.sendRedirect("Login.action");
            return;
        }

        // リクエストパラメータから room_id を取得（例外処理付き）
        int roomId;
        try {
            roomId = Integer.parseInt(req.getParameter("room_id"));
        } catch (NumberFormatException e) {
            req.setAttribute("error", "無効な部屋IDです");
            req.getRequestDispatcher("R_Room.action").forward(req, res);
            return;
        }

        int userId = user.getNo();

        // 参加者情報を作成
        PartcipantBean participant = new PartcipantBean();
        participant.setRoomId(roomId);
        participant.setUserId(userId);

        // DAO を使用して参加処理
        ParticipantDao participantDao = new ParticipantDao();
        boolean isJoined = participantDao.addParticipant(participant);

        if (isJoined) {
            res.sendRedirect("r-room-conect.jsp");
        } else {
            req.setAttribute("error", "ルームへの参加に失敗しました");
            req.getRequestDispatcher("R_Room.action").forward(req, res);
        }
    }
}
