import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Movies movies = new Movies();
        ArrayList<String> movieList = movies.getMovieList();
        System.out.println(movieList);
    }
}
