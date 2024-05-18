package com.aleshka.workflow.processor.actions;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.processor.EventProcessor;
import com.aleshka.workflow.storage.StorageSession;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class ActionEventProcessor implements EventProcessor {
    private final Action action;
    private final EventProcessor allEventsProcessor;

    @Override
    public <T> void process(Event event, StorageSession<T> storageSession) {
        Collection<Event> triggeredEvents = action.perform(event, storageSession);
        for (Event triggeredEvent : triggeredEvents) {
            allEventsProcessor.process(triggeredEvent, storageSession);
        }
    }
}
