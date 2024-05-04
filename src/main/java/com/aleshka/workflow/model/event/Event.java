package com.aleshka.workflow.model.event;

import java.util.Map;

public interface Event {
    EventType getType();
    EventSource getSource();
    EventTarget getTarget();
    Map<String, Object> getParameters();
}
