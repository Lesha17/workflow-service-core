package com.aleshka.workflow.model.prototype;

import lombok.Value;

@Value
public class WorkflowPrototypeId {
    String group;
    String id;
    String version;

    @Override
    public String toString() {
        return "%s:%s:%s".formatted(group, id, version);
    }
}
