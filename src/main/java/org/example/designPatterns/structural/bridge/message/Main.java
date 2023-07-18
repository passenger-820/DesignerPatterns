package org.example.designPatterns.structural.bridge.message;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;
import org.example.designPatterns.structural.bridge.message.abstractor.Notification;
import org.example.designPatterns.structural.bridge.message.implementor.InstantMessageSender;
import org.example.designPatterns.structural.bridge.message.implementor.UrgentNotification;

public class Main {
    public static void main(String[] args) {
        MessageSender messageSender = new InstantMessageSender();
        Notification notification = new UrgentNotification(messageSender);
        notification.deliver("要下雨了");
        /*
        Notification里面有Sender，可以选择发送方式
        Notification的deliver可以发送Message，具体子类实现时可以增加紧急程度
         */
    }
}
