// CS145
// Isaiah King
//Pre-Lab 1, Guessing game


import java.util.Random;
import java.util.Scanner;

public class lab1
{
    private static int GAME_COUNT = 0;
    private static int GUESS_COUNT = 0;
    private static int BEST_GUESS = 1000;
    
    // Define vars
    public static void main(String[] args) {
        introMethod();
        while (gameCheck() == true){   
            gameRun();
        }
        overallResults();
    }
    private static boolean gameCheck(){
        return gameRun();
    }


    // method controlling the running game
    private static boolean gameRun(){
        System.out.println("I'm thinking of a number between 1 and 100...");
        int LOOP_COUNT = 0;
        GAME_COUNT++;
        int COMP_GUESS = generatedNumber();
        int GUESS = 0;
        while (GUESS != COMP_GUESS){
            GUESS = userInput();
            GUESS_COUNT ++;
            LOOP_COUNT ++;
            if (GUESS == 1000){
                
            }
            else if (GUESS < COMP_GUESS){
                System.out.println("It's higher.");
            }
            else if (GUESS > COMP_GUESS){
                System.out.println("It's lower.");
            }
            else {
                System.out.println("You got it right in " + LOOP_COUNT + " guesses");
            }
        }
        if (LOOP_COUNT < BEST_GUESS){
            BEST_GUESS = LOOP_COUNT;
        }
        return gameReturn();
    }

    // Intro method, give the instructions.
    private static void introMethod(){
        System.out.println("This program allows you to play a guessing game.\n" + 
                "I will think of a number between 1 and\n" + 
                "100 and will allow you to guess until\n" + 
                "you get it. For each guess, I will tell you\n" + 
                "whether the right answer is higher or lower\n" + 
                "than your guess.\n");
    }

    // Method to generate random number 
    private static int generatedNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    // Method to take input from user, and return lower or higher response
    private static int userInput(){
        try {
            System.out.print("Your guess? ");
        int GUESS = new Scanner(System.in).nextInt();
        return GUESS;
        } catch (Exception e) {
            System.out.println("Please enter a number");
            return 1000;
        }
    }
    // method asking player if they want to play again
    private static boolean gameReturn(){
        System.out.print("Do you want to play again? ");
        String INPUT = new Scanner(System.in).nextLine();
        System.out.println();
        if (INPUT.toLowerCase().startsWith("y")){
            return true;
        }

        return false;
    }
    // printing end results
    private static void overallResults(){
        System.out.println("Overall results:");
        System.out.println("    total games   = " + GAME_COUNT);
        System.out.println("    total guesses = " + GUESS_COUNT);
        System.out.println("    guesses/games = " + (double)GUESS_COUNT/(double)GAME_COUNT);
        System.out.println("    best game     = " + BEST_GUESS);
    }
}



