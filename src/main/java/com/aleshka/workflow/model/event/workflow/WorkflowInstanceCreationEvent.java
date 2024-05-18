package com.aleshka.workflow.model.event.workflow;

import com.aleshka.workflow.model.instance.WorkflowInstance;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(builderMethodName = "workflowInstanceCreationEventBuilder")
public class WorkflowInstanceCreationEvent<T> extends WorkflowEvent {
    private final WorkflowInstance<T> workflowInstance;
}
