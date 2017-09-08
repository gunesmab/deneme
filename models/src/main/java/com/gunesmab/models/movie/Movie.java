package com.gunesmab.models.movie;

import com.google.gson.annotations.SerializedName;
import com.gunesmab.models.Model;

import java.util.Arrays;


public final class Movie implements Model {

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("id")
    private int id;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private int voteAverage;

    @SerializedName("title")
    private String title;

    @SerializedName("original_title")
    private String titleOriginal;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("poster_path")
    private String urlPoster;

    @SerializedName("original_language")
    private String languageOriginal;

    @SerializedName("genre_ids")
    private int[] genreIds;

    @SerializedName("backdrop_path")
    private String backdropUrl;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    private Movie() {
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleOriginal() {
        return titleOriginal;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public String getLanguageOriginal() {
        return languageOriginal;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (voteCount != movie.voteCount) return false;
        if (id != movie.id) return false;
        if (video != movie.video) return false;
        if (voteAverage != movie.voteAverage) return false;
        if (Double.compare(movie.popularity, popularity) != 0) return false;
        if (adult != movie.adult) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (titleOriginal != null ? !titleOriginal.equals(movie.titleOriginal) : movie.titleOriginal != null)
            return false;
        if (urlPoster != null ? !urlPoster.equals(movie.urlPoster) : movie.urlPoster != null) return false;
        if (languageOriginal != null ? !languageOriginal.equals(movie.languageOriginal) : movie.languageOriginal != null)
            return false;
        if (!Arrays.equals(genreIds, movie.genreIds)) return false;
        if (backdropUrl != null ? !backdropUrl.equals(movie.backdropUrl) : movie.backdropUrl != null) return false;
        if (overview != null ? !overview.equals(movie.overview) : movie.overview != null) return false;
        return releaseDate != null ? releaseDate.equals(movie.releaseDate) : movie.releaseDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = voteCount;
        result = 31 * result + id;
        result = 31 * result + (video ? 1 : 0);
        result = 31 * result + voteAverage;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (titleOriginal != null ? titleOriginal.hashCode() : 0);
        temp = Double.doubleToLongBits(popularity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (urlPoster != null ? urlPoster.hashCode() : 0);
        result = 31 * result + (languageOriginal != null ? languageOriginal.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(genreIds);
        result = 31 * result + (backdropUrl != null ? backdropUrl.hashCode() : 0);
        result = 31 * result + (adult ? 1 : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}
