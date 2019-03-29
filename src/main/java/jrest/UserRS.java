
package jrest;

import dao.UserDao;

public class UserRS {
    private UserDao dao;
    
     UserRS(){
        // dao = new UserDao(); 會自動加入
    }
     
     UserRS(int i ){
        // dao = new UserDao(); 會自動加入
    }
    
    // 預設建構值 會自動加入到所有建構值中
    {
        dao = new UserDao();
    }
}
