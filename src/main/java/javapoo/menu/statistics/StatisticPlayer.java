package javapoo.menu.statistics;

import javapoo.menu.players.Player;

public class StatisticPlayer {

    public static void printStatisticsByName(String namePlayer) {
      Player findPlayer = Player.playersList
                .stream()
                .filter(player -> namePlayer.equalsIgnoreCase(player.getName())).
                findFirst()
                .orElse(null);
        if (findPlayer != null){
             printInformationPlayer(findPlayer);
        }else{
            System.out.println("Player does not exist in the list of players");
        }
    }

    private static void printInformationPlayer(Player player) {
        System.out.println("Name: " + player.getName());
        System.out.println("Nickname: " + player.getNickname());
        System.out.println("Score Loser: " + player.getScoreLoser());
        System.out.println("Score Winner: " + player.getScoreWinner());
    }


}
