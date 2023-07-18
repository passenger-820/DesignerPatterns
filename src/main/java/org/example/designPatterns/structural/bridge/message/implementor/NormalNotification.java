package org.example.designPatterns.structural.bridge.message.implementor;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;
import org.example.designPatterns.structural.bridge.message.abstractor.Notification;

/**
 * 普通通知子类（扩展抽象化角色）
 */
public class NormalNotification extends Notification {
    public NormalNotification(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void deliver(String message) {
        messageSender.send("普通：" + message);
    }


}
