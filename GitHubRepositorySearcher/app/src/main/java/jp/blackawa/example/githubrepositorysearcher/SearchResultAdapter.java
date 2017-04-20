package jp.blackawa.example.githubrepositorysearcher;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jp.blackawa.example.githubrepositorysearcher.databinding.LayoutSearchResultItemBinding;
import jp.blackawa.example.githubrepositorysearcher.domain.SourceCodeRepository;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.VH> {

    private List<SourceCodeRepository> repositories;

    public SearchResultAdapter(List<SourceCodeRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_search_result_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.getBinding().setViewModel(new ViewModel(repositories.get(position)));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private LayoutSearchResultItemBinding binding;

        public VH(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public LayoutSearchResultItemBinding getBinding() {
            return binding;
        }
    }

    public class ViewModel {
        private String ownerAvatarUrl;
        private String repositoryName;
        private String ownerName;

        public ViewModel(SourceCodeRepository domain) {
            ownerAvatarUrl = domain.getOwnerAvatarUrl();
            repositoryName = domain.getName();
            ownerName = domain.getOwnerName();
        }

        public String getOwnerAvatarUrl() {
            return ownerAvatarUrl;
        }

        public String getRepositoryName() {
            return repositoryName;
        }

        public String getOwnerName() {
            return ownerName;
        }
    }
}
