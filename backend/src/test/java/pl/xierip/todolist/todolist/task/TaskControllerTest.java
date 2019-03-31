package pl.xierip.todolist.todolist.task;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.xierip.todolist.todolist.task.domain.Task;
import pl.xierip.todolist.todolist.task.domain.TaskRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
@AutoConfigureDataJpa
public class TaskControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private TaskRepository taskRepository;
  private Task           entity;

  @Before
  public void init() {
    entity = new Task(2, "Test", 0);
    taskRepository.save(entity);
  }

  @Test
  public void test_find_all()
      throws Exception {
    mvc.perform(get("/api/tasks")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].text", Matchers.is(entity.getText())));
  }

  @Test
  public void test_find_by_state()
      throws Exception {
    mvc.perform(get("/api/tasks/?state=1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }

  @Test
  public void test_find_by_id()
      throws Exception {
    mvc.perform(get("/api/tasks/" + entity.getId())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", Matchers.is(entity.getId())));
  }

  @Test
  public void test_delete_by_id()
      throws Exception {
    mvc.perform(delete("/api/tasks/" + entity.getId())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
    mvc.perform(get("/api/tasks/"+entity.getId())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

}
