package MakeGT;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RoomCreationBean;
import dao.RoomCreateDao;
import tool.Action;

public class R_RoomAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        RoomCreateDao dao = new RoomCreateDao();

        // ページ番号を取得（デフォルトは1）
        int page = 1;
        if (req.getParameter("page") != null) {
            try {
                page = Integer.parseInt(req.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1; // 不正な値なら1ページ目にする
            }
        }

        // `room_identification` を取得（デフォルトは2）
        int roomIdentification = 2;
        if (req.getParameter("room_identification") != null) {
            try {
                roomIdentification = Integer.parseInt(req.getParameter("room_identification"));
            } catch (NumberFormatException e) {
                roomIdentification = 2; // 不正な値ならデフォルト値を使用
            }
        }

        // `room_identification` に基づいた部屋データを取得
        List<RoomCreationBean> rooms = dao.getRoomsByIdentification(roomIdentification, page);
        req.setAttribute("rooms", rooms);

        // 総ページ数を計算
        int totalRooms = dao.getTotalRoomCountByIdentification(roomIdentification);
        int totalPages = (int) Math.ceil((double) totalRooms / RoomCreateDao.ROOMS_PER_PAGE);

        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("roomIdentification", roomIdentification);

        req.getRequestDispatcher("r-room.jsp").forward(req, res);
    }
}