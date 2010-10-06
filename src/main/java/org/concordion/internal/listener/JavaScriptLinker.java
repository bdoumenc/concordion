package org.concordion.internal.listener;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

import org.concordion.api.Resource;
import org.concordion.api.command.SpecificationProcessingEvent;
import org.concordion.api.command.SpecificationProcessingListener;
import org.concordion.internal.DocumentParsingListener;
import org.concordion.internal.util.Check;

public class JavaScriptLinker implements DocumentParsingListener, SpecificationProcessingListener {

    private final Resource javaScriptResource;
    private Element script;

    public JavaScriptLinker(Resource javaScriptResource) {
        this.javaScriptResource = javaScriptResource;
    }

    public void beforeParsing(Document document) {
        nu.xom.Element html = document.getRootElement();
        nu.xom.Element head = html.getFirstChildElement("head");
        Check.notNull(head, "<head> section is missing from document");
        script = new nu.xom.Element("script");
        script.addAttribute(new Attribute("type", "text/javascript"));
        head.appendChild(script);
    }

    public void beforeProcessingSpecification(SpecificationProcessingEvent event) {
        Resource resource = event.getResource();
        script.addAttribute(new Attribute("src", resource.getRelativePath(javaScriptResource)));
    }

    public void afterProcessingSpecification(SpecificationProcessingEvent event) {
    }

}
