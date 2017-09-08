package com.gunesmab.rottentomatos.view;


import com.gunesmab.viewmodels.BaseViewModel;

public interface BindableView<VM extends BaseViewModel> {

    void bind(VM object);

    void unBind();
}
