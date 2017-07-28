package com.example.AbstractFactory;

/**
 * Created by along on 2017/7/28.
 */

public class AbstractFactory3 {

    static class User {
        public int _id;
        public String name;
    }

    static class Department {
        public int _id;
        public String name;
    }


    interface IDepartment{
        void insert(Department department);
        Department getDepartment(int id);
    }

    static class SqlserverDepartment implements IDepartment
    {
        @Override
        public void insert(Department department) {

        }

        @Override
        public Department getDepartment(int id) {
            return null;
        }
    }

    static class AccessDepartment implements IDepartment{
        @Override
        public void insert(Department department) {

        }

        @Override
        public Department getDepartment(int id) {
            return null;
        }
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
        public User getUser(int id) {return null;}
    }

    static class AccessUser implements IUser {

        @Override
        public void insert(User user) {

        }

        @Override
        public User getUser(int id) {return null;}
    }

    interface IFactory {
        IUser createUser();

        IDepartment createDepartment();
    }

    static class SqlServerFactory implements IFactory {

        @Override
        public IUser createUser() {return new AccessUser();}

        @Override
        public IDepartment createDepartment() {
            return new SqlserverDepartment();
        }
    }

    static class AccessFactory implements IFactory {

        @Override
        public IUser createUser() {return new AccessUser();}

        @Override
        public IDepartment createDepartment() {
            return new AccessDepartment();
        }
    }

    public static void main(String[] args) {

        User user = new User();
        Department department = new Department();

        IFactory factory = new SqlServerFactory();
        IUser iu = factory.createUser();
        iu.insert(user);

        IDepartment dm = factory.createDepartment();
        dm.insert(department);
    }


}
