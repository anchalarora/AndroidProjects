package anchal.com.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anchal.arora on 30-12-2016.
 */
public interface RequestMovieDetailInterface {

    @GET("?api_key=b7cd3340a794e5a2f35e3abb820b497f")
    Call<MovieDetailResponse> getJSON();
}
