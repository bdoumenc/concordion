package spec.concordion.extension.listener;

import spec.concordion.extension.AbstractExtensionTestCase;

public class ListenerTest extends AbstractExtensionTestCase {

    public void addLoggingExtension() {
        setExtensions("test.concordion.extension.LoggingExtension");
    }
    
    public double sqrt(double num) {
        return Math.sqrt(num);
    }
    
    public boolean isPositive(int num) {
        return num > 0;
    }
}
