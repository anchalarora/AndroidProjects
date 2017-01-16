package anchal.com.retrofitsample;

/**
 * Created by Anchal.arora on 29-12-2016.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDataAdapter extends RecyclerView.Adapter<MovieDataAdapter.ViewHolder> {
    private ArrayList<MovieDataAccessObject> movie;

    public MovieDataAdapter(ArrayList<MovieDataAccessObject> movie) {
        this.movie = movie;
    }

    @Override
    public MovieDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieDataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.movie_title.setText(movie.get(i).getTitle());
        if(movie.get(i).getAdult() == true)
        {
            viewHolder.movie_adult.setText("A");
        }
        else
        {
            viewHolder.movie_adult.setText("U/A");
        }
        viewHolder.release_date.setText(movie.get(i).getRelease_date());
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView movie_title,movie_adult,release_date;
        public ViewHolder(View view) {
            super(view);

            movie_title = (TextView)view.findViewById(R.id.movie_title);
            movie_adult = (TextView)view.findViewById(R.id.movie_adult);
            release_date = (TextView)view.findViewById(R.id.release_date);

        }
    }

}