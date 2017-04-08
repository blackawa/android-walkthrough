package example.blackawa.jp.todoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import example.blackawa.jp.todoapp.repository.TodoContract;

public class TodoTaskActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText descriptionEditText;
    EditText ownerEditText;
    EditText deadLineEditText;
    TodoDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_task);

        Button button = (Button) findViewById(R.id.bt_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSaveButton(v);
            }
        });

        titleEditText = (EditText) findViewById(R.id.et_title);
        descriptionEditText = (EditText) findViewById(R.id.et_description);
        ownerEditText = (EditText) findViewById(R.id.et_owner);
        deadLineEditText = (EditText) findViewById(R.id.et_dead_line);
        mDbHelper = new TodoDbHelper(this);
    }

    private void onClickSaveButton(View v) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntity.COLUMN_TITLE, titleEditText.getText().toString());
        values.put(TodoContract.TodoEntity.COLUMN_DESCRIPTION, descriptionEditText.getText().toString());
        values.put(TodoContract.TodoEntity.COLUMN_OWNER, ownerEditText.getText().toString());
        values.put(TodoContract.TodoEntity.COLUMN_DEAD_LINE, deadLineEditText.getText().toString());
        db.insert(TodoContract.TodoEntity.TABLE_NAME, null, values);

        Intent intent = new Intent(TodoTaskActivity.this, TodoListActivity.class);
        startActivity(intent);
    }
}
