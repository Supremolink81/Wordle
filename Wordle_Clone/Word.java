import java.util.Arrays;
/**
 * 
 * Class created to simplify guessing words through
 * methods and stored variables
 * 
 */
public class Word{
    
    private String word;
    private char[][] guess;
    
    /**
     * 
     * Makes a new word to guess and sets it to all uppercase to prevent mismatching
     * @param wordP: initializes the word to guess
     * 
     */
    public Word(String wordP){
        word=wordP;
        word.toUpperCase();
        guess=new char[2][word.length()];
        for(int i=0;i<word.length();i++){
            guess[0][i]='_';
            guess[1][i]=' ';
        }
    }
    
    
    /**
     * 
     * Makes a guess and changes the contents of guess accordingly
     * @param guessWord: the word being guessed
     * 
     */
    public void makeGuess(String guessWord){
        guessWord=guessWord.toUpperCase();
        for(byte i=0;i<guessWord.length();i++){
            
            char guessChar=guessWord.charAt(i);
            char wordChar;
            if(i<word.length())wordChar = word.charAt(i);
            else wordChar='(';
            
            if(guessChar==wordChar){
                byte index = (byte)Arrays.asList(guess[1]).indexOf('!');
                if(index != -1 && guess[0][index]==guessChar){
                    guess[1][index]=' ';
                    guess[0][index]='_';
                }
                guess[0][i]=guessChar;
                guess[1][i]='*';
            }else if(guessWord.indexOf(guessChar) != -1 && word.indexOf(guessChar) != -1){
                guess[0][i]=guessChar;
                guess[1][i]='!';
            }
            
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
        
        for(byte i=0;i<guess[0].length;i++){
            if(guess[1][i]=='*')guessWord+=guess[0][i];
        }
        
        return guessWord;
    }
    
}