package spec.concordion.extension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.runner.RunWith;

import test.concordion.JavaSourceCompiler;
import test.concordion.ProcessingResult;
import test.concordion.TestRig;
import test.concordion.extension.fake.FakeExtensionBase;

@RunWith(ConcordionRunner.class)
public class ExtensionConfigurationTest {

    private JavaSourceCompiler compiler = new JavaSourceCompiler();
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("class\\s*(.*?)\\s*(\\{|extends)");

    @After
    public void clearConcordionExtensionsSystemProperty() {
        System.clearProperty("concordion.extensions");
    }
    
    public String process() throws Exception {
        return process("public class ExampleFixture { }");
    }
    
    public String process(String javaFragment) throws Exception {
        String htmlFragment = "";
        Object fixture = compileFixture(javaFragment);
        ProcessingResult result = process(htmlFragment, fixture);
        return result.getRootElement().getAttributeValue(FakeExtensionBase.FAKE_EXTENSION_ATTR_NAME);
    }

    public String process(String javaFragment1, String javaFragment2) throws Exception {
        String htmlFragment = "";
        compileFixture(javaFragment1);
        Object fixture = compileFixture(javaFragment2);
        ProcessingResult result = process(htmlFragment, fixture);
        return result.getRootElement().getAttributeValue(FakeExtensionBase.FAKE_EXTENSION_ATTR_NAME);
    }

    private ProcessingResult process(String htmlFragment, Object fixture) {
        ProcessingResult result = new TestRig()
            .withFixture(fixture)
            .processFragment(htmlFragment);
        return result;
    }

    private Object compileFixture(String javaFragment) throws Exception, InstantiationException,
            IllegalAccessException {
        String className = getClassName(javaFragment);
        Class<?> clazz = compiler.compile(className, javaFragment);
        Object fixture = clazz.newInstance();
        return fixture;
    }

    private String getClassName(String javaFragment) {
        Matcher matcher = CLASS_NAME_PATTERN.matcher(javaFragment);
        matcher.find();
        return matcher.group(1);
    }
    
    public void setSystemProperty(String key, String value) {
        System.setProperty(key, value);
    }
}
