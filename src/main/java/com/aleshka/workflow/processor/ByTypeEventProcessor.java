package com.aleshka.workflow.processor;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.event.EventType;
import com.aleshka.workflow.storage.StorageSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ByTypeEventProcessor implements EventProcessor {

    private final boolean parentFirst;
    private final Map<EventType, List<EventProcessor>> eventProcessorsByType = new ConcurrentHashMap<>();

    public ByTypeEventProcessor(boolean parentFirst) {
        this.parentFirst = parentFirst;
    }

    @Override
    public <T> void process(Event event, StorageSession<T> storageSession) {
        for (EventProcessor eventProcessor : findEventProcessorByType(event.getType())) {
            eventProcessor.process(event, storageSession);
        }
    }

    public void addEventProcessor(EventType type, EventProcessor eventProcessor) {
        eventProcessorsByType.computeIfAbsent(type, t -> Collections.synchronizedList(new ArrayList<>()))
                .add(eventProcessor);

    }

    private List<EventProcessor> findEventProcessorByType(EventType eventType) {
        List<EventProcessor> result = new ArrayList<>();
        if (!parentFirst) {
            result.addAll(eventProcessorsByType.getOrDefault(eventType, Collections.emptyList()));
        }
        if (eventType.getParent() != null) {
            result.addAll(findEventProcessorByType(eventType.getParent()));
        }
        if (parentFirst) {
            result.addAll(eventProcessorsByType.getOrDefault(eventType, Collections.emptyList()));
        }
        return result;
    }
}
