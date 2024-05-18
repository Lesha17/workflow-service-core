package com.aleshka.workflow.processor.actions;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.event.EventSources;
import com.aleshka.workflow.model.event.EventTypes;
import com.aleshka.workflow.model.event.task.TaskCreationEvent;
import com.aleshka.workflow.model.instance.TaskInstance;
import com.aleshka.workflow.model.prototype.TaskPrototype;
import com.aleshka.workflow.processor.DataExtractor;
import com.aleshka.workflow.storage.StorageSession;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateTaskInstanceAction<T> implements Action {
    private final DataExtractor<T> taskDataExtractor;
    private final TaskPrototype taskPrototype;

    @Override
    public Collection<Event> perform(Event trigger, StorageSession<?> storageSession) {
        T taskData = taskDataExtractor.extractData(trigger);
        TaskInstance<T> taskInstance = TaskInstance.<T>builder()
                .id(UUID.randomUUID().toString())
                .data(taskData)
                .status(taskPrototype.getInitialStatus())
                .build();
        storageSession.add(taskInstance);

        TaskCreationEvent<T> taskCreationEvent = TaskCreationEvent.<T>taskInstanceCreationEventBuilder()
                .type(EventTypes.TASK_INSTANCE_CREATION)
                .source(EventSources.EVENT_PROCESSOR)
                .taskInstance(taskInstance)
                .build();
        return Collections.singletonList(taskCreationEvent);
    }
}
