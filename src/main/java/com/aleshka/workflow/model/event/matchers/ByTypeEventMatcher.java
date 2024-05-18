package com.aleshka.workflow.model.event.matchers;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.event.EventType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ByTypeEventMatcher implements EventMatcher {
    private final EventType eventType;

    @Override
    public boolean match(Event event) {
        return event.getType().isSubtypeOf(eventType);
    }
}
