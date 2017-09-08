package com.gunesmab.rottentomatos.adapter.viewholder;


import android.view.ViewGroup;
import com.gunesmab.viewmodels.BaseViewModel;

public interface ViewHolderHelper<E extends BaseViewModel> {



    BindingViewHolder<E> createViewHolder(ViewGroup parent, int viewType);

    int getItemViewType(E e);
}
