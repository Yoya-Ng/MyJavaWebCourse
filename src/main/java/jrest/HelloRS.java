package jrest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloRS {

    @GET
    public String sayHello() {
        return "Hello !";
    }

    @GET
    @Path("/{name}")
    public String sayHi(@PathParam("name") String name) {
        return "Hello " + name ;
    }
    
    @GET
    @Path("/lotto")
    public String getLotto() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 6) {
            set.add(new Random().nextInt(46) + 1);
        }
        return set.toString();
    }

    @GET
    @Path("/bmi")
    //public double calcBMI( @FormParam ){ @FormParam 此參數為ＰＯＳＴ用
    //http://localhost:8084/MyJavaWebCourse/jrest/hello/bmi?h=170&w=70 在網址輸入參數
    public double calcBMI(@QueryParam("h") double height, @QueryParam("w") double weight) {
        double bmi = weight/ Math.pow(height, 2);
        return bmi;
    }
}
