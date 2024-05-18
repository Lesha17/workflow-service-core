package com.aleshka.workflow.storage;

public interface StorageSessionFactory<T> {
    StorageSession<T> createStorageSession();
}
