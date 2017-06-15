package jp.blackawa.moodkoro.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.blackawa.moodkoro.R
import jp.blackawa.moodkoro.databinding.ListItemHistoryBinding
import jp.blackawa.moodkoro.domain.Mood

class HistoryListItemAdapter(
        private val context: Context,
        private var moods: List<Mood> = arrayListOf<Mood>(),
        private val listener: View.OnClickListener
) : RecyclerView.Adapter<HistoryListItemAdapter.VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.mood = moods[position]
        holder.itemView.setOnClickListener(listener)
    }

    override fun getItemCount(): Int = moods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return VH(inflater.inflate(R.layout.list_item_history, parent, false))
    }

    fun updateList(moods: List<Mood>): Unit {
        this.moods = moods
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Mood = moods[position]

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ListItemHistoryBinding = DataBindingUtil.bind<ListItemHistoryBinding>(v)
    }
}
