package com.example.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by along on 2017/7/26.
 *
 * 提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露改对象的内部表示
 */

public class Iterator1 {

    static abstract class Iterator {
        public abstract Object first();

        public abstract Object next();

        public abstract boolean isDone();

        public abstract Object currentItem();
    }

    static abstract class Aggregate {
        public abstract Iterator createIterator();
    }

    static class ConcreteIterator extends Iterator {

        private ConcreteAggrete mConcreteAggrete;
        private int current = 0;

        public ConcreteIterator(ConcreteAggrete concreteAggrete) {
            this.mConcreteAggrete = concreteAggrete;
        }

        @Override
        public Object first() {
            return mConcreteAggrete.items.get(0);
        }

        @Override
        public Object next() {
            Object ret = null;
            current++;
            if (current < mConcreteAggrete.count) {
                ret = mConcreteAggrete.items.get(current);
            }
            return ret;
        }

        @Override
        public boolean isDone() {
            return current >= mConcreteAggrete.count ? true : false;
        }

        @Override
        public Object currentItem() {
            return mConcreteAggrete.items.get(current);
        }
    }

    static class ConcreteAggrete extends Aggregate {

        private List<Object> items = new ArrayList();

        @Override
        public Iterator createIterator() {
            return new ConcreteIterator(this);
        }

        public int count;
    }


    public static void main(String[] args) {
        ConcreteAggrete a = new ConcreteAggrete();
        a.items.add("ggg");
        a.items.add("333");
        a.items.add("222");
        a.items.add("111");
        Iterator i = a.createIterator();

        Object item = i.first();

        while (!i.isDone()) {
            System.out.println(i.currentItem());
            i.next();
        }
    }
}
