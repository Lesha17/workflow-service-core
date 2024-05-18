package com.aleshka.workflow.processor;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.storage.StorageSession;

public interface EventProcessor {
    <T> void process(Event event, StorageSession<T> storageSession);
}
