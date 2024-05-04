package com.aleshka.workflow.model.instance;

import java.util.Collection;

public interface WorkflowInstance<T> extends Instance {
    boolean isCompleted();
    Collection<TaskInstance<?>> getActiveTasks();
    Collection<WorkflowTaskTransition> getCompletedTaskTransitions();
    T getDataHolder();
}
