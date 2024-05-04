package com.aleshka.workflow.model.prototype;

import com.aleshka.workflow.model.TaskStatus;

import java.util.Collection;

public interface TaskPrototype extends Prototype {
    Collection<TaskStatus> getStatuses();
    Collection<TaskStatusTransitionPrototype> getTransitions();
}
