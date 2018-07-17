import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies {
    private ArrayList<String> movieList;

    Movies() {
        this.movieList = new ArrayList<>();
    }

    ArrayList<String> getMovieList() throws FileNotFoundException {
        File fileWithMovies = new File("movies.txt");
        Scanner scanner = new Scanner(fileWithMovies);

        while(scanner.hasNextLine()) {
            this.movieList.add(scanner.nextLine());
        }
        return this.movieList;
    }
}
