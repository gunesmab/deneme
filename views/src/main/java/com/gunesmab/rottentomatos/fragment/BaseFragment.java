package com.gunesmab.rottentomatos.fragment;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gunesmab.javautils.ResourceUtil;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final int layoutId = getLayoutId();
        ResourceUtil.getInstance().checkValid(layoutId);
        final T dataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        bindData(dataBinding);
        return dataBinding.getRoot();
    }

    protected abstract void bindData(T dataBinding);

    @LayoutRes
    protected abstract int getLayoutId();
}
