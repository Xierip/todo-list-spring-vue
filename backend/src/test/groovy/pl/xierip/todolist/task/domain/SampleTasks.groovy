package pl.xierip.todolist.task.domain

import groovy.transform.CompileStatic
import pl.xierip.todolist.todolist.task.dto.TaskDTO

@CompileStatic
trait SampleTasks {

    TaskDTO makeCoffee = createTaskDto("Make coffe", 1)
    TaskDTO flyToChina = createTaskDto("Fly to China", 0)

    static private TaskDTO createTaskDto(String text, int priority) {
        return TaskDTO.builder()
                .withText(text)
                .withPriority(0)
                .withState(0)
                .build()
    }
}