package servlet.upload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
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
        location = "/Users/Tian/Desktop/Java Duan Teacher/Java 8 Web/MyJavaWebCourse/temp/",
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;chartset=UTF-8");
        PrintWriter out = resp.getWriter();

        String title = "";
        String ofileName = "";
        String fileName = "";
        int bytes = 0;
        String base64 = "";
        boolean authCodeOK = false;

        for (Part part : req.getParts()) {
            switch (part.getName()) {
                case "title":
                    //取的文字串流，轉亂成byte顯示出來
//                    InputStream is = part.getInputStream();
//                    byte[] b = new byte[1];
//                    while(is.read(b) != -1) {
//                        out.print((char)b[0]);
//                    }

                    //利用工具取得文字串流
                    title = Util.getValue(part.getInputStream());
                    break;
                case "myAuthCode":
                    String myAuthCode = Util.getValue(part.getInputStream());
                    String authCode = req.getSession().getAttribute("authCode").toString();
                    authCodeOK = myAuthCode.equalsIgnoreCase(authCode);
                    break;
                case "upload":
                    //out.println("get upload");
                    //此方法名稱固定 不實用
                    //part.write("/Users/Tian/Desktop/Java Duan Teacher/Java 8 Web/MyJavaWebCourse/temp/我的照片.jsp");

                    //會在 Mclaren [中間加入亂碼做為名稱]  .jsp
                    fileName = File.createTempFile("Mclaren", ".jsp").getName();
                    //設定 location 就不需加路徑（會重複）
                    //part.write("/Users/Tian/Desktop/Java Duan Teacher/Java 8 Web/MyJavaWebCourse/temp/" + FileName);
                    part.write(fileName);
                    ofileName = Util.getFileName(part);
                    InputStream is = part.getInputStream();
                    bytes = is.available();
                    base64 = Util.getBase64(is);
                    break;
            }
        }
        if (!authCodeOK) {
            // 產生 Error 圖樣
            BufferedImage image = Util.getAuthImg("Error");
            // 建立 ByteArrayOutputStream 容器(baos)
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 將 image 物件資料存入 ByteArrayOutputStream 容器(baos)
            ImageIO.write(image, "jpg", baos);
            // 將 byte[] 轉 InputStream
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            // 產生 base64 碼
            base64 = Util.getBase64(is);
        }

        String json = "{\"title\":\"%s\", \"ofileName\":\"%s\", \"fileName\":\"%s\", \"bytes\":\"%d\", \"base64\":\"%s\"}";
        json = String.format(json, title, ofileName, fileName, bytes, base64);
        out.println(json);
    }

}
