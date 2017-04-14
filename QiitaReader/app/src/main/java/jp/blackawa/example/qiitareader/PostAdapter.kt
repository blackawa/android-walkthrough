package jp.blackawa.example.qiitareader

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.blackawa.example.qiitareader.data.Post
import jp.blackawa.example.qiitareader.databinding.PostListItemBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.VH> {

    private var posts: List<Post>? = null

    constructor() {}

    constructor(posts: List<Post>) {
        this.posts = posts
    }

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.post_list_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val post = posts!![position]
        holder.binding.post = post
    }

    override fun getItemCount(): Int {
        return if (posts == null) 0 else posts!!.size
    }

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val binding: PostListItemBinding

        init {
            binding = DataBindingUtil.bind<PostListItemBinding>(v)
        }
    }
}
