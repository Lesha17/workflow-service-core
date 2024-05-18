package com.aleshka.workflow.processor.actions;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.event.EventSources;
import com.aleshka.workflow.model.event.EventTypes;
import com.aleshka.workflow.model.event.workflow.WorkflowInstanceCreationEvent;
import com.aleshka.workflow.model.instance.WorkflowInstance;
import com.aleshka.workflow.model.prototype.WorkflowPrototype;
import com.aleshka.workflow.model.prototype.WorkflowPrototypeId;
import com.aleshka.workflow.processor.DataExtractor;
import com.aleshka.workflow.storage.StorageSession;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateWorkflowInstanceAction<T> implements Action {
    private final WorkflowPrototype workflowPrototype;
    private final DataExtractor<T> workflowDataExtractor;

    @Override
    public Collection<Event> perform(Event trigger, StorageSession<?> storageSession) {
        T workflowData = workflowDataExtractor.extractData(trigger);
        WorkflowInstance<T> workflowInstance = WorkflowInstance.<T>builder()
                .id(UUID.randomUUID().toString())
                .workflowPrototypeId(workflowPrototype.getId())
                .data(workflowData)
                .completed(false)
                .build();
        storageSession.add(workflowInstance);

        WorkflowInstanceCreationEvent<T> workflowInstanceCreationEvent = WorkflowInstanceCreationEvent.<T>workflowInstanceCreationEventBuilder()
                .type(EventTypes.WORKFLOW_INSTANCE_CREATION)
                .source(EventSources.EVENT_PROCESSOR)
                .workflowInstance(workflowInstance)
                .build();
        return Collections.singletonList(workflowInstanceCreationEvent);
    }
}
