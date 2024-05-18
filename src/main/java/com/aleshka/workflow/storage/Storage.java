package com.aleshka.workflow.storage;

public interface Storage<T> {
    void saveChanges(T changeSet);
}
