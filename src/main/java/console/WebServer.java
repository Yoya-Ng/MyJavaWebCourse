import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String args[]) {
        WebServer ws = new WebServer();
        ws.start();
    }

    protected void start() {
        ServerSocket server;

        System.out.println("Webserver 啟動 on port 5000");
        try {
            server = new ServerSocket(5000);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println("等待連線...");
        while (true) {
            try (   // 等待連線...
                    Socket sock = server.accept();
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    sock.getOutputStream(), "big5")), true);) {

                System.out.println("瀏覽器已連入 !");

                // 回應 HTML 文件結構 (4 parts)
                // Part 1 : Init line
                out.println("HTTP/1.0 200 OK");
                
                // Part 2 : Header info. 
                out.println("Content-Type: text/html");
                out.println("Server: TestWebServer");
                
                // Part 3 : Blank line
                out.println("");
                
                // Part 4 : HTML page content
                //回應HTML給 Client
                out.println("<H1><font color=red>歡迎光臨~</font></H2>");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

