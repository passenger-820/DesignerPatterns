package org.example.designPatterns.behavioral.observer.publishAndSubscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建消息总线，维护事件（可以是对象、字符串等等）与订阅者的关系
 */
public class EventBus {
    //使用一个map维护，消息类型和该消息的订阅者
    private Map<String, List<Subscriber>> subscribers = new HashMap<>(8); //事件类型，订阅类该类型事件的订阅者

    //注册订阅者，订阅事件
    public void registerSubscriber(String eventType, Subscriber subscriber){
        // 通过事件来确定有没有订阅者[computeIfAbsent()]
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>());
        // 获取订阅者集合
        List<Subscriber> subs = subscribers.get(eventType);
        // 注册
        subs.add(subscriber);
    }

    // 为某个订阅者解除订阅
    public void removeSubscriber(String eventType, Subscriber subscriber) {
        //要移除的是订阅者
        List<Subscriber> subs = subscribers.get(eventType);
        if (subs != null){
            //subs指向的就是subscribers某个事件类型的List
            //因此可以使用它来移除某个subscriber
            subs.remove(subscriber);
        }
    }

    //发布事件，要发布给订阅该类型事件的订阅者
    public void publishEvent(String eventType, Map<String,Object> eventContext) {
        //拿到所有订阅该类型事件的订阅者
        List<Subscriber> subs = subscribers.get(eventType);
        //遍历他们，调用他们的onEvent方法
        for (Subscriber sub : subs) {
            sub.onEvent(eventContext);
        }
    }
}
