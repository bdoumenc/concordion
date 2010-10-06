package spec.concordion.extension.listener;

import java.util.Arrays;
import java.util.List;

import spec.concordion.extension.AbstractExtensionTestCase;

public class VerifyRowsListenerTest extends AbstractExtensionTestCase {

    public void addLoggingExtension() {
        setExtensions("test.concordion.extension.LoggingExtension");
    }
    
    public List<String> getGeorgeAndRingo() {
        return Arrays.asList(new String[] {"George Harrison", "Ringo Starr"});
    }
}
