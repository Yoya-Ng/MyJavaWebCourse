
package mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.HelloModel;

@WebServlet("/mvc/HelloController")
public class HelloController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 取得 html 傳來的資料
        String username = req.getParameter("username");
        
        // Model
        HelloModel hm = new HelloModel();
        hm.setUsername(username);
        
        // View
        req.setAttribute("hello", hm);
        // 傳導到指定目的
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/view/hello_view.jsp");
        rd.forward(req, resp);
        //方法二
        //resp.sendRedirect("/WEB-INF/mvc/view/hello_view.jsp/WEB-INF/mvc/view/hello_view.jsp");
    }
    
}
