package org.example.designPatterns.structural.bridge.message.abstractor;

/**
 * 通知方式接口（实现化角色），邮件、短信、即时消息
 */
public interface MessageSender {
    void send(String message);
}
