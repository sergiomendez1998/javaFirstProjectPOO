package javapoo.tictactoe;

public class GameOver {
public static Boolean HorizontalWin(char[][] gameBoard) {
    if(gameBoard[0][0] == 'X'&& gameBoard[0][2] == 'X' && gameBoard [0][4] == 'X' ){
        System.out.println("Congrats, the Player Won");
        return true;
    }
    if(gameBoard[0][0] == 'O'&& gameBoard[0][2] == 'O' && gameBoard [0][4] == 'O' ){
       System.out.println("Congrats, the Computer Won");
        return true;
    }
    if(gameBoard[1][0] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [1][4] == 'X' ){
        System.out.println("Congrats, the Player Won");
        return true;
    }
    if(gameBoard[1][0] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [1][4] == 'O' ){
      System.out.println("Congrats, the Computer Won");
        return true;
    }
    if(gameBoard[2][0] == 'X'&& gameBoard[2][2] == 'X' && gameBoard [2][4] == 'X' ){
        System.out.println("Congrats, the Player Won");
        return true;
    }
    if(gameBoard[2][0] == 'O'&& gameBoard[2][2] == 'O' && gameBoard [2][4] == 'O' ) {
       System.out.println("Congrats, the Computer Won");
        return true;
    }
    return false;
    }

    private static int playerScoreWinnerAux = 0;
    private static int playerScoreLoserAux = 0;
    public static Boolean VerticalWinner(char[][] gameBoard) {
     if(gameBoard[0][0] == 'X'&& gameBoard[1][0] == 'X' && gameBoard [2][0] == 'X' ){
           System.out.println("Congrats, the Player Won");
            return true;
        }
        if(gameBoard[0][0] == 'O'&& gameBoard[1][0] == 'O' && gameBoard [2][0] == 'O' ){
          System.out.println("Congrats, the Computer Won");
            return true;
        }

        if(gameBoard[0][2] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [2][2] == 'X' ){
           System.out.println("Congrats, the Player Won");
            return true;
        }
        if(gameBoard[0][2] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [2][2] == 'O' ){
            System.out.println("Congrats, the Computer Won");
            return true;
        }

        if(gameBoard[0][4] == 'X'&& gameBoard[1][4] == 'X' && gameBoard [2][4] == 'X' ){
            System.out.println("Congrats, the Player Won");
            return true;
        }
        if(gameBoard[0][4] == 'O'&& gameBoard[1][4] == 'O' && gameBoard [2][4] == 'O' ){
           System.out.println("Congrats, the Computer Won");
            return true;
        }
    return false;
    }

    public static Boolean DiagonalWinner(char[][] gameBoard) {
        if(gameBoard[0][0] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [2][4] == 'X' ){
            return true;
        }
        if(gameBoard[0][0] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [2][4] == 'O' ){

            return true;
        }
        if(gameBoard[0][4] == 'X'&& gameBoard[1][2] == 'X' && gameBoard [2][0] == 'X' ){

            return true;
        }
        if(gameBoard[0][4] == 'O'&& gameBoard[1][2] == 'O' && gameBoard [2][0] == 'O' ){

            return true;
        }
        return false;
    }

    public static boolean isTie(char[][] gameBoard){
      if(gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] !='_'&&
            gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' '){
            System.out.println("We have a time");
            return true;
        }
        return false;
    }

    public static Boolean isGameOver(char[][] gameBoard) {
        if(HorizontalWin(gameBoard) || VerticalWinner(gameBoard) || DiagonalWinner(gameBoard)){
            return true;
        }
        return false;
    }
}
