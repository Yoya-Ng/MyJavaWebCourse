package mvc.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.StockModel;

@WebServlet("/mvc/controller/StockController")
public class StockController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String symbol = req.getParameter("symbol");
        
        // Model
        StockModel sm = new StockModel(symbol);
        
        // bm 轉 json
        String json = new Gson().toJson(sm);
        
        // View
        req.setAttribute("json", json);
        // 傳導到指定目的
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/stock_view.jsp");
        rd.forward(req, resp);

    }

}
