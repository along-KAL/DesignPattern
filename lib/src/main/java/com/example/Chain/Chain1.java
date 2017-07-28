package com.example.Chain;

/**
 * Created by along on 2017/7/26.
 * <p>
 * 加薪代码
 *
 * 使多个对象对有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系
 * ，将这个对象连成一条链，并沿着这条链传递该请求，知道有一个对象处理他为止
 */

public class Chain1 {

    /**
     * 申请
     */
    static class Request {
        public String requestType;
        public String requestContent;
        public int number;
    }

    /**
     * 管理者类
     */
    static class Manager {
        protected String mName;

        public Manager(String name) {
            this.mName = name;
        }

        /**
         * 得到结果
         *
         * @param managerLevel
         * @param request
         */
        public void GetResult(String managerLevel, Request request) {
            if ("经理".equals(managerLevel)) {
                if ("请假".equals(request.requestType) && (request.number <= 2)) {
                    //批准
                } else {
                    //无权处理
                }
            } else if ("总监".equals(managerLevel)) {
                if ("请假".equals(request.requestType) && (request.number <= 5)) {
                    //批准
                } else {
                    //无权处理
                }
            } else if ("总经理".equals(managerLevel)) {
                if ("请假".equals(request.requestType)) {
                    //批准
                } else if ("加薪".equals(request.requestType) && request.number <= 500) {
                    //批准
                } else if ("加薪".equals(request.requestType) && request.number > 500) {
                    //再说吧
                }
            }
        }
    }

    public static void main(String[] args){
        Manager jinli = new Manager("经理");
        Manager zongjian = new Manager("总监");
        Manager zongjingli = new Manager("总经理");

        Request request = new Request();
        request.requestType = "加薪";
        request.number = 1000;

        jinli.GetResult("经理", request);
        zongjian.GetResult("总监", request);
        zongjingli.GetResult("总经理", request);
    }
}
