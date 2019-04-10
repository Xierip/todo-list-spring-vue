package pl.xierip.todolist.task.domain


import pl.xierip.todolist.todolist.task.domain.TaskConfiguration
import pl.xierip.todolist.todolist.task.domain.TaskFacade
import pl.xierip.todolist.todolist.task.dto.TaskDTO
import spock.lang.Specification

class TaskSpec extends Specification implements SampleTasks {
    TaskFacade taskFacade = new TaskConfiguration().taskFacade()

    def "should show a task"() {
        given: "task is in system"
            TaskDTO newCoffee = taskFacade.createTask(makeCoffee)
        expect: "system return task"
            taskFacade.findById(newCoffee.id) == newCoffee
    }
}
