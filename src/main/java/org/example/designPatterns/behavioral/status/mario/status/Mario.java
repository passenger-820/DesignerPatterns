package org.example.designPatterns.behavioral.status.mario.status;

import lombok.Data;
import org.example.designPatterns.behavioral.status.mario.Event;

@Data
public class Mario {
    private MarioStatus marioStatus;

    public Mario() {
        this.marioStatus = new MarioSmallState(this);
    }

    //根据事件变换状态，我们已经在所有状态下都实现了针对不同事件的反应
    public void handEvent(Event event){
        if(event == Event.MUSHROOM){
            marioStatus.eatMushroom();
        } else if(event == Event.FIRE_FLOWER){
            marioStatus.eatFireFlower();
        } else if(event == Event.ENEMY_ATTACK){
            marioStatus.enemyAttack();
        } else if (event == Event.FALL_INTO_PIT){
            marioStatus.fallFit();
        }
    }

    public static void main(String[] args) {
        Mario mario = new Mario();

        mario.handEvent(Event.MUSHROOM);
        mario.handEvent(Event.FIRE_FLOWER);
        mario.handEvent(Event.ENEMY_ATTACK);
        mario.handEvent(Event.FALL_INTO_PIT);
    }
}
