package javapoo.menu.players;


import lombok.NoArgsConstructor;
import java.util.Scanner;

@NoArgsConstructor
public class HumanPlayer extends Player{
private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name, String nickname, int scoreLoser, int scoreWinner) {
        super(name, nickname, scoreLoser, scoreWinner);
    }

    @Override
    public void CreatePlayer(Player player) {
        playersList.add(player);
        System.out.println("Human player created");
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
     Player player = getPlayerByName(PlayerName);
     if (player != null){
         System.out.println("Enter new name: ");
         String newName = scanner.nextLine();
         System.out.println("Enter new nickname: ");
         String newNickname = scanner.nextLine();
         player.setName(newName);
         player.setNickname(newNickname);
         System.out.println("changes were made successfully");
     }else{
         System.out.println("Player does not exist in the list of players");
     }
    }

    @Override
    public int getRollDiceTimes() {
        return 2;
    }
}
