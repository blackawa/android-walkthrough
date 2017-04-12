package example.blackawa.jp.todoapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.blackawa.jp.todoapp.databinding.TodoListItemBinding;
import example.blackawa.jp.todoapp.model.Todo;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.VH> {
    private List<Todo> todos;

    public TodoListAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.todo_list_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.getBinding().setTodo(todos.get(position));
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private TodoListItemBinding mBinding;

        public VH(View v) {
            super(v);
            mBinding = DataBindingUtil.bind(v);
        }

        public TodoListItemBinding getBinding() {
            return mBinding;
        }
    }
}
