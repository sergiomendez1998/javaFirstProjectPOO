package javapoo.menu.statistics;

import javapoo.menu.players.IAPlayer;
import javapoo.menu.players.Player;

public class StatisticsGame {
   public static void showPlayersStatistics() {
       for (Player p : Player.playersList) {
              System.out.print("Name: " + p.getName()
                      +" "+"Nickname: " + p.getNickname()
                      +" "+"Score Loser: " + p.getScoreLoser()
                      +" "+"Score Winner: " + p.getScoreWinner()+"\n");
       }
   }
}
