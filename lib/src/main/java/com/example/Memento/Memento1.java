package com.example.Memento;

/**
 * Created by along on 2017/7/27.
 *
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在改对象之外保存这个状态，这样以后就可以将改对象恢复到原先保存的状态
 */

public class Memento1 {

    static class Originator {
        public String mState;

        public Memento createMemento() {
            return (new Memento(mState));
        }

        public void setMemento(Memento memento) {
            mState = memento.mState;
        }
    }

    /**
     * 状态保存类
     */
    static class Memento {
        public String mState;

        public Memento(String state) {
            this.mState = state;
        }
    }

    /**
     * 备忘录管理类
     */
    static class Caretaker {
        public Memento mMemento;

    }


    public static void main(String[] args) {
        Originator o = new Originator();
        o.mState = "On";


        Caretaker c = new Caretaker();
        c.mMemento = o.createMemento();

        o.mState = "Off";

        o.setMemento(c.mMemento);
    }
}
