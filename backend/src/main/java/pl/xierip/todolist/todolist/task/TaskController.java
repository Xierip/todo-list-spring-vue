package pl.xierip.todolist.todolist.task;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.xierip.todolist.todolist.task.domain.TaskService;
import pl.xierip.todolist.todolist.task.dto.TaskDTO;

@RestController
@RequestMapping("/api/tasks")
class TaskController {

  private final TaskService taskService;

  TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public ResponseEntity<List<TaskDTO>> findAll() {
    return ResponseEntity.ok(taskService.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<TaskDTO> findById(@PathVariable int id) {
    return ResponseEntity.ok(taskService.findById(id));
  }

  @PostMapping
  public ResponseEntity<TaskDTO> newTask(@Valid @RequestBody TaskDTO task) {
    return ResponseEntity.ok(taskService.createTask(task));
  }

  @DeleteMapping("{id}")
  public ResponseEntity deleteTask(@PathVariable int id) {
    taskService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity updateTask(@PathVariable int id, @Valid @RequestBody TaskDTO task) {
    taskService.update(id, task);
    return ResponseEntity.noContent().build();
  }
}
