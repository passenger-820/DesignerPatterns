package org.example.designPatterns.structural.bridge.message.implementor;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;
import org.example.designPatterns.structural.bridge.message.abstractor.Notification;

public class CriticalNotification extends Notification {
    public CriticalNotification(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void deliver(String message) {
        messageSender.send("非常紧急：" + message);
    }
}
