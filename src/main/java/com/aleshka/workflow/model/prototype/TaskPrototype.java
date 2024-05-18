package com.aleshka.workflow.model.prototype;

import com.aleshka.workflow.model.TaskStatus;
import com.aleshka.workflow.model.event.matchers.EventMatcher;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
public class TaskPrototype implements Prototype {
    String name;
    TaskStatus initialStatus;
    Collection<TaskStatus> statuses;
    Collection<TaskStatusTransitionPrototype> transitions;
    Collection<EventMatcher> creationTriggers;
}
