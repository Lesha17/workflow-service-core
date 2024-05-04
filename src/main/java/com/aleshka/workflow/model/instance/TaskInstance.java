package com.aleshka.workflow.model.instance;

import com.aleshka.workflow.model.TaskStatus;

import java.util.Collection;

public interface TaskInstance<T> extends Instance {
    WorkflowInstance<?> getWorkflowInstance();
    TaskStatus getStatus();
    Collection<TaskStatusTransition> getStatusTransitions();
    T getData();
}
