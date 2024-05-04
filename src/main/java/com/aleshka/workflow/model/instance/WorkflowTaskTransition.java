package com.aleshka.workflow.model.instance;

public interface WorkflowTaskTransition extends Instance {
    WorkflowInstance<?> workflowInstance();
    TaskInstance<?> from();
    TaskInstance<?> to();
}
