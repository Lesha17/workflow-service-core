package com.aleshka.workflow.model.event.matchers;

import com.aleshka.workflow.model.event.Event;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class ByParameterValueEventMatcher implements EventMatcher {
    private final String paramName;
    private final String paramValue;

    @Override
    public boolean match(Event event) {
        return Objects.equals(paramValue, event.getParameters().get(paramName));
    }
}
