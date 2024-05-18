import com.aleshka.workflow.model.prototype.TaskPrototype;
import com.aleshka.workflow.model.prototype.WorkflowPrototype;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WorkflowPrototypeTest {
    @Test
    public void testWorkflowPrototype() {
        WorkflowPrototype workflowPrototype = WorkflowPrototype.builder()
                .tasks(List.of(
                        TaskPrototype.builder().name("A").build(),
                        TaskPrototype.builder().name("B").build()
                ))
                .build();
    }
}
