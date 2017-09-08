package com.gunesmab.viewmodels;


import android.databinding.Bindable;
import android.support.annotation.Nullable;

public class ListItemMovieViewModel extends BaseViewModel {

    private final int movieId;

    @Nullable
    private String title;

    @Nullable
    private String overview;

    @Nullable
    private String releaseDate;

    private boolean favorite;

    public ListItemMovieViewModel() {
        movieId = 1;
    }



    public void setTitle(@Nullable final String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setFavorite(final boolean favorite) {
        this.favorite = favorite;
        notifyPropertyChanged(BR.favorite);
    }

    public void setOverview(@Nullable final String overview) {
        this.overview = overview;
        notifyPropertyChanged(BR.overview);
    }

    public void setReleaseDate(@Nullable final String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }

    @Bindable
    @Nullable
    public String getTitle() {
        return title;
    }

    @Bindable
    @Nullable
    public String getOverview() {
        return overview;
    }

    @Bindable
    @Nullable
    public String getReleaseDate() {
        return releaseDate;
    }

    @Bindable
    @Nullable
    public boolean isFavorite() {
        return favorite;
    }
}
