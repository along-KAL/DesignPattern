package com.example.Beidge;

/**
 * Created by along on 2017/7/26.
 *
 * 将抽象部分与他的实现部分分离，使她们都可以独立变化
 *
 */

public class Bridge1 {


    abstract class HandsetBrand{
        abstract public void run();
    }

    class HandsetBrandM extends HandsetBrand{
        @Override
        public void run() {

        }
    }
    class HandsetBrandN extends HandsetBrand{
        @Override
        public void run() {

        }
    }


    class HandsetBrandMGame extends HandsetBrandM{

    }
    class HandsetBrandNGame extends HandsetBrandN{

    }

}
