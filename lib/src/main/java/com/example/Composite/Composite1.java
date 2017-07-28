package com.example.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by along on 2017/7/27.
 * <p>
 * 组合模式
 * <p>
 * 将对象自合成树形结构以表示 '部分'-'整体' 层次结构，组合模式使得用户对单个对象和组合对象的使用具有一致性
 */

public class Composite1 {

    static abstract class Component {
        protected String mName;

        public Component(String name) {
            this.mName = name;
        }

        public abstract void add(Component c);

        public abstract void remove(Component c);

        public abstract void display(int depth);
    }

    static class Leaf extends Component {

        public Leaf(String name) {
            super(name);
        }

        @Override
        public void add(Component c) {

        }

        @Override
        public void remove(Component c) {

        }

        @Override
        public void display(int depth) {

        }
    }

    static class Composite extends Component {

        private List<Component> children = new ArrayList<>();

        public Composite(String name) {
            super(name);
        }

        @Override
        public void add(Component c) {
            children.add(c);

        }

        @Override
        public void remove(Component c) {
            children.remove(c);
        }

        @Override
        public void display(int depth) {

        }
    }


    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("leafA"));
        root.add(new Leaf("leafB"));


        Composite comp = new Composite("composite A");
        comp.add(new Leaf("leafC"));
        comp.add(new Leaf("leafD"));

        root.add(comp);

    }
}
