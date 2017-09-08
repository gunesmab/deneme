package com.gunesmab.rottentomatos.adapter.viewholder;

import android.databinding.ViewDataBinding;
import com.gunesmab.rottentomatos.view.BindableView;
import com.gunesmab.rottentomatos.view.recyclerview.RecyclerViewBindable;
import com.gunesmab.viewmodels.BaseViewModel;


public abstract class BindingViewHolder<E extends BaseViewModel> extends RecyclerViewBindable.ViewHolder implements
        BindableView<E> {


    public BindingViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
    }


}
