package jrest;

import com.google.gson.Gson;

import dao.UserDao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
public class UserRS {
    private UserDao dao;

    // 預設建構值 會自動加入到所有建構值中
    {
        dao = new UserDao();
    }
    
    @GET
    @Path("/{id}")
    public String get(@PathParam("id") int id) {
        return new Gson().toJson(dao.get(id));
    }
    
    @GET
    @Path("/all")
    public String queryAll() {
        return new Gson().toJson(dao.queryAll());
    }
    
    
}
