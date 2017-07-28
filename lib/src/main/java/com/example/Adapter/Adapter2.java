package com.example.Adapter;

/**
 * Created by along on 2017/7/27.
 */

public class Adapter2 {
    static abstract class Player {
        protected String mName;

        public Player(String name) {
            this.mName = name;
        }

        public abstract void attack();

        public abstract void defense();
    }


    static class Forwards extends Player {
        public Forwards(String name) {
            super(name);
        }

        @Override
        public void attack() {

        }

        @Override
        public void defense() {

        }
    }

    /**
     * 外籍人员只听得懂中文
     */
    static class ForeignCenter {
        public String mName;

        public void 进攻() {

        }

        public void 防守() {

        }
    }

    /**
     * 翻译人员
     */
    static class Translator extends Player {

        private ForeignCenter foreignCenter = new ForeignCenter();

        public Translator(String name) {
            super(name);
        }

        @Override
        public void attack() {
            foreignCenter.进攻();
        }

        @Override
        public void defense() {
            foreignCenter.防守();
        }
    }

    public static void main(String[] args) {
        Player translator = new Translator("");
        translator.attack();
        translator.defense();
    }
}
