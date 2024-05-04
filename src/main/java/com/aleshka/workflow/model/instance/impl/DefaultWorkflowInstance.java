package com.aleshka.workflow.model.instance.impl;

import com.aleshka.workflow.model.instance.ModifiableWorkflowInstance;
import com.aleshka.workflow.model.instance.TaskInstance;
import com.aleshka.workflow.model.instance.WorkflowTaskTransition;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultWorkflowInstance<T> implements ModifiableWorkflowInstance<T> {
    private final String id;
    private final AtomicReference<T> dataHolder;
    private final AtomicBoolean completed = new AtomicBoolean(false);
    private final Map<String, TaskInstance<?>> activeTasks = new ConcurrentHashMap<>();
    private final List<WorkflowTaskTransition> taskTransitions = Collections.synchronizedList(new ArrayList<>());

    public DefaultWorkflowInstance(String id) {
        this(id, null);
    }

    public DefaultWorkflowInstance(String id, T data) {
        this.id = id;
        this.dataHolder = new AtomicReference<>(data);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isCompleted() {
        return completed.get();
    }

    @Override
    public Collection<TaskInstance<?>> getActiveTasks() {
        return activeTasks.values();
    }

    @Override
    public void addActiveTask(TaskInstance<?> taskInstance) {
        activeTasks.put(taskInstance.getId(), taskInstance);
    }

    @Override
    public void removeActiveTask(String taskId) {
        activeTasks.remove(taskId);
    }

    @Override
    public Collection<WorkflowTaskTransition> getCompletedTaskTransitions() {
        return Collections.unmodifiableCollection(taskTransitions);
    }

    @Override
    public void addTaskTransition(WorkflowTaskTransition taskTransition) {
        taskTransitions.add(taskTransition);
    }

    @Override
    public T getDataHolder() {
        return dataHolder.get();
    }

    @Override
    public void setDataHolder(T dataHolder) {
        this.dataHolder.set(dataHolder);
    }

    @Override
    public void complete() {
        this.completed.set(true);
    }
}
