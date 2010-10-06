package org.concordion.api.command;

import java.util.EventListener;

public interface SpecificationProcessingListener extends EventListener {

    void beforeProcessingSpecification(SpecificationProcessingEvent event);

    void afterProcessingSpecification(SpecificationProcessingEvent event);
}
