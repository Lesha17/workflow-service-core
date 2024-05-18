package com.aleshka.workflow.model.event.task;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.model.instance.TaskStatusTransition;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class TaskStatusTransitionEvent extends Event {
    private final TaskStatusTransition transition;
}
