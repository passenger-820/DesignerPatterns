package org.example.designPatterns.behavioral.templateMethod.callback;

public class BClass {
    private ICallback callback;

    // 注册回调函数
    public void registerCallback(ICallback callback) {
        this.callback = callback;
    }

    // 执行操作，并在完成后调用了回调函数
    public void process(){
        System.out.println("Performing operation in B class.");
        // 模拟操作的延迟
        System.out.println("......");
        System.out.println("Operation completed in B class.");
        // 调用回调函数通知完成
        if (callback != null) {
            callback.methodToCallback();
        }
        //其他内容
    }
}
