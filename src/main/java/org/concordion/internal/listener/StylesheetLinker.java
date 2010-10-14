package org.concordion.internal.listener;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

import org.concordion.api.Resource;
import org.concordion.api.command.DocumentParsingListener;
import org.concordion.api.command.SpecificationProcessingEvent;
import org.concordion.api.command.SpecificationProcessingListener;
import org.concordion.internal.util.Check;

public class StylesheetLinker implements DocumentParsingListener, SpecificationProcessingListener {

    private final Resource stylesheetResource;
    private Element link;

    public StylesheetLinker(Resource stylesheetResource) {
        this.stylesheetResource = stylesheetResource;
    }

    public void beforeParsing(Document document) {
        nu.xom.Element html = document.getRootElement();
        nu.xom.Element head = html.getFirstChildElement("head");
        Check.notNull(head, "<head> section is missing from document");
        link = new nu.xom.Element("link");
        link.addAttribute(new Attribute("type", "text/css"));
        link.addAttribute(new Attribute("rel", "stylesheet"));
        head.appendChild(link);
    }

    public void beforeProcessingSpecification(SpecificationProcessingEvent event) {
        Resource resource = event.getResource();
        link.addAttribute(new Attribute("href", resource.getRelativePath(stylesheetResource)));
    }

    public void afterProcessingSpecification(SpecificationProcessingEvent event) {
    }

}
