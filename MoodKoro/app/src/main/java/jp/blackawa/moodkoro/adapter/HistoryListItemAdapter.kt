package jp.blackawa.moodkoro.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.blackawa.moodkoro.R
import jp.blackawa.moodkoro.databinding.ListItemHistoryBinding
import jp.blackawa.moodkoro.domain.Mood

class HistoryListItemAdapter(var moods: List<Mood>) : RecyclerView.Adapter<HistoryListItemAdapter.VH>() {

    override fun onBindViewHolder(holder: VH?, position: Int) {
        holder?.binding?.mood = moods[position]
    }

    override fun getItemCount(): Int = moods.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        return VH(inflater.inflate(R.layout.list_item_history, parent, false))
    }

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ListItemHistoryBinding = DataBindingUtil.bind<ListItemHistoryBinding>(v)
    }
}
