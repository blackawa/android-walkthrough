package jp.blackawa.example.photogallery;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.blackawa.example.photogallery.databinding.AdapterGalleryRecyclerViewBinding;

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.VH> {
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_gallery_recycler_view, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.binding.textIndex.setText(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class VH extends RecyclerView.ViewHolder {

        private AdapterGalleryRecyclerViewBinding binding;

        public VH(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public static class VM {
        private String desc;

        public VM(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }
}
