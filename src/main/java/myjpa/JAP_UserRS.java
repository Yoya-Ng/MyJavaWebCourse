package myjpa;

import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

// 在 jrest 已經註冊了Application ，在網址是會加上 /jrest/jpa_user_rs
@Path("/jpa_user_rs")
public class JAP_UserRS {

    private JPA_UserController controller = new JPA_UserController();

    @GET
    @Path("/{id}")
    public String get(@PathParam("id") Long id) {
        return new Gson().toJson(controller.findById(id));
    }

    @GET
    @Path("/all")
    public String queryAll() {
        return new Gson().toJson(controller.queryAll());
    }

    @POST
    public String create(@FormParam("name") String name,@FormParam("age") int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        controller.save(user);
        return "Create OK!";
    }
}
