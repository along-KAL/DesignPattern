package com.example.Mediator;

/**
 * Created by along on 2017/7/26.
 * <p>
 * 联合国安理会
 *
 *
 * 用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显示的相互引用，从而使其耦合松散，而且可以独立的改变他们之间的交互
 */

public class Mediator1 {

    static abstract class UnitedNations {
        public abstract void declare(String message, Country cilleague);
    }

    /**
     * 联合国
     */
    static class UniteNationsSecurityCouncil extends UnitedNations{

        public USA mUsa;
        public Iraq mIraq;

        @Override
        public void declare(String message, Country cilleague) {
            if(cilleague == mUsa){
                mIraq.getMessage("");
            }else{
                mUsa.getMessage("");
            }
        }
    }


    static abstract class Country {
        protected UnitedNations mMediator;

        public Country(UnitedNations mediator) {
            this.mMediator = mediator;
        }
    }


    /**
     * 美国
     */
    static class USA extends Country {

        public USA(UnitedNations mediator) {
            super(mediator);
        }

        public void declare(String message) {
            mMediator.declare(message, this);
        }
        public void getMessage(String message){
            //获得消息
        }
    }

    /**
     * 伊拉克
     */
    static class Iraq extends Country{
        public Iraq(UnitedNations mediator) {
            super(mediator);
        }
        public void declare(String message) {
            mMediator.declare(message, this);
        }
        public void getMessage(String message){
            //获得消息
        }
    }


    public static void main(String[] args){
        UniteNationsSecurityCouncil uniteNationsSecurityCouncil = new UniteNationsSecurityCouncil();

        USA usa = new USA(uniteNationsSecurityCouncil);
        Iraq iraq = new Iraq(uniteNationsSecurityCouncil);

        uniteNationsSecurityCouncil.mUsa = usa;
        uniteNationsSecurityCouncil.mIraq = iraq;

        usa.declare("别搞核武器");
        iraq.declare("老子就要弄");

    }


}
