package com.aleshka.workflow.processor;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.storage.Storage;
import com.aleshka.workflow.storage.StorageSession;
import com.aleshka.workflow.storage.StorageSessionFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkflowMainEventProcessor<T> {
    private final EventProcessor allWorkflowEventsProcessor;
    private final StorageSessionFactory<T> storageSessionFactory;
    private final Storage<T> storage;

    public void process(Event event) {
        StorageSession<T> storageSession = storageSessionFactory.createStorageSession();
        allWorkflowEventsProcessor.process(event, storageSession);
        storage.saveChanges(storageSession.getChangeSet());
    }
}
