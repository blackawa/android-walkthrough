package jp.blackawa.example.autoscrollrecyclerview

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.blackawa.example.autoscrollrecyclerview.databinding.RecyclerItemBinding

class MyAdapter(
        private val items: List<String>
) : RecyclerView.Adapter<MyAdapter.VH>() {
    private var vms: List<VM> = buildVMList()
    private var selectedItemIndex: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(viewHolder: VH, i: Int) {
        viewHolder.binding.vm = vms[i]
    }

    override fun getItemCount() = items.size

    internal fun incrementSelectedItem() {
        val beforeIndex = selectedItemIndex
        selectedItemIndex++
        vms = buildVMList()
        notifyItemChanged(beforeIndex)
        notifyItemChanged(selectedItemIndex)
    }

    internal fun decrementSelectedItem() {
        val beforeIndex = selectedItemIndex
        selectedItemIndex--
        vms = buildVMList()
        notifyItemChanged(beforeIndex)
        notifyItemChanged(selectedItemIndex)
    }

    private fun buildVMList() =
            items.mapIndexed { i, item -> VM(item, selectedItemIndex == i) }

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val binding: RecyclerItemBinding = DataBindingUtil.bind<RecyclerItemBinding>(view)
    }

    data class VM(val text: String, val selected: Boolean)
}
