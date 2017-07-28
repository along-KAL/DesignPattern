package com.example.State;

/**
 * Created by along on 2017/7/27.
 *
 * 当一个对象内在状态改变时允许改变其行为，这个对象看起来像是改变了其类
 */

public class State1 {

    static abstract class State {
        public abstract void handle(Context context);
    }

    static class ConcreteStateA extends State {
        @Override
        public void handle(Context context) {
            context.mState = new ConcreteStateB();
        }
    }

    static class ConcreteStateB extends State {
        @Override
        public void handle(Context context) {
            context.mState = new ConcreteStateA();
        }
    }


    static class Context {
        public State mState;

        public Context(State state) {
            this.mState = state;
        }

        public void request() {
            mState.handle(this);
        }
    }

    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA());

        c.request();
        c.request();
        c.request();
        c.request();
    }
}
