package javapoo.menu.crudplayers;

import javapoo.menu.Menu;
import javapoo.menu.players.HumanPlayer;
import javapoo.menu.players.IAPlayer;
import javapoo.menu.players.Player;

import java.util.Scanner;

public class CRUDplayer {

   static Player HumanPlayer = new HumanPlayer();
   static Player IAPlayer = new IAPlayer();
  static private Scanner scanner = new Scanner(System.in);
    public static void createHumanPlayer() {
        System.out.println("\n");
        System.out.println("Enter the name of the player: ");
        String name = scanner.nextLine();
        System.out.println("Enter a nickname of the player: ");
        String nickname = scanner.nextLine();
        Player  NewHumanPlayer = new HumanPlayer(name, nickname, 0, 0);
        HumanPlayer.CreatePlayer(NewHumanPlayer);
    }

    public static void createIAPlayer() {
        Player iaPlayer1 = new IAPlayer("IA1", "Noxus", 0, 0);
        Player iaPlayer2 = new IAPlayer("IA2", "Celestial Dragon", 0, 0);
        IAPlayer.CreatePlayer(iaPlayer1);
        IAPlayer.CreatePlayer(iaPlayer2);
    }

    public static void deleteHumanPlayer() {
        System.out.println("\n");
        printAllPlayers();
        System.out.println("\n");
        System.out.println("Enter the name of the player: ");
        String name = scanner.nextLine();
        HumanPlayer.deletePlayer(name);
    }

    public static void updatePlayer() {
          System.out.println("\n");
          printAllPlayers();
          System.out.println("\n");
          System.out.println("Enter the name of the player: ");
          String name = scanner.nextLine();
          HumanPlayer.updatePlayer(name);
    }

   public static  void printAllPlayers(){
         System.out.println("List of players: ");
         for (Player player : Player.playersList) {
             System.out.println("Name: " + player.getName() + " Nickname: " + player.getNickname());
            }
         }
   public static void updatePlayerPoints(String name,int scoreWinner, int scoreLoser) {
       Player player = HumanPlayer.getPlayerByName(name);
       if (player != null) {
           player.setScoreWinner(scoreWinner+player.getScoreWinner());
           player.setScoreLoser(scoreLoser+player.getScoreLoser());
       }
   }
}
