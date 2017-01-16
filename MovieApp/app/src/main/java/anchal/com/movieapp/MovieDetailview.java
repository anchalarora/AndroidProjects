package anchal.com.movieapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailview extends AppCompatActivity {


    ImageView imageView;
    TextView des;
    TextView title;
    RatingBar ratingBar;

    int id = 0;

    MovieDataAccessObject newMovies;

    private final static String BASE_URL ="https://api.themoviedb.org";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detailview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        id = getIntent().getIntExtra("key",0);

        imageView = (ImageView) findViewById(R.id.movieImages);
        title = (TextView) findViewById(R.id.movieTitle);
        des = (TextView) findViewById(R.id.movieDes);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        loadJSON();
    }

    private void loadJSON(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<MovieDataAccessObject> call = request.getJSON(id+"");
        call.enqueue(new Callback<MovieDataAccessObject>() {
            @Override
            public void onResponse(Call<MovieDataAccessObject> call, Response<MovieDataAccessObject> response) {

                Log.d("Movie"," Detail Response "+response.body());
                newMovies = response.body();
                setData();
            }

            @Override
            public void onFailure(Call<MovieDataAccessObject> call, Throwable t) {
                Log.d("Error"," Error - "+t.getMessage());
            }
        });
    }


    public void setData() {

        String path = "https://image.tmdb.org/t/p/w500"+newMovies.getBackdrop_path();

        Log.d("Movie", " image path - "+path);

        Picasso.with(this).load(path)
                .fit().centerInside()
                .into(imageView);

        title.setText(newMovies.getTitle());
        des.setText(newMovies.getOverview());
        ratingBar.setRating( newMovies.getVote_average()/2 );

    }

}

