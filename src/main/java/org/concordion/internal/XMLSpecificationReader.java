package org.concordion.internal;

import java.io.IOException;
import java.io.InputStream;

import nu.xom.Document;

import org.concordion.api.Resource;
import org.concordion.api.Source;
import org.concordion.api.Specification;
import org.concordion.api.SpecificationReader;

import android.content.Context;
import android.util.Log;

public class XMLSpecificationReader implements SpecificationReader {

    private final Source source;
    private final XMLParser xmlParser;
    private final DocumentParser documentParser;

    public XMLSpecificationReader(Source source, XMLParser xmlParser, DocumentParser documentParser) {
        this.source = source;
        this.xmlParser = xmlParser;
        this.documentParser = documentParser;
    }
    
    public Specification readSpecification(Resource resource, Context context) throws IOException {
        InputStream stream;
        Log.i("CONCORDION", "Reading spec: "+ resource +", with context: "+ context);
        if (context == null) {
            stream = source.createInputStream(resource);
        } else {
            System.out.println("Opening Android asset: "+ resource + " from path: "+ resource.getPath());
            stream = context.getAssets().open(resource.getPath());
        }
        Document document = xmlParser.parse(stream, String.format("[%s: %s]", source, resource.getPath()));
        return documentParser.parse(document, resource);
    }
}
