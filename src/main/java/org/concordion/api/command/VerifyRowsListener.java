package org.concordion.api.command;

import java.util.EventListener;


public interface VerifyRowsListener extends EventListener {

    void expressionEvaluated(ExpressionEvaluatedEvent event);
    
    void missingRow(MissingRowEvent event);
    
    void surplusRow(SurplusRowEvent event);
}
