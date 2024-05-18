package com.aleshka.workflow.model.event;

public class EventTypes {
    public static final EventType BASE_EVENT = new EventType("BaseEvent", null);
    public static final EventType WORKFLOW = new EventType("WorkflowEvent", BASE_EVENT);
    public static final EventType WORKFLOW_INSTANCE = new EventType("WorkflowInstance", WORKFLOW);
    public static final EventType WORKFLOW_INSTANCE_CREATION = new EventType("WorkflowInstanceCreation", WORKFLOW_INSTANCE);
    public static final EventType TASK_INSTANCE = new EventType("TaskInstance", WORKFLOW);
    public static final EventType TASK_INSTANCE_CREATION = new EventType("TaskInstanceCreation", TASK_INSTANCE);
}
