import java.util.Arrays;
/**
 * 
 * Class created to simplify guessing words through
 * methods and stored variables
 * 
 */
public class Word{
    
    private String word;
    private char[] guess;
    
    /**
     * 
     * Makes a new word to guess and sets it to all uppercase to prevent mismatching
     * @param wordP: initializes the word to guess
     * 
     */
    public Word(String wordP){
        word = wordP;
        word = word.toUpperCase();
        guess=new char[word.length()];
        for(int i=0;i<word.length();i++)guess[i]='_';
    }
    
    
    /**
     * 
     * Makes a guess and changes the contents of guess accordingly
     * @param guessWord: the word being guessed
     * 
     */
    public void makeGuess(String guessWord){
        guessWord=guessWord.toUpperCase();
        System.out.print("Results: ");
        for(byte i=0;i<guessWord.length();i++){
            
            char guessChar=guessWord.charAt(i);
            char wordChar;
            if(i<word.length())wordChar = word.charAt(i);
            else wordChar='(';
            if(guessChar==wordChar){
                guess[i]=guessChar;
                System.out.print(guessChar+"* ");
            }else if(guessWord.indexOf(guessChar) != -1 && word.indexOf(guessChar) != -1)System.out.print(guessChar+"! ");
            else System.out.print(guessChar+"# ");
        }
    }
    
    /**
     * 
     * Getter method for word
     * 
     */
    
    public String getWord(){
        return word;
    }
    
    /**
     * 
     * Gets all the letters guessed correctly 
     * and in the correct position
     * 
     */
    
    public String getGuessed(){
        String guessWord="";
        for(byte i=0;i<guess.length;i++)if(guess[i]!='_')guessWord+=guess[i];
        return guessWord;
    }
    
}