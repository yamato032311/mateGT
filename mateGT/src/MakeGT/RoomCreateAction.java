package MakeGT;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RoomCreationBean;
import bean.UserBean;
import dao.RoomCreateDao;

public class RoomCreateAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomNum = request.getParameter("room_num");
        String roomPass = request.getParameter("room_pass");
        int posterId = Integer.parseInt(request.getParameter("poster_id"));
        Integer roomType = Integer.valueOf(request.getParameter("room_identification"));
        Integer rateUpper = request.getParameter("rate_upper") != null ? Integer.valueOf(request.getParameter("rate_upper")) : null;
        Integer rateLower = request.getParameter("rate_lower") != null ? Integer.valueOf(request.getParameter("rate_lower")) : null;
        Integer numberApplicants = (roomType == 0) ? Integer.valueOf(request.getParameter("number_applicants")) : 1;

        RoomCreateDao dao = new RoomCreateDao();
        int roomId = -1;

        try {
            roomId = dao.createRoom(roomNum, roomPass, posterId, numberApplicants, roomType, rateUpper, rateLower);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        if (roomId > 0) {
            try {
                RoomCreationBean room = dao.getRoomById(roomId);
                UserBean poster = dao.getUserById(posterId);

                request.setAttribute("poster", poster);
                request.setAttribute("room", room);

                RequestDispatcher dispatcher;
                if (roomType == 0) {
                    dispatcher = request.getRequestDispatcher("o-room-connect.jsp");
                } else {
                    dispatcher = request.getRequestDispatcher("r-room-connect.jsp");
                }
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}