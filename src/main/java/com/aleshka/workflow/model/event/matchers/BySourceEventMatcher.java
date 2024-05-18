package com.aleshka.workflow.model.event.matchers;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.event.EventSource;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class BySourceEventMatcher implements EventMatcher {
    private final EventSource eventSource;

    @Override
    public boolean match(Event event) {
        return Objects.equals(eventSource, event.getSource());
    }
}
