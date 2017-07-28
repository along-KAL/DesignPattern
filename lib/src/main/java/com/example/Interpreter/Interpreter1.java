package com.example.Interpreter;


/**
 * Created by along on 2017/7/26.
 * 解释器模式
 *
 * 给定一个语言，定义他的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子
 */

public class Interpreter1 {

    /**
     * 演奏文本
     */
    static class PlayContext {
        public String text;
    }

    /**
     * 解释器
     */
    static abstract class Expression {
        public void interpret(PlayContext context) {
            if (context.text.length() == 0) {
                return;
            }
            String playKey = context.text.substring(0, 1);
            context.text = context.text.substring(2);
            double playValue = Double.valueOf(context.text.substring(0, context.text.indexOf(" ")));
            context.text = context.text.substring(context.text.indexOf(" ") + 1);

            Excute(playKey, playValue);
        }

        //执行
        public abstract void Excute(String key, double value);
    }

    /**
     * 音乐符类
     */
    static class Note extends Expression {

        @Override
        public void Excute(String key, double value) {
            String note = "";
            switch (key) {
                case "C":
                    note = "1";
                    break;
                case "D":
                    note = "2";
                    break;
                case "E":
                    note = "3";
                    break;
                case "F":
                    note = "4";
                    break;
                case "G":
                    note = "5";
                    break;
                case "A":
                    note = "6";
                    break;
                case "B":
                    note = "7";
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 音乐符类
     */
    static class Scale extends Expression {

        @Override
        public void Excute(String key, double value) {
            String scale = "";
            switch ((int) value) {
                case 1:
                    scale = "低音";
                    break;
                case 2:
                    scale = "中音";
                    break;
                case 3:
                    scale = "高音";
                    break;
                default:
                    break;
            }
        }
    }


    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        context.text = "o 2 e 1.5 g 0.5 a 3 e 0.5 d 3 e 0.5 d 3 e" +
                " 0.5 g 0.5 a 0.5 o 3 c 1 o 2 a 0.5 g 1 c o 0.5 e 0.5 d 3";
        Expression expression = null;
        while (context.text.length() > 0) {
            String str = context.text.substring(0, 1);
            switch (str) {
                case "o":
                    expression = new Scale();
                    break;
                case "c":
                case "d":
                case "e":
                case "f":
                case "g":
                case "a":
                case "b":
                case "p":
                    expression = new Note();
                    break;
                default:
                    break;
            }
            expression.interpret(context);
        }
    }
}
