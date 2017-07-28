package com.example.Beidge;

/**
 * Created by along on 2017/7/26.
 */

public class Bridge2 {

    //手机软件
    abstract class HandsetSoft {
        abstract public void run();
    }

    //手机游戏
    class HandsetGame extends HandsetSoft {
        @Override
        public void run() {

        }
    }

    //手机通讯录
    class HandsetAddressList extends HandsetSoft {
        @Override
        public void run() {

        }
    }


    //手机品牌
    abstract class HandsetBrand {
        protected HandsetSoft soft;

        public void setHandsetSoft(HandsetSoft soft) {
            this.soft = soft;
        }

        public abstract void run();
    }

    //手机品牌N
    class HandsetBrandN extends HandsetBrand {

        @Override
        public void run() {
            soft.run();
        }
    }

    //手机品牌M
    class HandsetBrandM extends HandsetBrand {

        @Override
        public void run() {
            soft.run();
        }
    }


}
