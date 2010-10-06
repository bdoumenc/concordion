package test.concordion;

import java.util.ArrayList;
import java.util.List;

import org.concordion.api.command.AssertEqualsListener;
import org.concordion.api.command.AssertFailureEvent;
import org.concordion.api.command.AssertSuccessEvent;
import org.concordion.api.command.ThrowableCaughtEvent;
import org.concordion.api.command.ThrowableCaughtListener;

public class EventRecorder implements AssertEqualsListener, ThrowableCaughtListener {

    private List<Object> events = new ArrayList<Object>();

    public void failureReported(AssertFailureEvent event) {
        events.add(event);
    }

    public void successReported(AssertSuccessEvent event) {
        events.add(event);
    }

    public void throwableCaught(ThrowableCaughtEvent event) {
        events.add(event);
    }

    public Object getLast(Class<?> eventClass) {
        Object lastMatch = null;
        for (Object object : events) {
            if (eventClass.isAssignableFrom(object.getClass())) {
                lastMatch = object;
            }
        }
        return lastMatch;
    }


}
