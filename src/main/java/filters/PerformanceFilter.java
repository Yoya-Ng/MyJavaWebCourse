package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class PerformanceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        //before 之前會執行的
        chain.doFilter(request, response);
        //after 之後會執行的
        long end = System.currentTimeMillis();
        System.out.println(((HttpServletRequest) request).getRequestURI() + " : " + (end - begin) + " ms");
    }

    @Override
    public void destroy() {
    }

}
