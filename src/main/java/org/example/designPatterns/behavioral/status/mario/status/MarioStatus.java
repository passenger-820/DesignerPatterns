package org.example.designPatterns.behavioral.status.mario.status;

/**
 * 将改变状态的行为都抽象为接口
 */
public interface MarioStatus {
    //吃蘑菇
    void eatMushroom();
    //吃花
    void eatFireFlower();
    //被小兵攻击
    void enemyAttack();
    //掉坑里
    void fallFit();
}
