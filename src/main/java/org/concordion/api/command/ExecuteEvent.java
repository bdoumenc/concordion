package org.concordion.api.command;

import org.concordion.api.Element;

public class ExecuteEvent {
    private final Element element;

    public ExecuteEvent(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }
}
