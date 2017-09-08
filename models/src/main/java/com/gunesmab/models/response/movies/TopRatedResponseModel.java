package com.gunesmab.models.response.movies;

import com.google.gson.annotations.SerializedName;
import com.gunesmab.models.response.BaseResponseModel;


public final class TopRatedResponseModel extends BaseResponseModel {

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private int movies;

    public TopRatedResponseModel() {
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getMovies() {
        return movies;
    }
}
