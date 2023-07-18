package org.example.designPatterns.structural.bridge.message.implementor;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;

/**
 * 邮件通知实现类
 */
public class EmailMessageSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("发送邮件通知: " + message);
    }
}
