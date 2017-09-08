package com.gunesmab.rottentomatos.adapter;


import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.gunesmab.rottentomatos.adapter.viewholder.BindingViewHolder;
import com.gunesmab.rottentomatos.adapter.viewholder.ViewHolderHelper;
import com.gunesmab.rottentomatos.view.recyclerview.RecyclerViewBindable;
import com.gunesmab.viewmodels.BaseViewModel;

public class BasicAdapter<E extends BaseViewModel>
        extends RecyclerViewBindable.Adapter<BindingViewHolder<E>> {

    @NonNull
    private final ObservableArrayList<E> observableArrayList;

    @NonNull
    private final ViewHolderHelper<E> viewHolderHelper;

    public BasicAdapter(@NonNull final ObservableArrayList<E> observableArrayList,
                        @NonNull final ViewHolderHelper<E> viewHolderHelper) {
        this.observableArrayList = observableArrayList;
        this.viewHolderHelper = viewHolderHelper;
        observableArrayList.addOnListChangedCallback(new AdapterOnListChangeCallback(this));
    }

    @NonNull
    @Override
    public final BindingViewHolder<E> onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return viewHolderHelper.createViewHolder(parent, viewType);
    }

    @Override
    public final void onBindViewHolder(BindingViewHolder<E> holder, int position) {
        holder.bind(observableArrayList.get(position));
    }

    @Override
    public final int getItemCount() {
        return observableArrayList.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return viewHolderHelper.getItemViewType(observableArrayList.get(position));
    }

    private static final class AdapterOnListChangeCallback<E, L extends ObservableArrayList<E>>
            extends ObservableList.OnListChangedCallback<L> {

        @NonNull
        private final RecyclerView.Adapter adapter;

        public AdapterOnListChangeCallback(@NonNull final RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        @Override
        public void onChanged(L list) {
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(L list, int positionStart, int itemCount) {
            adapter.notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeInserted(L list, int positionStart, int itemCount) {
            adapter.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(L list, int fromPosition, int toPosition, int itemCount) {
            for (int i = 0; i < itemCount; i++) {
                adapter.notifyItemMoved(fromPosition, toPosition);
            }
        }

        @Override
        public void onItemRangeRemoved(L list, int positionStart, int itemCount) {
            adapter.notifyItemRangeRemoved(positionStart, itemCount);
        }
    }
}
