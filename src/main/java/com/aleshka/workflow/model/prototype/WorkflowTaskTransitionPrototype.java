package com.aleshka.workflow.model.prototype;

public interface WorkflowTaskTransitionPrototype extends Prototype {
    TaskPrototype from();
    TaskPrototype to();
}
