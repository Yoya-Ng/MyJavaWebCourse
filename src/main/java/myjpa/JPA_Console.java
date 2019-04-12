package myjpa; 
 
import javax.persistence.EntityManager; 
import javax.persistence.EntityTransaction; 
 
public class JPA_Console { 
     
    public static void main(String[] args) { 
 
        User user = new User("Vincent", 30); 
        create(user); 
 
        JPAUtil.shutdown(); 
    } 
 
    public static void create(User user) { 
        // 透過 ntityManagerFactory 取得 EntityManager
        // 透過 EntityManager 在取得 Entity（最重要的資料）
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager(); 
         
        // 進入交易模式 
        EntityTransaction etx = em.getTransaction(); 
        // 交易開始 
        etx.begin(); 
        // 交易內容 （可以很多筆）
        em.persist(user); 
        // 交易確認 
        etx.commit(); 
         
        System.out.println("1.新增完畢成功"); 
        em.close(); 
    } 
} 