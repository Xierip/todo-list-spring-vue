package pl.xierip.todolist.todolist.task.dto;

import javax.validation.constraints.NotNull;

public class TaskDTO {

  private int    id;
  private int    priority;
  @NotNull
  private String text;
  private int    state;

  TaskDTO(int id, int priority, String text, int state) {
    this.id = id;
    this.priority = priority;
    this.text = text;
    this.state = state;
  }

  public TaskDTO() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public static TaskDTOBuilder builder() {
    return new TaskDTOBuilder();
  }
}
