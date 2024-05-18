package com.aleshka.workflow.model.event;

import com.aleshka.workflow.model.WithName;
import lombok.Value;

import java.util.Objects;

@Value
public class EventType implements WithName {
    String name;
    EventType parent;
    
    public boolean isSubtypeOf(EventType parentType) {
        if (Objects.equals(parentType, this)) {
            return true;
        }
        if (this.parent == null) {
            return false;
        }
        return this.parent.isSubtypeOf(parentType);
    }

}