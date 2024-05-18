package com.aleshka.workflow.model.instance;

import com.aleshka.workflow.model.TaskStatus;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskInstance<T> implements Instance {
    String id;
    String workflowInstanceId;
    TaskStatus status;
    T data;
}
