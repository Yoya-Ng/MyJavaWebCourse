package vo; 
 
import java.io.Serializable; 
 
public class Food implements Serializable{ 
    private String title; 
    private String price; 
 
    public Food(String title, String price) { 
        this.title = title; 
        this.price = price; 
    } 
 
    public String getTitle() { 
        return title; 
    } 
 
    public void setTitle(String title) { 
        this.title = title; 
    } 
 
    public String getPrice() { 
        return price; 
    } 
 
    public void setPrice(String price) { 
        this.price = price; 
    } 
 
    @Override 
    public String toString() { 
        return "Food{" + "title=" + title + ", price=" + price + '}'; 
    } 
     
     
} 