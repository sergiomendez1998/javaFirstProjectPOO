package javapoo.menu.players;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;


@Getter
@NoArgsConstructor
public class IAPlayer extends Player{


    public IAPlayer(String name, String nickname, int scoreLoser, int scoreWinner) {
        super(name, nickname, scoreLoser, scoreWinner);
    }
    @Override
    public void CreatePlayer(Player player) {
                Player.playersList.add(player);
    }

    @Override
    public Player getPlayerByName(String name) {
        Player findPlayer = playersList.stream()
                .filter(player -> name.equalsIgnoreCase(player.getName()))
                .findAny()
                .orElse(null);
        return findPlayer;
    }

    @Override
    public void deletePlayer(String playerName) {
       Player deletePlayer =getPlayerByName(playerName);
     if (deletePlayer != null){
         playersList.remove(deletePlayer);
         System.out.println("Player Deleted " + deletePlayer.getName());
     }else{
          System.out.println("name does not exist in the list of players");
     }
    }

    @Override
    public void updatePlayer(String PlayerName) {
    }

    @Override
    public int getRollDiceTimes() {
        return 2;
    }

}
