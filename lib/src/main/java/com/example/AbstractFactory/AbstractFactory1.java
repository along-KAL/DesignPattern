package com.example.AbstractFactory;

/**
 * Created by along on 2017/7/28.
 */

public class AbstractFactory1 {

    static class User{
        public int _id;
        public String name;
    }

    //Sqlserver
    static class SqlserverUser{
        public void insert(User user){}
        public void getUser(int id){}
    }

    public static void main(String[] args){
        User user = new User();
        SqlserverUser sqlserverUser = new SqlserverUser();
        sqlserverUser.insert(user);
        sqlserverUser.getUser(3);
    }

}
