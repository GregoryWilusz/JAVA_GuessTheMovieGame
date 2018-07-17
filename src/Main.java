import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder wrongLetters = new StringBuilder();
        int wrongLettersCounter = 0;
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
                System.out.println("You guessed (" + wrongLettersCounter + ") wrong letters: " + wrongLetters);
                System.out.println("You have: " + attemptsLeft + " attempts left.");
                System.out.println("Guess a letter: ");

                Scanner scanner = new Scanner(System.in);
                guessingLetter = scanner.nextLine();

                if(pickedMovie.contains(guessingLetter)) {
                    attemptsLeft++;
                    encodedMovie = movies.decodeMovie(pickedMovie, encodedMovie, guessingLetter);
                } else {
                    wrongLettersCounter++;
                    wrongLetters.append(guessingLetter.charAt(0)).append(" ");
                }
            }
        }
        if (hasWon) {
            System.out.println("You won! The answer is: " + encodedMovie);
        } else {
            System.out.println("Game over. The correct answer is: " + pickedMovie);
        }
    }
}
