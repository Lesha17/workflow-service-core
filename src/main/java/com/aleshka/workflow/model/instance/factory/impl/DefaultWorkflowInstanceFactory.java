package com.aleshka.workflow.model.instance.factory.impl;

import com.aleshka.workflow.model.instance.WorkflowInstance;
import com.aleshka.workflow.model.instance.factory.WorkflowInstanceFactory;
import com.aleshka.workflow.model.instance.impl.DefaultWorkflowInstance;

public class DefaultWorkflowInstanceFactory implements WorkflowInstanceFactory {
    @Override
    public <T> WorkflowInstance<T> createWorkflow(String id, T workflowData) {
        return new DefaultWorkflowInstance<>(id, workflowData);
    }
}
