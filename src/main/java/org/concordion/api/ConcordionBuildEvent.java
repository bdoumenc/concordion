package org.concordion.api;

public class ConcordionBuildEvent {
    private final Target target;

    public ConcordionBuildEvent(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return target;
    }
}