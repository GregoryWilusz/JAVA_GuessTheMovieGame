import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> wrongLetters = new ArrayList<>();
        String guessingLetter;
        boolean hasWon = false;

        Movies movies = new Movies();
        ArrayList<String> movieList = movies.getMovieList();
        String pickedMovie = movies.pickRandomMovie(movieList);
        String encodedMovie = movies.encodeMovie(pickedMovie);
        System.out.println(encodedMovie);

        for (int attemptsLeft = 10; attemptsLeft > 0; attemptsLeft--) {
            if(encodedMovie.indexOf('_') == -1) {
                hasWon = true;
            } else {
                System.out.println("You are guessing: " + encodedMovie);
                System.out.println("You guessed (" + wrongLetters.size() + ") wrong letters: " + wrongLetters.toString());
                System.out.println("You have: " + attemptsLeft + " attempts left.");
                System.out.println("Guess a letter: ");

                Scanner scanner = new Scanner(System.in);
                guessingLetter = scanner.nextLine();

                if(pickedMovie.contains(guessingLetter)) {
                    attemptsLeft++;
                    encodedMovie = movies.decodeMovie(pickedMovie, encodedMovie, guessingLetter);
                } else {
                    wrongLetters.add(guessingLetter.charAt(0));
                }
            }
        }
        if (hasWon) {
            System.out.println("You won! The correct answer is: " + encodedMovie);
        } else {
            System.out.println("Game over. The correct answer is: " + pickedMovie);
        }
    }
}
