import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static Scanner sc = new Scanner(System.in);
    static String difficulty = "Normal";
    static int guessesLeft = 7;
    static String wordToGuess = "";
    static Random rand = new Random();
    static char[] lineFiller = new char['c'];



    public static void main(String[] args) {
            gamePlay();
    }


    public static void playerGuess() {

        ArrayList<Character> l=new ArrayList<Character>();

        while (guessesLeft > 0) {
           char playerChoice = sc.next().charAt(0);

           if (l.contains(playerChoice)) {
               System.out.println("This letter has already been guessed.");
               continue;
           }


           l.add(playerChoice);

           if (wordToGuess.contains(playerChoice+"")){
               for(int j = 0; j<wordToGuess.length(); j++) {
                   if (wordToGuess.charAt(j)== playerChoice){
                       lineFiller[j]=playerChoice;
                   }
               }
               System.out.println(lineFiller);
           }
           else {
               guessesLeft--;
               System.out.println("Incorrect, guess again! You have "+guessesLeft+" guesses left!");
               System.out.println(lineFiller);

               if (guessesLeft == 0) {
                   System.out.println("Out of guesses!\nGame Over.\nPlay Again? (y/n)");
                   String userResponse = sc.next();
                   if (!userResponse.equalsIgnoreCase("y")) {
                       break;
                   }
                   else {
                      gamePlay();
                   }

               }
           }
           if (wordToGuess.equals(String.valueOf(lineFiller))){
               System.out.println("You've won the game!");
               System.out.println("Play Again? (y/n)");
               String userResponse = sc.next();
               if (!userResponse.equalsIgnoreCase("y")) {
                   break;
               }
               else {
                   gamePlay();
               }
           }
        }
    }


    public static void difficultySetting(String difficultyChoice) {
        String[] hardWords = {"awkward","bagpipes","bungler","dwarves","warrior","croquet", "wildebeest", "zealous","codeup"};
        String[] normalWords = {"pixel","ivory","beekeeper", "apple", "gravity", "gravel", "computer", "phone","codeup"};
        String[] easyWords = {"cat", "jar", "chair","bill", "pants", "coffee","fur","cake","pie","codeup"};

        if (difficultyChoice.equalsIgnoreCase("Hard")) {
            guessesLeft = 5;
            wordToGuess = hardWords[rand.nextInt(hardWords.length)];
            System.out.println("You will have "+ guessesLeft +" guesses before game over, good luck!");
        }
        else if (difficultyChoice.equalsIgnoreCase("Normal")) {
            guessesLeft = 7;
            wordToGuess = normalWords[rand.nextInt(normalWords.length)];
            System.out.println("You will have "+ guessesLeft +" guesses before game over, good luck!");


        }
        else if (difficultyChoice.equalsIgnoreCase("Easy")) {
            guessesLeft = 10;
            wordToGuess = easyWords[rand.nextInt(easyWords.length)];
            System.out.println("You will have "+ guessesLeft +" guesses before game over, good luck!");

        }
        else {
            System.out.println("Please input either, Easy, Normal, or Hard, please!");
            difficulty = sc.next();
        }
    }


    public static void gamePlay(){

        System.out.println("Please select a difficulty:\n\n\n  Easy  |  Normal  |  Hard\n\n");
        difficulty = sc.next();
        difficultySetting(difficulty);
        lineFiller = new char[wordToGuess.length()];
        lineFiller = new char[wordToGuess.length()];
        for (int i = 0; i< wordToGuess.length(); i++){
            lineFiller[i]='-';
            if (wordToGuess.charAt(i)==' '){
                lineFiller[i]=' ';
            }
        }
        System.out.println("\n\n\n\n\n");
        System.out.println(lineFiller);
        System.out.println("\n\nType in a letter to try guess the word.");
        playerGuess();

    }

}
