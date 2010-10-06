package spec.concordion.extension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.concordion.api.Resource;
import org.concordion.integration.junit3.ConcordionTestCase;

import test.concordion.ProcessingResult;
import test.concordion.TestRig;

public abstract class AbstractExtensionTestCase extends ConcordionTestCase {

    private List<String> eventList;
    private TestRig testRig;
    private ProcessingResult processingResult;

    public AbstractExtensionTestCase() {
        super();
    }

    public void processAnything() throws Exception { 
        process("<p>anything..</p>");
    }
    
    public void process(String fragment) throws Exception {
        
        PrintStream savedStream = System.out;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
            PrintStream logStream = new PrintStream(baos);
            System.setOut(logStream);
            
            testRig = new TestRig();
            configureTestRig(testRig);
            processingResult = testRig.withFixture(this)
              .processFragment(fragment);
            
            System.out.flush();
            String[] events = baos.toString().split("\\r?\\n");
            eventList = new ArrayList<String>(Arrays.asList(events));
            eventList.remove("");
        } finally {
            System.setOut(savedStream);
        }
    }

    protected void configureTestRig(TestRig testRig) {
    }

    public List<String> getEventLog() {
        return eventList;
    }

    public boolean isAvailable(String resourcePath) {
        return testRig.hasCopiedResource(new Resource(resourcePath));
    }

    protected ProcessingResult getProcessingResult() {
        return processingResult;
    }
    
    protected void setExtensions(String extension) {
        System.setProperty("concordion.extensions", extension);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.clearProperty("concordion.extensions");
    }
}