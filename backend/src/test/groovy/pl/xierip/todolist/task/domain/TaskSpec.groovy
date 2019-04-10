package pl.xierip.todolist.task.domain


import pl.xierip.todolist.todolist.task.domain.TaskConfiguration
import pl.xierip.todolist.todolist.task.domain.TaskFacade
import pl.xierip.todolist.todolist.task.dto.TaskDTO
import pl.xierip.todolist.todolist.task.dto.exceptions.TaskNotFoundException
import spock.lang.Specification

class TaskSpec extends Specification implements SampleTasks {
    TaskFacade taskFacade = new TaskConfiguration().taskFacade()

    def "should show a task"() {
        given: "task is in system"
            TaskDTO newCoffee = taskFacade.createTask(makeCoffee)
        expect: "system return task"
            taskFacade.findById(newCoffee.id) == newCoffee
    }

    def "should throw exception when ask for task that's not in system"() {
        when: "task id is invalid"
        taskFacade.findById(-1)
        then:
        thrown(TaskNotFoundException)
    }
}
