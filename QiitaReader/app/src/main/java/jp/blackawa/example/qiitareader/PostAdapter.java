package jp.blackawa.example.qiitareader;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jp.blackawa.example.qiitareader.data.Post;
import jp.blackawa.example.qiitareader.databinding.PostListItemBinding;

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
        holder.getBinding().setPost(post);
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private PostListItemBinding mBinding;

        VH(View v) {
            super(v);
            mBinding = DataBindingUtil.bind(v);
        }

        PostListItemBinding getBinding() {
            return mBinding;
        }
    }
}
