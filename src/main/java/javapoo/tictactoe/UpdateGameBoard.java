package javapoo.tictactoe;

public class UpdateGameBoard {
    public static void changeBoard(int position, int player, char[][] gameBoard) {

        char character;
        if(player == 1) {
            character = 'X';
        }else{
            character = 'O';
        }
       switch (position){

            case 1:
                gameBoard[0][0] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                 CreateGameBoard.printGameBoard(gameBoard);
                break;
            default:
                break;

        }
    }

}
