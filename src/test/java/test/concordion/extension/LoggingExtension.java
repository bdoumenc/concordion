package test.concordion.extension;

import org.concordion.api.command.ExecuteListener;
import org.concordion.api.command.VerifyRowsListener;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

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
