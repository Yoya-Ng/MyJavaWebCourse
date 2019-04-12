package myjpa;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myjpa/JPA_UserServlet")
public class JPA_UserServlet extends HttpServlet {

    private JPA_UserController controller = new JPA_UserController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        String method = req.getParameter("method");
        User user;
        String name;
        Long id;
        int age;
        switch (method) {
            case "save": // ?method=save&name=Joe&age=28 
                name = req.getParameter("name");
                age = Integer.parseInt(req.getParameter("age"));
                user = new User();
                user.setName(name);
                user.setAge(age);
                controller.save(user);
                out.print("save ok");
                break;
            case "update": // ?method=update&id=1&name=Joe&age=28 
                id = Long.parseLong(req.getParameter("id"));
                name = req.getParameter("name");
                user = controller.findById(id);
                user.setName(name);
                controller.update(user);
                out.print("update ok");
                break;
            case "delete": // ?method=delete&id=1 
                id = Long.parseLong(req.getParameter("id"));
                user = controller.findById(id);
                controller.delete(user);
                out.print("delete ok");
                break;
            case "findById": // ?method=findById&id=1 
                id = Long.parseLong(req.getParameter("id"));
                user = controller.findById(id);
                out.print("delete ok" + user);
                break;
            case "queryByAge": // ?method=queryByAge&age=20 
                age = Integer.parseInt(req.getParameter("age"));
                out.print(gson.toJson(controller.queryByAge(age)));
                break;
            default:
                out.print(gson.toJson(controller.queryAll()));
        }

    }

}
