
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GeroageServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();//連接(HTTP) message body 第四層
        out.print("Hello GeroageServlet ");
        out.print("Hello GeroageServlet 111222333444");
    }
    
}
