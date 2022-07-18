package javapoo.hangedman;


import javapoo.menu.crudplayers.CRUDplayer;
import javapoo.menu.players.HumanPlayer;
import javapoo.menu.players.IAPlayer;
import javapoo.menu.players.Player;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
public class HangManTurn {

    private static char[] secretWordCreated;
    private static String secretWord;
    private static int tries = 8;
    private static boolean gameOver = false;

    static Player HumanPlayer = new HumanPlayer();
    static Player IAPlayer = new IAPlayer();
    private static int scoreLoserUax = 0;
    private static int scoreWinnerUax = 0;

   static  Scanner scanner = new Scanner(System.in);
    private static char[] getSecretWordHyphenated(String secretWord) {
        int lengthOfSecretWord = secretWord.length();
        char[] secretWordHyphenatedAux = new char[lengthOfSecretWord];
        for (int i = 0; i < secretWordHyphenatedAux.length; i++) {
            secretWordHyphenatedAux[i] = '_';
        }
        return secretWordHyphenatedAux;
    }

   public static void playerCreatedSecretWord() {
        secretWord = createSecretWord();
        setSecretWordCreated(getSecretWordHyphenated(secretWord));
    }
    public static void play(String playerName) {
        do{
            playerCreatedSecretWord();
            System.out.println("Tries left: " + tries);
            System.out.println(getSecretWordCreated());
            System.out.println("enter a letter: ");
            char letter = scanner.nextLine().charAt(0);
            boolean guessedLetter=false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    secretWordCreated[i] = letter;
                    guessedLetter = true;
                }
            }
            if (!guessedLetter) {
                System.out.println("Letter not found in secret word");
                 --tries;

                if (tries == 0) {
                    System.out.println("You lost");
                    scoreWinnerUax++;
                    CRUDplayer.updatePlayerPoints(playerName, scoreWinnerUax, scoreLoserUax);
                    gameOver=true;
                }
            }else{
                gameOver = !isSecretWordHyphenated(getSecretWordCreated());
                if(gameOver){
                      scoreWinnerUax++;
                     CRUDplayer.updatePlayerPoints(playerName, scoreWinnerUax, scoreLoserUax);
                     System.out.println("You win");
                }
            }
        }while(!gameOver);

    }

    public static String createSecretWord() {
        System.out.println("Enter the secret word: ");
        String secretWordEntered = scanner.nextLine();
        return secretWordEntered;
    }
    private static boolean isSecretWordHyphenated(char[] array) {
        for(char letter:array) {
            if(letter == '_') return true;
        }
        return false;
    }

    public static char[] getSecretWordCreated() {
        return secretWordCreated;
    }

    public static void setSecretWordCreated(char[] secretWordCreated) {
        HangManTurn.secretWordCreated = secretWordCreated;
    }

    public static List<Player> IAPlayersList() {
        List<Player> IAPlayersList = Player.playersList.stream()
                .filter(player -> player.getName().contains("IA"))
                .collect(Collectors.toList());
        return IAPlayersList;
    }

}
