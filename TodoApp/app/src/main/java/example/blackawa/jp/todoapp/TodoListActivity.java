package example.blackawa.jp.todoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import example.blackawa.jp.todoapp.model.Todo;
import example.blackawa.jp.todoapp.repository.TodoContract;

public class TodoListActivity extends AppCompatActivity {


    private ListView mTodoListView;
    private TodoDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        mTodoListView = (ListView) findViewById(R.id.lv_todos);
        mDbHelper = new TodoDbHelper(this);

        TodoListAdapter adapter = new TodoListAdapter(TodoListActivity.this, fetchTodo());
        mTodoListView.setAdapter(adapter);

        Button newTaskButton = (Button) findViewById(R.id.bt_new_task);
        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNewTaskButton(v);
            }
        });
    }

    private List<Todo> fetchTodo() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.query(TodoContract.TodoEntity.TABLE_NAME,
                new String[]{TodoContract.TodoEntity._ID,
                        TodoContract.TodoEntity.COLUMN_TITLE,
                        TodoContract.TodoEntity.COLUMN_DESCRIPTION,
                        TodoContract.TodoEntity.COLUMN_OWNER,
                        TodoContract.TodoEntity.COLUMN_DEAD_LINE},
                null,
                null,
                null,
                null,
                null);
        int idIndex = cursor.getColumnIndex(TodoContract.TodoEntity._ID);
        int titleIndex = cursor.getColumnIndex(TodoContract.TodoEntity.COLUMN_TITLE);
        int descIndex = cursor.getColumnIndex(TodoContract.TodoEntity.COLUMN_DESCRIPTION);
        int ownerIndex = cursor.getColumnIndex(TodoContract.TodoEntity.COLUMN_OWNER);
        int deadLineIndex = cursor.getColumnIndex(TodoContract.TodoEntity.COLUMN_DEAD_LINE);

        List<Todo> todos = new ArrayList<>();

        while (cursor.moveToNext()) {
            todos.add(
                    new Todo(
                            (long) cursor.getInt(idIndex),
                            cursor.getString(titleIndex),
                            cursor.getString(descIndex),
                            cursor.getString(ownerIndex),
                            cursor.getString(deadLineIndex)
                    )
            );
        }

        return todos;
    }

    public void onClickNewTaskButton(View view) {
        Intent intent = new Intent(TodoListActivity.this, TodoTaskActivity.class);
        startActivity(intent);
    }
}
