package org.concordion.api.command;

import java.util.EventListener;


public interface AssertListener extends EventListener {

    void successReported(AssertSuccessEvent event);
    
    void failureReported(AssertFailureEvent event);

}