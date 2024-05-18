package com.aleshka.workflow.model.instance;

import com.aleshka.workflow.model.prototype.WorkflowPrototypeId;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder(toBuilder = true)
public class WorkflowInstance<T> implements Instance {
    String id;
    WorkflowPrototypeId workflowPrototypeId;
    boolean completed;
    Collection<TaskInstance<?>> tasks;
    T data;
}
