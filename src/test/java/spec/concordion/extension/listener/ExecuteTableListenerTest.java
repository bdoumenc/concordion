package spec.concordion.extension.listener;

import spec.concordion.extension.AbstractExtensionTestCase;

public class ExecuteTableListenerTest extends AbstractExtensionTestCase {

    public void addLoggingExtension() {
        setExtensions("test.concordion.extension.LoggingExtension");
    }
    
    public double sqrt(double num) {
        return Math.sqrt(num);
    }
    
    public String generateUsername(String fullName) {
        return fullName.replaceAll(" ", "").toLowerCase();
    }
}
