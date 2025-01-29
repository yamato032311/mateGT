package tool;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.action"})
public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = request.getServletPath().substring(1); // 例: "SigninExe.action"
            String name = path.replace(".a", "A").replace('/', '.'); // "SigninExeAaction" → "MakeGT.SigninExeAction"

            System.out.println("Resolved class name: " + name); // デバッグログ

            Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
            action.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // エラーログ出力
            request.getRequestDispatcher("/error.jsp").forward(request, response); // エラー画面へフォワード
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
