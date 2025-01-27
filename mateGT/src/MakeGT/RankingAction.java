package MakeGT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class RankingAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{


		 List<Map<String, String>> ranks = new ArrayList<>();
	        for (int i = 1; i <= 3; i++) {
	            Map<String, String> rank = new HashMap<>();
	            rank.put("position", String.valueOf(i));
	            rank.put("iconPath", "icon.png"); // 画像パスを指定
	            ranks.add(rank);
	        }

	        req.setAttribute("ranks", ranks);
	        req.getRequestDispatcher("ranking.jsp").forward(req, res);
	    }
	}