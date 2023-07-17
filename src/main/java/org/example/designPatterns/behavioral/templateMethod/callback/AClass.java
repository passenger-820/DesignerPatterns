package org.example.designPatterns.behavioral.templateMethod.callback;

public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        //使用Lambda表达式写
        ICallback callback = ()-> System.out.println("Callback function called in A class.");
        //这是原始写法
        //new ICallback() { //回调对象
        //    @Override
        //    public void methodToCallback() {
        //        System.out.println("Call back me.");
        //    }
        //}
        b.registerCallback(callback);
        b.process();
    }
}
