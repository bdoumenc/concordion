package org.concordion.api.command;

import java.util.EventListener;

import nu.xom.Document;

public interface DocumentParsingListener extends EventListener {

    void beforeParsing(Document document);
}
