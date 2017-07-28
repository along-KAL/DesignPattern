package com.example.Command;

/**
 * Created by along on 2017/7/26.
 */

public class Command2 {

    /**
     * 烤肉类
     */
    static class Barbecuer {
        public void bakeMuttom() {
        }

        public void bakeChichenWing() {
        }
    }

    /**
     * 命令抽象类
     */
    static abstract class Command {
        protected Barbecuer mReceiver;

        public Command(Barbecuer receiver) {
            this.mReceiver = receiver;
        }

        abstract public void excuteCommand();
    }

    /**
     * 烤肉命令
     */
    static class BakeMuttonCommand extends Command {

        public BakeMuttonCommand(Barbecuer receiver) {
            super(receiver);
        }

        @Override
        public void excuteCommand() {
            mReceiver.bakeMuttom();
        }
    }

    /**
     * 烤鸡腿命令
     */
    static class BakeChickenWingCommand extends Command {

        public BakeChickenWingCommand(Barbecuer receiver) {
            super(receiver);
        }

        @Override
        public void excuteCommand() {
            mReceiver.bakeChichenWing();
        }
    }

    /**
     * 服务员类
     */
    static class Waiter {
        private Command mCommand;

        public void setOrder(Command command) {
            this.mCommand = command;
        }

        public void waiterNotify() {
            mCommand.excuteCommand();
        }
    }


    public static void main(String[] args) {
        //点餐
        Barbecuer boy = new Barbecuer();
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);
        Waiter girl = new Waiter();

        //服务员通知后台人员做菜
        girl.setOrder(bakeMuttonCommand1);
        girl.waiterNotify();
        girl.setOrder(bakeMuttonCommand2);
        girl.waiterNotify();
        girl.setOrder(bakeChickenWingCommand1);
        girl.waiterNotify();
    }
}
