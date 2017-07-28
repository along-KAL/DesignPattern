package com.example.Adapter;

/**
 * Created by along on 2017/7/27.
 *
 * 将一个类的接口转换成客户希望的另一个接口，Adapter模式使得原本由于接口不兼容二不能一起工作的哪些类可以一起工作
 */

public class Adapter1 {

    static class Target{
        public void request(){

        }
    }

    static class Adaptee{
        public void specificRequest(){

        }
    }

    static class Adapter extends Target{

        private Adaptee adaptee = new Adaptee();
        public void request(){
            adaptee.specificRequest();
        }
    }

    public static void main(String[] args){
        Target target = new Adapter();
        target.request();
    }
}
