package com.gunesmab.dataprovider;


import com.gunesmab.models.response.movies.TopRatedResponseModel;
import com.gunesmab.network.CallResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDpService {
//base url :
//base movie url : movie/top_rated

    String URL_BASE_MOVIE = "movie";
    String EXTRA_PARAMETER_KEY_PAGE = "page";

    @GET(URL_BASE_MOVIE + "/top_rated")
    CallResponse<TopRatedResponseModel> getTopRated(@Query(EXTRA_PARAMETER_KEY_PAGE) String page);
}
