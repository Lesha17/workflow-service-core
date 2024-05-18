package com.aleshka.workflow.model.event;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.Map;

@Getter
@SuperBuilder
public class Event {
    @Builder.Default
    private final EventType type = EventTypes.BASE_EVENT;
    private final EventSource source;
    @Builder.Default
    private final Map<String, Object> parameters = Collections.emptyMap();
}
