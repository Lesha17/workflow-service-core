package com.aleshka.workflow.model.event.task;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.instance.TaskInstance;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(builderMethodName = "taskInstanceCreationEventBuilder")
public class TaskCreationEvent<T> extends Event {
    private final TaskInstance<T> taskInstance;
}
