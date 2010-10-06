package org.concordion.api;

import java.util.EventListener;

public interface ConcordionBuildListener extends EventListener {
    public void concordionBuilt(ConcordionBuildEvent event);
}
