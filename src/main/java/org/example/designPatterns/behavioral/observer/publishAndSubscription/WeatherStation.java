package org.example.designPatterns.behavioral.observer.publishAndSubscription;

import java.util.HashMap;
import java.util.Map;

/**
 * Subject的原始发送者，发往EventBus而不是订阅者
 */
public class WeatherStation {
    // 事件总线
    private EventBus eventBus;

    public WeatherStation(EventBus eventBus){
        this.eventBus = eventBus;
    }

    //温度有变化，改变温度，同时发往EventBus
    public void changeTemperature(float newTemperature){
        // 温度
        Map<String,Object> eventContext = new HashMap<>(2);
        eventContext.put("changeTemperature", newTemperature);
        eventBus.publishEvent("changeTemperature",eventContext);
    }

    //气压有变化，改变气压，同时发往EventBus
    public void changePressure(float newPressure){
        // 大气压
        Map<String,Object> eventContext = new HashMap<>(2);
        eventContext.put("changePressure", newPressure);
        eventBus.publishEvent("changePressure",eventContext);
    }

}
