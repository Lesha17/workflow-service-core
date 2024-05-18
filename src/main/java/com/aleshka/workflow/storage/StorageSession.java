package com.aleshka.workflow.storage;

import com.aleshka.workflow.model.instance.Instance;

public interface StorageSession<T> {
    void add(Instance instance);

    // Maybe better use commit here?
    T getChangeSet();
}
