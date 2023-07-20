package org.example.designPatterns.behavioral.status.tv;

public class NewTV {
    private TVState state;

    public NewTV(){
        //初始为关机状态
        this.state = new TVOffState();
    }
    //允许调整状态
    public void setState(TVState state){
        this.state = state;
    }

    //开机
    public void turnOn() {
        //无论开机还是关机状态，都是调用开机
        state.turnOn();
        //将当前状态设置为开机状态
        setState(new TVOnState());
    }

    //关机
    public void turnOff() {
        //无论开机还是关机状态，都是调用关机
        state.turnOff();
        //将当前状态设置为关机状态
        setState(new TVOffState());
    }

    public void adjustVolume(int volume) {
        state.adjustVolume(volume);
    }

}
