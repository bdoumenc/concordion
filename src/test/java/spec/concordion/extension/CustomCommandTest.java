package spec.concordion.extension;

import java.util.List;

public class CustomCommandTest extends AbstractExtensionTestCase {

    public void addCommandExtension() {
        setExtensions("test.concordion.extension.CommandExtension");
    }
    
    public List<String> getOutput() {
        return getEventLog();
    }
}
