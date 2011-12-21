package org.concordion.api;

import java.io.IOException;

import android.content.Context;

public interface SpecificationReader {

    Specification readSpecification(Resource resource, Context context) throws IOException;

}
