package com.aleshka.workflow.model.instance;

import com.aleshka.workflow.model.TaskStatus;

public interface TaskStatusTransition extends Instance {
    TaskInstance<?> task();
    TaskStatus from();
    TaskStatus to();
}
