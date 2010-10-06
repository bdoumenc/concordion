package test.concordion.extension;

import org.concordion.api.command.ExpressionEvaluatedEvent;
import org.concordion.api.command.MissingRowEvent;
import org.concordion.api.command.SurplusRowEvent;
import org.concordion.api.command.VerifyRowsListener;
import org.concordion.internal.ConcordionBuilder;

public class VerifyRowsLogger implements VerifyRowsListener {
    
    public void expressionEvaluated(ExpressionEvaluatedEvent e) {
        System.out.println("Evaluated '" + e.getElement().getAttributeValue("verifyRows", ConcordionBuilder.NAMESPACE_CONCORDION_2007) + "'");
    }
    
    public void missingRow(MissingRowEvent e) {
        System.out.println("Missing Row '" + e.getRowElement().getText() + "'");
    }

    public void surplusRow(SurplusRowEvent e) {
        System.out.println("Surplus Row '" + e.getRowElement().getText() + "'");
    }
}