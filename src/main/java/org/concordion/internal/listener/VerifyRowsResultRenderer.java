package org.concordion.internal.listener;

import org.concordion.api.Element;
import org.concordion.api.command.ExpressionEvaluatedEvent;
import org.concordion.api.command.MissingRowEvent;
import org.concordion.api.command.SurplusRowEvent;
import org.concordion.api.command.VerifyRowsListener;

public class VerifyRowsResultRenderer implements VerifyRowsListener {

    public void expressionEvaluated(ExpressionEvaluatedEvent event) {
    }
    
    public void missingRow(MissingRowEvent event) {
        Element element = event.getRowElement();
        element.addStyleClass("missing");
    }

    public void surplusRow(SurplusRowEvent event) {
        Element element = event.getRowElement();
        element.addStyleClass("surplus");
    }
}
