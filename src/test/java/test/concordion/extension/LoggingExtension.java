package test.concordion.extension;

import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;
import org.concordion.api.listener.ExecuteListener;
import org.concordion.api.listener.VerifyRowsListener;

public class LoggingExtension implements ConcordionExtension {

    public void addTo(ConcordionExtender concordionExtender) {
        AssertLogger assertLogger = new AssertLogger();
        concordionExtender.withAssertEqualsListener(assertLogger);
        concordionExtender.withAssertTrueListener(assertLogger);
        concordionExtender.withAssertFalseListener(assertLogger);
        ExecuteListener executeListener = new ExecuteLogger();
        concordionExtender.withExecuteListener(executeListener);
        VerifyRowsListener verifyRowsListener = new VerifyRowsLogger();
        concordionExtender.withVerifyRowsListener(verifyRowsListener);
    }
}
