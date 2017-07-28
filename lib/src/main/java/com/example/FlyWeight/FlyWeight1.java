package com.example.FlyWeight;

import java.util.Hashtable;

/**
 * Created by along on 2017/7/26.
 * 享元模式  对象的共享 节省空间  例如String 设计思想就是享元模式
 *
 * 运用共享技术有效的支持大量细粒度的对象
 */

public class FlyWeight1 {

    static class User {
        public String name;
    }

    static abstract class WebSite {
        public abstract void use(User user);
    }

    static class ConcreteWebSite extends WebSite {
        @Override
        public void use(User user) {

        }
    }

    //使用同一控制共享对象
    static class WebSiteFactory {
        private Hashtable flyweights = new Hashtable();

        public WebSite getWebSiteCategory(String key) {
            if (flyweights.containsKey(key)) {
                flyweights.put(key, new ConcreteWebSite());
            }
            return (WebSite) flyweights.get(key);
        }
    }


    public static void main(String[] args) {
        WebSiteFactory f = new WebSiteFactory();

        WebSite fx1 = f.getWebSiteCategory("产品展示");
        fx1.use(new User());
        WebSite fx2 = f.getWebSiteCategory("产品展示");
        fx2.use(new User());
        WebSite fx3 = f.getWebSiteCategory("博客");
        fx3.use(new User());
        WebSite fx4 = f.getWebSiteCategory("博客");
        fx4.use(new User());
    }

}
