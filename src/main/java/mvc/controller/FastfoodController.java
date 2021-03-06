package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.BMIModel;

@WebServlet("/mvc/controller/FastfoodController")
public class FastfoodController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文化
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;chartset=utf-8");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        if (session == null) {
            out.print("請先消費");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/fastfood_view.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文化
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;chartset=utf-8");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if (session.isNew()) {
            out.println("您是第一次進來");
            session.setAttribute("firsttime", true);
        } else {
            session.setAttribute("firsttime", false);
        }
        
        out.println("您得 Seession ID = " + session.getId());
        String[] food_titles = req.getParameterValues("food_title");
        String[] food_prices = req.getParameterValues("food_price");

        session.setAttribute("food_titles", food_titles);
        session.setAttribute("food_prices", food_prices);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/fastfood_view.jsp");
        rd.forward(req, resp);
    }

}
