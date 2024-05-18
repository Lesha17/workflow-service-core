package com.aleshka.workflow.model.prototype;

import com.aleshka.workflow.model.event.matchers.EventMatcher;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
public class WorkflowPrototype implements Prototype {
    WorkflowPrototypeId id;
    Collection<TaskPrototype> tasks;
    Collection<EventMatcher> creationTriggers;
    Collection<EventMatcher> completionTriggers;
}
