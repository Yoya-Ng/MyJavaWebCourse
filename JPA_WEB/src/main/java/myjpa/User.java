package myjpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="T_USER")
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long age;

    public User() {
    }

    public User(String name, Long age) {
        this.name = name;
        this.age = age;
    }
    
    
    public void setId(Long id) {  this.id = id;  }

    public Long getId() { return id;  }

    public String getName() {  return name;  }

    public void setName(String name) {  this.name = name;  }

    public Long getAge() {  return age;  }

    public void setAge(Long age) {  this.age = age;  }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    
    
   
}
