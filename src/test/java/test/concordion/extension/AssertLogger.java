package test.concordion.extension;

import org.concordion.api.listener.AssertEqualsListener;
import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertFalseListener;
import org.concordion.api.listener.AssertSuccessEvent;
import org.concordion.api.listener.AssertTrueListener;

public class AssertLogger implements AssertEqualsListener, AssertTrueListener, AssertFalseListener {
    public void successReported(AssertSuccessEvent event) {
        System.out.println("Success '" + event.getElement().getText() + "'");
    }

    public void failureReported(AssertFailureEvent event) {
        System.out.println("Failure expected:'" + event.getExpected() + "' actual:'" + event.getActual() + "'");
    }
}