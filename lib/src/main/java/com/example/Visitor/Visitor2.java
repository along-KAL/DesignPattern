package com.example.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by along on 2017/7/26.
 */

public class Visitor2 {

    static abstract class Action {
        public abstract void getManConclusion(Man concreteElementA);

        public abstract void getWomanConclusion(Woman concreteElementB);
    }

    static abstract class Person {
        public abstract void accept(Action visitor);
    }

    /**
     * 男人
     */
    static class Man extends Person {
        @Override
        public void accept(Action visitor) {
            visitor.getManConclusion(this);
        }
    }


    /**
     * 女人
     */
    static class Woman extends Person {
        @Override
        public void accept(Action visitor) {
            visitor.getWomanConclusion(this);
        }
    }

    /**
     * 成功
     */
    static class Success extends Action {
        @Override
        public void getManConclusion(Man concreteElementA) {

        }

        @Override
        public void getWomanConclusion(Woman concreteElementB) {

        }
    }

    /**
     * 失败
     */
    static class Failed extends Action {
        @Override
        public void getManConclusion(Man concreteElementA) {

        }

        @Override
        public void getWomanConclusion(Woman concreteElementB) {

        }
    }


    static class ObjectStructure {
        private List<Person> elements = new ArrayList<>();

        public void Attach(Person element) {
            elements.add(element);
        }

        public void detach(Person element) {
            elements.remove(element);
        }

        public void display(Action action) {
            for (Person element : elements) {
                element.accept(action);
            }
        }

    }

    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.Attach(new Man());
        o.Attach(new Woman());

        Success success = new Success();
        o.display(success);
        Failed failed = new Failed();
        o.display(failed);


    }
}
