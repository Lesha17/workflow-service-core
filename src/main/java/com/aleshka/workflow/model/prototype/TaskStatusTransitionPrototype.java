package com.aleshka.workflow.model.prototype;

import com.aleshka.workflow.model.TaskStatus;
import com.aleshka.workflow.model.event.matchers.EventMatcher;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
public class TaskStatusTransitionPrototype implements Prototype {
    TaskStatus source;
    TaskStatus target;
    Collection<EventMatcher> triggers; // TODO we also need matchers for instances, but need to think on transactional implementation
}
