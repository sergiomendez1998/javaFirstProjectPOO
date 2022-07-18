package javapoo.tictactoe;

import javapoo.menu.Menu;
import javapoo.menu.players.HumanPlayer;
import javapoo.menu.players.IAPlayer;
import javapoo.menu.players.Player;
import javapoo.utils.Util;

import java.util.Random;
import java.util.Scanner;

public class TTToeTurn {

    static Player actualTTToeHumanPlayer = new HumanPlayer();
    static Player actualTToeIAPlayer = new IAPlayer();
    static Scanner input = new Scanner(System.in);
     static   boolean gameOver = false;
    public static boolean isValidMove(int move, char[][] gameBoard) {
        isValidMoveRow0(move, gameBoard);
        isValidMoveRow1(move, gameBoard);
        isValidMoveRow2(move, gameBoard);
        return false;
    }

    public static void selectPlayers() {
        actualTTToeHumanPlayer = Menu.selectHumanPlayer();
        actualTToeIAPlayer = Menu.selectIAPlayer();
    }

    public static int getFirstPlayerRandomMove() {
        int firstPlayerRandomMove = Util.generateRandomNumber(1, 2);
        switch (firstPlayerRandomMove) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    public static void startGame() {
        switch (getFirstPlayerRandomMove()) {
               //payer IA HumanPlayer First
            case 1:
                while (!gameOver) {
                 playerIsMoving(PlayTTToe.gameBoard,1);
                 gameOver = GameOver.isGameOver(PlayTTToe.gameBoard);
                if (gameOver) {
                    break;
                }
                computerIsMoving(PlayTTToe.gameBoard,2);
                gameOver = GameOver.isGameOver(PlayTTToe.gameBoard);
                if (gameOver) {
                    break;
                }
            }
                break;
                //payer IA first
            case 2:
                 while (!gameOver) {
                 computerIsMoving(PlayTTToe.gameBoard,1);
                 gameOver = GameOver.isGameOver(PlayTTToe.gameBoard);
                if (gameOver) {
                    break;
                }
                playerIsMoving(PlayTTToe.gameBoard,2);
                gameOver = GameOver.isGameOver(PlayTTToe.gameBoard);
                if (gameOver) {
                    break;
                }
            }
                break;
            default:
                break;
        }

    }

    public static boolean isValidMoveRow0(int move, char[][] gameBoard) {
        switch (move) {
            case 1:
                if (gameBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static boolean isValidMoveRow1(int move, char[][] gameBoard) {
        switch (move) {
            case 4:
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static boolean isValidMoveRow2(int move, char[][] gameBoard) {
        switch (move) {
            case 7:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[2][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static void computerIsMoving(char[][] gameBoard, int playerMoving) {
        Random rand = new Random();
        int move = rand.nextInt(9) + 1;
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            move = rand.nextInt(9) + 1;
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Computer has already moved at position " + move);
        UpdateGameBoard.changeBoard(move, playerMoving, gameBoard);
    }

    public static void playerIsMoving(char[][] gameBoard,int playerMoving) {
        System.out.println("Please make a move. Numbers available (1-9)");
        int move = input.nextInt();
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            System.out.println("Sorry! Invalid Move. Try again");
            move = input.nextInt();
            result = isValidMove(move, gameBoard);
        }
    }
}