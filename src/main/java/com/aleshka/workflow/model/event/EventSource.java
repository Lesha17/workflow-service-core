package com.aleshka.workflow.model.event;

import com.aleshka.workflow.model.WithName;
import lombok.Value;

@Value
public class EventSource implements WithName {
    String name;
}
