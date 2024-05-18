package com.aleshka.workflow.model.instance;

import com.aleshka.workflow.model.TaskStatus;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TaskStatusTransition implements Instance {
    String id;
    String taskId;
    TaskStatus from;
    TaskStatus to;
}
