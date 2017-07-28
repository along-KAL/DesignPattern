package com.example.Chain;

/**
 * Created by along on 2017/7/26.
 * 加薪重构
 */

public class Chain2 {


    /**
     * 申请
     */
    static class Request {
        public String requestType;
        public String requestContent;
        public int number;
    }


    static abstract class Manager {
        protected String mName;
        //管理者上级
        protected Manager mSuperior;

        public Manager(String name) {
            this.mName = name;
        }

        /**
         * 设置管理者的上级
         */
        public void setSuperior(Manager superior) {
            this.mSuperior = superior;
        }

        abstract public void RequestApplications(Request request);

    }


    /**
     * 经理
     */
    static class CommonManager extends Manager {

        public CommonManager(String name) {
            super(name);
        }

        @Override
        public void RequestApplications(Request request) {
            if ("请假".equals(request.requestType) && request.number <= 2) {
                //批准
            } else {
                if (mSuperior != null) {
                    mSuperior.RequestApplications(request);
                }
            }
        }
    }

    /**
     * 总监
     */
    static class MajorManager extends Manager {

        public MajorManager(String name) {
            super(name);
        }

        @Override
        public void RequestApplications(Request request) {
            if ("请假".equals(request.requestType) && request.number <= 5) {
                //批准
            } else {
                if (mSuperior != null) {
                    mSuperior.RequestApplications(request);
                }
            }
        }
    }

    /**
     * 总经理
     */
    static class GeneralManager extends Manager {

        public GeneralManager(String name) {
            super(name);
        }

        @Override
        public void RequestApplications(Request request) {

            if ("请假".equals(request.requestType)) {
                //批准
            } else if ("加薪".equals(request.requestType) && request.number <= 500) {
                //批准
            } else if ("加薪".equals(request.requestType) && request.number > 500) {
                //再说吧
                /*if (mSuperior != null) {
                    mSuperior.RequestApplications(request);
                }*/
            }
        }
    }

    public static void main(String[] args) {
        CommonManager commonManager = new CommonManager("经理");
        MajorManager majorManager = new MajorManager("总监");
        GeneralManager generalManager = new GeneralManager("总经理");

        commonManager.setSuperior(majorManager);
        majorManager.setSuperior(generalManager);

        //请假
        Request request1 = new Request();
        request1.requestType = "请假";
        request1.number = 2;
        commonManager.RequestApplications(request1);

        //加薪
        Request request2 = new Request();
        request2.requestType = "加薪";
        request2.number = 1000;
        commonManager.RequestApplications(request2);

    }


}
