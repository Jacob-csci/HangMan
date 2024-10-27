import java.util.Scanner;
import java.util.Random;

class MyClass {
  public static void main(String[] args) {
    
    Random rand = new Random();

    String [] answers = {"hello", "goodbye", "something"};
    int pickNumber = rand.nextInt(answers.length);

    String answer = answers[pickNumber];
    String end = answer;


    Scanner gameStart = new Scanner(System.in);
    String wrongGuesses = "";
    String corrrectGuesses = "";
    System.out.println("Would you like to play hangman");
    System.out.println("yes or no");

    String gameState = gameStart.nextLine();

    // Welcome message
    if(gameState.equals("yes")){
        System.out.println("Welcome start guessing");
        for(int i = 0; i < answer.length(); i++){
            System.out.print("_ ");
        }
    }
    // Run the game if the user enters yes.
    while(gameState.equals("yes")){
        System.out.println();
        System.out.println();
        String guess = gameStart.nextLine();
        guess = guess.toLowerCase();

        // Rule for guess only being an alphabet character
        if(guess.length() != 1 || !guess.matches("^[a-zA-Z]*$")){
            System.out.println("Please Enter A Letter To guess.");
        }
        //If the guess if correct delete that letter from the answer
        if(answer.contains(guess)){
            answer = answer.replace(guess, "");
            corrrectGuesses = corrrectGuesses + guess;
            System.out.println("Correct keep guessing!!!");
            System.out.println("Correct Guesses:" + corrrectGuesses);
            System.out.println("Incorrect Guesses:" + wrongGuesses);
            // If the length of answer is 0 the user wins
            if(answer.length() == 0){
                System.out.println(answer);
                System.out.println("Congrats you win!!");
                break;
            }
            continue;
        }
        // If the guess is wrong show the incorrect letter
        if(wrongGuesses.contains(guess) || corrrectGuesses.contains(guess)){
            System.out.println("you already guessed that try again");
        }

        // Adds an incorrect guess to the wrongGuesses string
        if(answer.contains(guess) == false && corrrectGuesses.contains(guess) == false && wrongGuesses.contains(guess) == false){
            wrongGuesses = wrongGuesses + guess;
            System.out.println("incorrect try again");
            System.out.println("Incorrect Guesses:" + wrongGuesses);

            // If the user goes over 7 wrong guesses they lose
            if(wrongGuesses.length() > 7){
                System.out.println(end + " was the correct answer");
                System.out.println("Sorry better luck next time");
                break;
                }
            }
        }
    // if the user enters no game doesn't start
    if(gameState.equals("no")){
        System.out.println("Ok maybe next time");
    }
    gameStart.close();
  }
}