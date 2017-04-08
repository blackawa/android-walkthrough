package example.blackawa.jp.todoapp;

import java.util.Arrays;
import java.util.List;

import example.blackawa.jp.todoapp.model.Todo;

public class TodoData {
    public static List<Todo> fetchTodos() {
        return Arrays.asList(
                new Todo(1L, "Feed my dog", "feed my dog.", "blackawa", "2017/04/06"),
                new Todo(2L, "Decide to buy books", "decide what book to buy at Gijutsu-Shoten2", "blackawa", "2017/04/07"),
                new Todo(3L, "Swim", "find pool, and go to swim", "blackawa", "2017/04/30")
        );
    }
}
