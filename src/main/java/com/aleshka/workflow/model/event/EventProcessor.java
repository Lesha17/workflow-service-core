package com.aleshka.workflow.model.event;

public interface EventProcessor {
    void process(Event event);
}
