package com.aleshka.workflow.processor.actions;

import com.aleshka.workflow.model.event.Event;
import com.aleshka.workflow.storage.StorageSession;

import java.util.Collection;

public interface Action {
    /**
     * Performs action and returns a list of events produced by this action.
     *
     * @param storageSession a storage session tracking changes to be persisted
     * @param trigger an event triggered this action
     * @return events produced as a result of this action
     */
    Collection<Event> perform(Event trigger, StorageSession<?> storageSession);
}
