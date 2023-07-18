package org.example.designPatterns.structural.bridge.message.implementor;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;
import org.example.designPatterns.structural.bridge.message.abstractor.Notification;

/**
 * 紧急通知子类（扩展抽象化角色）
 */
public class UrgentNotification extends Notification {
    public UrgentNotification(MessageSender messageSender) {
        super(messageSender);
    }
    @Override
    public void deliver(String message) {
        messageSender.send("紧急：" + message);
    }
}
