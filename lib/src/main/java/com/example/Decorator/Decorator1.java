package com.example.Decorator;

/**
 * Created by along on 2017/7/28.
 *
 * 动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活
 *
 *
 */

public class Decorator1 {
    static abstract class Component {
        public abstract void operation();
    }

    static class ConcreteComponent extends Component {

        @Override
        public void operation() {

        }
    }

    static class Decorator extends Component {
        protected Component mComponent;

        public void setComponent(Component component) {
            this.mComponent = component;
        }

        @Override
        public void operation() {
            if (mComponent != null) {
                mComponent.operation();
            }
        }
    }

    static class ConcreteDecoratorA extends Decorator {
        @Override
        public void operation() {
            super.operation();
            //do stuff
        }
    }

    static class ConcreteDecoratorB extends Decorator {
        @Override
        public void operation() {
            super.operation();
            //do stuff
        }
    }


    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();


        concreteDecoratorA.setComponent(c);
        concreteDecoratorB.setComponent(concreteDecoratorA);
        concreteDecoratorB.operation();
    }

}
