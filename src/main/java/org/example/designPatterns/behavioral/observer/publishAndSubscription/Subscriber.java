package org.example.designPatterns.behavioral.observer.publishAndSubscription;

import java.util.Map;

/**
 * Observer
 */
public interface Subscriber {
    //所订阅的事件发生时，订阅者的行为
    void onEvent(Map<String,Object> eventContext);
}
