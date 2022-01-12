import java.util.Scanner;

/**
 * 
 * Driver class for Wordle.
 * 
 */

public class Game{
    
    /**
     * 
     * Variables to track is the user has guessed all the letters
     * and/or run out of tries
     * 
     */
    
    private static boolean hasWon=false;
    private static byte tries=0;
    /**
     * Cannot be instantiated as it is the driver
     */
    private Game(){}
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Word wordle = new Word("DRINK");
        String guess;
        
        while(tries<6 && !hasWon){
            System.out.println("Enter guess: ");
            guess = sc.nextLine();
            wordle.makeGuess(guess);
            System.out.println();
            if(wordle.getGuessed().equals(wordle.getWord()) || wordle.getWord().equals(guess.toUpperCase()))hasWon=true;
            System.out.println(wordle.getGuessed());
            tries++;
        }
        
        if(hasWon)System.out.println("Great job!");
        else System.out.println("Better luck next time!");
    }
    
}