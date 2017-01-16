package anchal.com.retrofitsample;

import android.graphics.Bitmap;

/**
 * Created by Anchal.arora on 29-12-2016.
 */
public class MovieDataAccessObject {

    private String title;
    private String release_date ;
    private Boolean adult;
    private Bitmap image;

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }
}
