package spec.concordion.extension;

import org.concordion.api.Resource;

import test.concordion.TestRig;

public class CSSExtensionTest extends AbstractExtensionTestCase {

    public static final String SOURCE_PATH = "/test/concordion/my.css";
    public static final String TEST_CSS = "/* My test CSS */";

    public void addLinkedCSSExtension() {
        setExtensions("test.concordion.extension.CSSLinkedExtension");
    }

    public void addEmbeddedCSSExtension() {
        setExtensions("test.concordion.extension.CSSEmbeddedExtension");
    }

    @Override
    protected void configureTestRig(TestRig testRig) {
        testRig.withResource(new Resource(SOURCE_PATH), TEST_CSS);
    }
    
    public boolean hasCSSDeclaration(String cssFilename) {
        return getProcessingResult().hasCSSDeclaration(cssFilename);
    }

    public boolean hasEmbeddedTestCSS() {
        return getProcessingResult().hasEmbeddedCSS(TEST_CSS);
    }
}
