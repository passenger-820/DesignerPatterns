package org.example.designPatterns.behavioral.status.mario.status;

public class MarioBigState implements MarioStatus {

    private Mario mario;

    public MarioBigState(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void eatMushroom() {
        System.out.println("大马里奥吃了蘑菇，没变化。");
    }

    @Override
    public void eatFireFlower() {
        System.out.println("大马里奥吃了火焰，变成火焰马里奥。");
        mario.setMarioStatus(new MarioFireState(mario));
    }

    @Override
    public void enemyAttack() {
        System.out.println("大马里奥遇到敌人，变小。");
        mario.setMarioStatus(new MarioSmallState(mario));
    }

    @Override
    public void fallFit() {
        System.out.println("小马里奥调入坑，死亡。");
        mario.setMarioStatus(new MarioDeadState(mario));
    }
}