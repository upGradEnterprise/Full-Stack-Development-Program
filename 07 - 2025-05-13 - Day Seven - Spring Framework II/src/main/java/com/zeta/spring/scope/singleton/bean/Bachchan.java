package com.zeta.spring.scope.singleton.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component @Scope public class Bachchan implements Actor {
    private boolean act;
    private boolean dance;
    private boolean award;

    @Override public void canAct(boolean canAct) { this.act = canAct; }
    @Override public void canDance(boolean canDance) { this.dance = canDance; }
    @Override public void hasAward(boolean hasAward) { this.award = hasAward; }

    @Override public boolean getAct() { return this.act; }
    @Override public boolean getDance() { return this.dance; }
    @Override public boolean getAward() { return this.award; }
}
