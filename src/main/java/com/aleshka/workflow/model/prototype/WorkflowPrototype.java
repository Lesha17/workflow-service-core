package com.aleshka.workflow.model.prototype;

import java.util.Collection;

public interface WorkflowPrototype extends Prototype {
    Collection<TaskPrototype> getTasks();
    Collection<WorkflowTaskTransitionPrototype> getTransitions();
}
