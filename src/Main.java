import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Movies movies = new Movies();
        ArrayList<String> movieList = movies.getMovieList();
        String pickedMovie = movies.pickRandomMovie(movieList);
        System.out.println(pickedMovie);
    }
}
