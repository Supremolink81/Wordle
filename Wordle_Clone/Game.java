import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
    private static ArrayList<String> words = new ArrayList<String>();
    /**
     * Cannot be instantiated as it is the driver
     */
    private Game(){}
    
    public static void main(String[] args){
        
        loadWords("words.txt");
        Scanner sc = new Scanner(System.in);
        Word wordle = new Word(words.get( (int) (Math.random() * words.size()) ));
        String guess;
        
        System.out.println("#: Wrong letter wrong place");
        System.out.println("!: Right letter wrong place");
        System.out.println("*: Right letter right place\n");
        
        while(tries<6 && !hasWon){
            System.out.println("Enter guess: ");
            guess = sc.nextLine();
            if(words.indexOf(guess) == -1){
                System.out.println("Invalid word, try again!");
                continue;
            }
            wordle.makeGuess(guess);
            System.out.println();
            if(wordle.getGuessed().equals(wordle.getWord()) || wordle.getWord().equals(guess.toUpperCase()))hasWon=true;
            System.out.println("Letters in word in order: "+wordle.getGuessed());
            System.out.println("Guesses left: "+(6-tries));
            tries++;
        }
        
        System.out.println("The word was "+wordle.getWord());
        if(hasWon)System.out.println("Great job!");
        else System.out.println("Better luck next time!");
    }
    
    public static void loadWords(String filename){
        File wordfile = new File(filename);
        try{
            Scanner fileScanner = new Scanner(wordfile);
            while(fileScanner.hasNext()){
                String w =  fileScanner.nextLine();
                if(w.length() == 5 && !Character.isUpperCase(w.charAt(0))){
                    words.add(w);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
}