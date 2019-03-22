package mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.BMIModel;

@WebServlet("/controller/BMIController")
public class BMIController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int h = Integer.parseInt(req.getParameter("height"));
        int w = Integer.parseInt(req.getParameter("weight"));

        BMIModel bmi = new BMIModel(h, w);

        req.setAttribute("bmi", bmi);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/bmi_view.jsp");
        rd.forward(req, resp);
    }

}
