package myjpa;

import java.io.Serializable;
import javax.persistence.*;


//@Entity(name = "User") name可自行修改，預設會跟Class名稱一樣
@Entity
@Table(name = "T_USER")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //JPA自訂產生id
    private Long id;
    //@Column       可不加name 如果跟db 名稱一樣
    @Column(name = "name")
    private String name;
    @Column(name = "ags")
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    
    
}
