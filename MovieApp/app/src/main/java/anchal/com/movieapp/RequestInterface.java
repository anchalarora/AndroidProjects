package anchal.com.movieapp;

/**
 * Created by Anchal.arora on 29-12-2016.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestInterface {

    @GET("/3/movie/upcoming?api_key=b7cd3340a794e5a2f35e3abb820b497f")
    Call<JSONResponse> getJSON();


    @GET("/3/movie/{id}?api_key=b7cd3340a794e5a2f35e3abb820b497f")
    Call<MovieDataAccessObject> getJSON(@Path("id") String user);


   // @GET("?api_key=b7cd3340a794e5a2f35e3abb820b497f")
    //Call<MovieDetailResponse> getMovieDetailJSON();
}