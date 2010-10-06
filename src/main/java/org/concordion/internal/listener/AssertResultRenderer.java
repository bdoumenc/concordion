package org.concordion.internal.listener;

import org.concordion.api.Element;
import org.concordion.api.command.AssertEqualsListener;
import org.concordion.api.command.AssertFailureEvent;
import org.concordion.api.command.AssertFalseListener;
import org.concordion.api.command.AssertSuccessEvent;
import org.concordion.api.command.AssertTrueListener;

public class AssertResultRenderer implements AssertEqualsListener, AssertTrueListener, AssertFalseListener {

    public void failureReported(AssertFailureEvent event) {
        Element element = event.getElement();
        element.addStyleClass("failure");
        
        Element spanExpected = new Element("del");
        spanExpected.addStyleClass("expected");
        element.moveChildrenTo(spanExpected);
        element.appendChild(spanExpected);
        spanExpected.appendNonBreakingSpaceIfBlank();
        
        Element spanActual = new Element("ins");
        spanActual.addStyleClass("actual");
        spanActual.appendText(convertToString(event.getActual()));
        spanActual.appendNonBreakingSpaceIfBlank();
        
        element.appendText("\n");
        element.appendChild(spanActual);        
    }

    public void successReported(AssertSuccessEvent event) {
        event.getElement()
            .addStyleClass("success")
            .appendNonBreakingSpaceIfBlank();
    }
    
    private String convertToString(Object object) {
        if (object == null) {
            return "(null)";
        }
        return "" + object;
    }
}
