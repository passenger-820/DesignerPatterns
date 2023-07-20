package org.example.designPatterns.behavioral.status.mario.status;

public class MarioSmallState implements MarioStatus {
    private Mario mario;

    public MarioSmallState(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void eatMushroom() {
        System.out.println("小马里奥吃了蘑菇变大了。");
        // 修改状态
        mario.setMarioStatus(new MarioBigState(mario));
    }

    @Override
    public void eatFireFlower() {
        System.out.println("小马里奥吃了火焰，没变化。");
    }

    @Override
    public void enemyAttack() {
        System.out.println("小马里奥遇到敌人，死亡。");
        mario.setMarioStatus(new MarioDeadState(mario));
    }

    @Override
    public void fallFit() {
        System.out.println("小马里奥掉坑里了，死亡。");
        mario.setMarioStatus(new MarioDeadState(mario));
    }
}
