package test.concordion.extension;

import org.concordion.api.command.AssertEqualsListener;
import org.concordion.api.command.AssertFailureEvent;
import org.concordion.api.command.AssertFalseListener;
import org.concordion.api.command.AssertSuccessEvent;
import org.concordion.api.command.AssertTrueListener;

public class AssertLogger implements AssertEqualsListener, AssertTrueListener, AssertFalseListener {
    public void successReported(AssertSuccessEvent event) {
        System.out.println("Success '" + event.getElement().getText() + "'");
    }

    public void failureReported(AssertFailureEvent event) {
        System.out.println("Failure expected:'" + event.getExpected() + "' actual:'" + event.getActual() + "'");
    }
}