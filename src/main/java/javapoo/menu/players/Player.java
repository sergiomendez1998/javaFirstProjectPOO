package javapoo.menu.players;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public abstract class Player {


    private String name;
    private String nickname;
    private int scoreLoser;
    private int scoreWinner;

    public Player(String name, String nickname, int scoreLoser, int scoreWinner) {
        this.name = name;
        this.nickname = nickname;
        this.scoreLoser = scoreLoser;
        this.scoreWinner = scoreWinner;
    }

    public static Set<Player> playersList = new HashSet<>();
    abstract  public void CreatePlayer(Player player);
    abstract public Player getPlayerByName(String name);
    abstract public void deletePlayer(String playerName);
    abstract public void updatePlayer(String PlayerName);
    abstract public int getRollDiceTimes();

      @Override
    public String toString() {
        return "Player statistics{" +
                "name=' " + name + '\'' +
                ", nickname=' " + nickname + '\'' +
                ", scoreLoser= " + scoreLoser +
                ", scoreWinner= " + scoreWinner +
                '}';
    }
}
