package example.blackawa.jp.todoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import example.blackawa.jp.todoapp.model.Todo;

public class TodoListAdapter extends ArrayAdapter<Todo> {
    public TodoListAdapter(Context context, List<Todo> todos) {
        super(context, 0, todos);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.todo_list_item, parent, false
            );
        }
        Todo todo = getItem(position);
        TextView title = (TextView) listView.findViewById(R.id.tv_todo_title);
        title.setText(todo.getTitle());
        TextView owner = (TextView) listView.findViewById(R.id.tv_owner);
        owner.setText(todo.getOwner());
        TextView deadLine = (TextView) listView.findViewById(R.id.tv_dead_line);
        deadLine.setText(todo.getDeadLine());
        return listView;
    }
}

