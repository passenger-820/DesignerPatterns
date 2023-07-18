package org.example.designPatterns.structural.bridge.message.implementor;

import org.example.designPatterns.structural.bridge.message.abstractor.MessageSender;

/**
 * 即时消息通知实现类
 */
public class InstantMessageSender  implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("发送即时消息通知: " + message);
    }
}