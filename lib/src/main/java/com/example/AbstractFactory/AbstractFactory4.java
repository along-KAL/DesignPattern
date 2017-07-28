package com.example.AbstractFactory;

/**
 * Created by along on 2017/7/28.
 */

public class AbstractFactory4 {

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


    static class SqlserverUser implements IUser {

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

    /*interface IFactory {
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
    }*/

    static class DataAccess{
        private static String db = "Sqlserver";
        public static IUser createUser(){
            IUser result = null;
            switch (db){
                case "Sqlserver":
                    result = new SqlserverUser();
                    break;
                case "Access":
                    result = new AccessUser();
                    break;
            }
            return result;
        }
        public static IDepartment createDepartment(){
            IDepartment result = null;
            switch (db){
                case "Sqlserver":
                    result = new SqlserverDepartment();
                    break;
                case "Access":
                    result = new AccessDepartment();
                    break;
            }
            return result;
        }
    }




    public static void main(String[] args) {

        User user = new User();
        Department department = new Department();

        /*IFactory factory = new SqlServerFactory();
        IUser iu = factory.createUser();
        iu.insert(user);

        IDepartment dm = factory.createDepartment();
        dm.insert(department);*/

        DataAccess dataAccess = new DataAccess();
        IUser iUser = dataAccess.createUser();
        iUser.insert(user);

        IDepartment iDepartment = dataAccess.createDepartment();
        iDepartment.insert(department);
    }



}
