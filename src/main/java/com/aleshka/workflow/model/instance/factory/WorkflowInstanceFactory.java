package com.aleshka.workflow.model.instance.factory;

import com.aleshka.workflow.model.instance.WorkflowInstance;

public interface WorkflowInstanceFactory {
    <T> WorkflowInstance<T> createWorkflow(String workflowId, T workflowData);
}
