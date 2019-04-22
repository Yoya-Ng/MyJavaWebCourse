package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public static int count;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("監聽 count = " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        System.out.println("監聽 count = " + count);
    }

}
