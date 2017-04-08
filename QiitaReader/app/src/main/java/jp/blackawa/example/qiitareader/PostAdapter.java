package jp.blackawa.example.qiitareader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jp.blackawa.example.qiitareader.data.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.VH> {

    private List<Post> posts;

    public PostAdapter() {
    }

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.post_list_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Post post = posts.get(position);
        holder.bind(post.getTitle(), post.getUsername(), post.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return posts == null? 0 : posts.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView username;
        private TextView postDate;
        VH(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.post_title);
            username = (TextView) itemView.findViewById(R.id.username);
            postDate = (TextView) itemView.findViewById(R.id.post_date);
        }

        void bind(String title, String username, String postDate) {
            this.title.setText(title);
            this.username.setText(username);
            this.postDate.setText(postDate);
        }
    }
}
