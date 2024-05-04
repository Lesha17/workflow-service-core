package com.aleshka.workflow.model.prototype;

import com.aleshka.workflow.model.TaskStatus;

public interface TaskStatusTransitionPrototype extends Prototype {
    TaskStatus getFrom();
    TaskStatus getTo();
}
