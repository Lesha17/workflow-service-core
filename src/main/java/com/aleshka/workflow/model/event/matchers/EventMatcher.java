package com.aleshka.workflow.model.event.matchers;

import com.aleshka.workflow.model.event.Event;

public interface EventMatcher {
    boolean match(Event event);
}
