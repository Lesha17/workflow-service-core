package com.aleshka.workflow.model.prototype;

import com.aleshka.workflow.model.WithName;

/**
 * A workflow, task or transition prototype. Prototypes are referred by name while instances are referred by id.
 */
public interface Prototype extends WithName {
    /**
     * Returns prototype name. It must be unique across similar prototypes within parent prototype
     * (e.g. task prototype name must be unique within workflow prototype)
     *
     * @return name of this prototype
     */
    @Override
    String getName();
}
