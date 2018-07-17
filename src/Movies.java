import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies {
    private ArrayList<String> movieList;

    public Movies() {
        this.movieList = new ArrayList<>();
    }

    public ArrayList<String> getMovieList() throws FileNotFoundException {
        File fileWithMovies = new File("movies.txt");
        Scanner scanner = new Scanner(fileWithMovies);

        while(scanner.hasNextLine()) {
            this.movieList.add(scanner.nextLine());
        }
        return this.movieList;
    }

    public String pickRandomMovie(ArrayList<String> movieList) {
        int randomIndex = (int) ((Math.random() * movieList.size()) + 1);
        return movieList.get(randomIndex);
    }

    public String encodeMovie(String pickedMovie) {
        System.out.println(pickedMovie);
        StringBuilder encodedMovie = new StringBuilder();
        for(int i = 0; i < pickedMovie.length(); i++) {
            if(pickedMovie.charAt(i) != ' ') {
                encodedMovie.append("_");

            } else {
                encodedMovie.append(" ");
            }
        }
        return encodedMovie.toString();
    }

    public String decodeMovie(String pickedMovie, String encodedMovie, String guessingLetter) {
        StringBuilder decodedMovie = new StringBuilder(encodedMovie);
        for(int i = 0; i < encodedMovie.length(); i++) {
            if(pickedMovie.charAt(i) == guessingLetter.charAt(0)) {
                decodedMovie.setCharAt(i, guessingLetter.charAt(0));
            }
        }
        return decodedMovie.toString();
    }
}
