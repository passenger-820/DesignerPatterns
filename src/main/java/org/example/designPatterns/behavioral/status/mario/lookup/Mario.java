package org.example.designPatterns.behavioral.status.mario.lookup;

import org.example.designPatterns.behavioral.status.mario.Event;
import org.example.designPatterns.behavioral.status.mario.MarioState;

public class Mario {
    private MarioState state;

    // 使用二维数组定义状态转换表
    private static final MarioState[][] TRANSITION_TABLE = {
            // SMALL, BIG, FIRE, DEAD
            {MarioState.BIG, MarioState.BIG, MarioState.FIRE, MarioState.DEAD}, // MUSHROOM
            {MarioState.SMALL, MarioState.FIRE, MarioState.FIRE, MarioState.DEAD}, // FIRE_FLOWER
            {MarioState.DEAD, MarioState.SMALL, MarioState.SMALL, MarioState.DEAD}, // ENEMY_ATTACK
            {MarioState.DEAD, MarioState.DEAD, MarioState.DEAD, MarioState.DEAD}  // FALL_INTO_PIT
    };

    public Mario() {
        state = MarioState.SMALL;
    }

    public void handleEvent(Event event) {
        // 使用查表法获取状态转换后的新状态
        MarioState newState = TRANSITION_TABLE[event.ordinal()][state.ordinal()];

        // 打印状态转换信息
        System.out.printf("从 %s 变为 %s%n", state, newState);

        // 更新状态
        state = newState;
    }

    public static void main(String[] args) {
        Mario mario = new Mario();

        mario.handleEvent(Event.MUSHROOM); // 变为大马里奥
        mario.handleEvent(Event.FIRE_FLOWER); // 变为火焰马里奥
        mario.handleEvent(Event.FALL_INTO_PIT); // 变为死亡马里奥
    }
}
