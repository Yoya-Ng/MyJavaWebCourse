package servlet.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.Util;

@WebServlet("/servlet/upload/UploadServlet")
@MultipartConfig(
                 fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;chartset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        String title = "";
        for (Part part : req.getParts()) {
            switch (part.getName()) {
                case "title":
//                    InputStream is = part.getInputStream();
//                    byte[] b = new byte[1];
//                    while(is.read(b) != -1) {
//                        out.print((char)b[0]);
//                    }
                    title = Util.getValue(part.getInputStream());
                    break;
                case "upload":
                    out.println("get upload");
                    //此方法名稱固定 不實用
                    //part.write("/Users/Tian/Desktop/Java Duan Teacher/Java 8 Web/MyJavaWebCourse/temp/我的照片.jsp");
                    
                    //會在 Mclaren [中間加入亂碼做為名稱]  .jsp
                    String FileName = File.createTempFile("Mclaren", ".jsp").getName();
                    part.write("/Users/Tian/Desktop/Java Duan Teacher/Java 8 Web/MyJavaWebCourse/temp/"+FileName);
                    
                    break;
            }
        }
        
        out.append(title);
        out.print("Upload OK");
    }
    
}
