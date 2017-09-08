package com.gunesmab.viewmodels;


import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

public class TopRatedMovieListViewModel extends BaseViewModel {

    @NonNull
    private final ObservableArrayList<ListItemMovieViewModel> movieViewModels;

    public TopRatedMovieListViewModel() {
        movieViewModels = new ObservableArrayList<>();
    }
}
