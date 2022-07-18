package javapoo.tictactoe;

public class PlayTTToe {

      static  char [][] gameBoard = {
                  { '_' ,  '|', '_', '|', '_' },
                  { '_' ,  '|', '_', '|', '_' },
                  { ' ' ,  '|', '_', '|',' ' }
        };

      public static void play(){
           System.out.println("");
           System.out.println(" Tic Tac Toe Game!! ");
           CreateGameBoard.printGameBoard(gameBoard);
           TTToeTurn.selectPlayers();
           System.out.println("");
           TTToeTurn.startGame();
      }


}
