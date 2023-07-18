package org.example.designPatterns.structural.bridge.message.abstractor;

/**
 * 抽象通知类（抽象化角色），桥接具体的发送者，具体的实现让别人去做
 */
public abstract class Notification {
    protected MessageSender messageSender;
    //直接通过构造器设置messageSender
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void deliver(String message);
}
