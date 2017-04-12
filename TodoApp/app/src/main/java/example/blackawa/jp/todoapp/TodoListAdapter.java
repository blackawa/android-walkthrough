package example.blackawa.jp.todoapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import example.blackawa.jp.todoapp.databinding.TodoListItemBinding;
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
        TodoListItemBinding binding = DataBindingUtil.bind(listView);
        binding.setTodo(todo);
        return binding.getRoot();
    }
}
