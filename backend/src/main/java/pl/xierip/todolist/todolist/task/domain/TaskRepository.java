package pl.xierip.todolist.todolist.task.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

  List<Task> findAllByState(int state);

  List<Task> findAll();
}
