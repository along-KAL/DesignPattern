package com.example.Command;

/**
 * Created by along on 2017/7/26.
 * <p>
 * <p>
 * 紧耦合设计
 *
 * 将一个请求封装为一个对象，从而使你可用不同的请求队客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作
 */

public class Command1 {


    /**
     * 烤肉类
     */
    static class Barbecuer {
        public void bakeMuttom() {
        }

        public void bakeChichenWing() {
        }
    }

    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        boy.bakeChichenWing();
        boy.bakeChichenWing();
        boy.bakeChichenWing();
        boy.bakeMuttom();
        boy.bakeMuttom();
        boy.bakeMuttom();
        boy.bakeMuttom();
    }


}
