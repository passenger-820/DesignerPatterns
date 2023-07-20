package org.example.designPatterns.behavioral.status.mario.status;

public class MarioDeadState implements MarioStatus {
    private Mario mario;

    public MarioDeadState(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void eatMushroom() {
        System.out.println("马里奥已经死亡");
    }

    @Override
    public void eatFireFlower() {
        System.out.println("马里奥已经死亡");
    }

    @Override
    public void enemyAttack() {
        System.out.println("马里奥已经死亡");
    }

    @Override
    public void fallFit() {
        System.out.println("马里奥已经死亡");
    }
}
