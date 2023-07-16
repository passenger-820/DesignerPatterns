package org.example.designPatterns.behavioral.observer.publishAndSubscription;

import java.util.Map;

public class Web implements Subscriber{
    @Override
    public void onEvent(Map<String, Object> eventContext) {
        if (eventContext.containsKey("changeTemperature")){
            System.out.println("web -> 当前的温度是：" + eventContext.get("changeTemperature"));
        } else if (eventContext.containsKey("changePressure")) {
            System.out.println("web -> 当前的气压是：" + eventContext.get("changePressure"));
        }
    }
}
