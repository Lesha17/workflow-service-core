package com.aleshka.workflow.processor;

import com.aleshka.workflow.model.event.Event;

public interface DataExtractor<T> {
    T extractData(Event event);
}
