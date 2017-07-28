





package com.example.AbstractFactory;

/**
 * Created by along on 2017/7/28.
 */

public class AbstractFactory2 {

    static class User {
        public int _id;
        public String name;
    }


    interface IUser {
        void insert(User user);

        User getUser(int id);
    }


    class SqlserverUser implements IUser {

        @Override
        public void insert(User user) {

        }

        @Override
        public User getUser(int id) {
            return null;
        }
    }

    static class AccessUser implements IUser {

        @Override
        public void insert(User user) {

        }

        @Override
        public User getUser(int id) {
            return null;
        }
    }

    interface IFactory {
        IUser createUser();
    }

    static class SqlServerFactory implements IFactory {

        @Override
        public IUser createUser() {
            return new AccessUser();
        }
    }

    public static void main(String[] args) {

        User user = new User();
        IFactory factory = new SqlServerFactory();
        IUser iu = factory.createUser();
        iu.insert(user);
        iu.getUser(3);
    }


}
