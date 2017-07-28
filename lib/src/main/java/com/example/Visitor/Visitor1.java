package com.example.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by along on 2017/7/26.
 * 访问者模式基本代码
 *
 * 表示一个作用于某对象结构中的各元素的操作，他是你可以在不改变各元素的类的前提下定义作用于这些元素的新操作
 */

public class Visitor1 {
    static abstract class Visitor {
        public abstract void visitConcreteElementA(ConcreteElementA conCreteElementA);

        public abstract void visitConcreteElementB(ConcreteElementB conCreteElementB);
    }


    static class ConcreteVisitor1 extends Visitor {
        @Override
        public void visitConcreteElementA(ConcreteElementA conCreteElementA) {

        }

        @Override
        public void visitConcreteElementB(ConcreteElementB conCreteElementB) {

        }
    }

    static class ConcreteVisitor2 extends Visitor {
        @Override
        public void visitConcreteElementA(ConcreteElementA conCreteElementA) {

        }

        @Override
        public void visitConcreteElementB(ConcreteElementB conCreteElementB) {

        }
    }

    static abstract class Element {
        public abstract void accept(Visitor visitor);
    }

    static class ConcreteElementA extends Element {

        @Override
        public void accept(Visitor visitor) {
            visitor.visitConcreteElementA(this);
        }
    }

    static class ConcreteElementB extends Element {

        @Override
        public void accept(Visitor visitor) {
            visitor.visitConcreteElementB(this);
        }
    }

    static class ObjectStructure {
        private List<Element> elements = new ArrayList<>();

        public void attach(Element element) {
            elements.add(element);
        }

        public void Detach(Element element) {
            elements.remove(element);
        }

        public void accept(Visitor visitor) {
            for (Element element : elements) {
                element.accept(visitor);
            }
        }
    }

    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());
        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();
        o.accept(v1);
        o.accept(v2);
    }

}
