package example.blackawa.jp.todoapp.model;

import java.util.Objects;

public class Todo {
    private Long id;
    private String title;
    private String description;
    private String owner;
    private String deadLine;

    public Todo(Long id, String title, String description, String owner, String deadLine) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.deadLine = deadLine;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public Long getId() {
        return id;
    }

    public boolean isEqualId(Long id) {
        return this.id.equals(id);
    }
}
