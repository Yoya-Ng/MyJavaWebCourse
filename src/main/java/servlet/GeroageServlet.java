
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class GeroageServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();//連接(HTTP) message body 第四層
        
        Set<Integer> Lotto = new TreeSet<>();
        while (Lotto.size() < 6) {            
            int number = new Random().nextInt(46) + 1;
            Lotto.add(number);
        }
        
        out.print("Lotto number = " + Lotto);
        
        String uri = ((HttpServletRequest)req).getRequestURI(); //取得URI的位子
        out.print(uri);
        
    }
    
}
