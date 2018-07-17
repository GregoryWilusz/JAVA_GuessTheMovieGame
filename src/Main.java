import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> wrongLetters = new ArrayList<>();
        String guessingLetter;

        Movies movies = new Movies();
        ArrayList<String> movieList = movies.getMovieList();
        String pickedMovie = movies.pickRandomMovie(movieList);
        String encodedMovie = movies.encodeMovie(pickedMovie);
        System.out.println(encodedMovie + " with the length of: " + encodedMovie.length());

        for (int i = 10; i > 0; i--) {
            System.out.println("You are guessing: " + encodedMovie);
            System.out.println("You guessed (" + wrongLetters.size() + ") wrong letters: " + wrongLetters.toString());
            System.out.println("Guess a letter: ");

            Scanner scanner = new Scanner(System.in);
            guessingLetter = scanner.nextLine();

            if(pickedMovie.contains(guessingLetter)) {
                encodedMovie = movies.decodeMovie(pickedMovie, encodedMovie, guessingLetter);
            } else {
                wrongLetters.add(guessingLetter.charAt(0));
            }

        }

    }
}
