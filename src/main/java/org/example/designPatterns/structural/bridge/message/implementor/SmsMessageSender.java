package org.example.designPatterns.structural.bridge.message.implementor;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;

/**
 * 短信通知实现类
 */
public class SmsMessageSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("发送短信通知: " + message);
    }
}
