package com.aleshka.workflow.model.instance;

public interface ModifiableWorkflowInstance<T> extends WorkflowInstance<T> {
    void addActiveTask(TaskInstance<?> taskInstance);
    void removeActiveTask(String taskId);
    void addTaskTransition(WorkflowTaskTransition taskTransition);
    void setDataHolder(T dataHolder);
    void complete();
}
