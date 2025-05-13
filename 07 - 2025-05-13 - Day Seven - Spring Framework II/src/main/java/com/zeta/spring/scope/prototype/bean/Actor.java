package com.zeta.spring.scope.prototype.bean;

public interface Actor {
    void canAct(boolean canAct);
    void canDance(boolean canDance);
    void hasAward(boolean hasAward);

    boolean getAct();
    boolean getDance();
    boolean getAward();
}