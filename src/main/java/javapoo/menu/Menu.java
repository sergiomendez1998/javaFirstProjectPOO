package javapoo.menu;

import javapoo.hangedman.HangManTurn;
import javapoo.menu.crudplayers.CRUDplayer;
import javapoo.menu.players.HumanPlayer;
import javapoo.menu.players.IAPlayer;
import javapoo.menu.players.Player;
import javapoo.menu.statistics.StatisticPlayer;
import javapoo.menu.statistics.StatisticsGame;
import javapoo.tictactoe.PlayTTToe;
import javapoo.utils.Util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    static int choice = 0;

    private static Player HumanPlayer = new HumanPlayer();
    private static Player IAPlayer = new IAPlayer();


    private static Player actualPlayerHuman1 = new HumanPlayer();
    private static Player actualPlayerHuman2 = new HumanPlayer();
    private static Player actualPlayerIA1 = new IAPlayer();

    static int actualHuman1First = 0;
    static int actualHuman2First = 0;
    static int actualIA1First = 0;
    static int playerAmount = 0;

    private static void printMenu() {
        System.out.println("1. Administrate players");
        System.out.println("2. Statistics players");
        System.out.println("3. Statistics game");
        System.out.println("4. Play Tic Tac Toe");
        System.out.println("5. Play Hangman");
        System.out.println("6. Exit");
    }

    private static void printMenuAdmin() {
        System.out.println("1. Add player");
        System.out.println("2. Remove player");
        System.out.println("3. Update player");
        System.out.println("4. Back");
    }

    public static void menu() {
        do {
            printMenu();
            System.out.println("Enter a choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    CRUDplayer.printAllPlayers();
                    System.out.println("\n");
                    System.out.println("Enter name of the player: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("\n");
                    StatisticPlayer.printStatisticsByName(name);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    StatisticsGame.showPlayersStatistics();
                    System.out.println("\n");
                    break;
                case 4:
                    PlayTTToe.play();
                    break;
                case 5:

                    while (playerAmount >= 2) {
                        System.out.println("select Player");
                        System.out.println("1. Human");
                        System.out.println("2. IA");
                        scanner.nextLine();
                        int choicePlayer = scanner.nextInt();
                        hangManChoices(choicePlayer);
                        playerAmount++;
                    }
                    startGame();
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 6);
    }

    private static void menuAdmin() {
        do {
            printMenuAdmin();
            System.out.println("Enter a choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CRUDplayer.createHumanPlayer();
                    break;
                case 2:
                    CRUDplayer.deleteHumanPlayer();
                    break;
                case 3:
                    CRUDplayer.updatePlayer();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);
    }

    public static Player selectHumanPlayer() {
        getListOfHumanPlayers();
        System.out.println("Enter the name of the player: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Player playerFound = Player.playersList.stream().filter(player -> name.equalsIgnoreCase(player.getName())).findAny().orElse(null);
        return playerFound;
    }

    public static Player selectIAPlayer() {
        for (Player player : HangManTurn.IAPlayersList()) {
            System.out.println(player.getName() + " " + player.getNickname());
        }
        System.out.println("Enter the name of the player: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Player playerFound = Player.playersList.stream().filter(player -> name.equalsIgnoreCase(player.getName())).findAny().orElse(null);
        return playerFound;
    }

    private static void getListOfHumanPlayers() {
        Set<String> HumanPlayers = new HashSet<String>();
        for (Player player : Player.playersList) {
            if (player.getName().contains("IA")) {
                System.out.println(" ");
            } else {
                HumanPlayers.add(player.getName());
            }
        }

        for (String player : HumanPlayers) {
            System.out.println(player);
        }
    }

    private static void hangManChoices(int choice) {
        switch (choice) {
            case 1:
                HumanPlayer = selectHumanPlayer();
                actualPlayerHuman1 = HumanPlayer;

                if (actualPlayerIA1 != null) {
                    HumanPlayer = selectHumanPlayer();
                    actualPlayerHuman2 = HumanPlayer;
                }

                break;
            case 2:
                if (actualPlayerHuman2 != null) {
                    IAPlayer = selectIAPlayer();
                    actualPlayerIA1 = IAPlayer;
                } else {
                    System.out.println("the players are already selected");
                }

                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static int highestRollDiceNumber() {
        actualHuman1First = Util.diceHighestNumber(actualPlayerHuman1.getRollDiceTimes(), 0, 20);
        if (actualPlayerHuman2 != null) {
            actualHuman2First = Util.diceHighestNumber(actualPlayerHuman2.getRollDiceTimes(), 0, 20);
        }
        if (actualPlayerIA1 != null) {
            actualIA1First = Util.diceHighestNumber(actualPlayerIA1.getRollDiceTimes(), 0, 20);
        }

        int winner = 0;
        if (actualHuman1First > actualHuman2First) {
            winner = 1;
        } else if (actualHuman1First < actualHuman2First) {
            winner = 2;
        } else {
            winner = 3;
        }
        return winner;

    }

    private static void startGame() {
        int winner = highestRollDiceNumber();
        switch (winner) {
            case 1:
                System.out.println("do you want to guess the word 1.yes 2.no");
                scanner.nextLine();
                choice = scanner.nextInt();
                choiceSelectedByWinnerPlayer1(choice);
                break;
            case 2:
                System.out.println("do you want to guess the word 1.yes 2.no");
                scanner.nextLine();
                choice = scanner.nextInt();
                choiceSelectedByWinnerPlayer2(choice);
                break;
            case 3:
                System.out.println("do you want to guess the word 1.yes 2.no");
                scanner.nextLine();
                choice = scanner.nextInt();
                choiceSelectedByWinnerPlayer3(choice);
                break;
        }
    }

    private static void choiceSelectedByWinnerPlayer1(int choiceWinner) {
        if (choiceWinner == 1) {
            if (HangManTurn.createSecretWord() == null) {
                System.out.println("player lowest highestRollDiceNumber creating secret word");
                HangManTurn.createSecretWord();
                HangManTurn.play(actualPlayerHuman1.getName());
            } else {
                HangManTurn.play(actualPlayerHuman1.getName());
            }

        } else if (choiceWinner == 2) {
            HangManTurn.createSecretWord();
            if (actualPlayerHuman1 != null) {
                HangManTurn.play(actualPlayerHuman2.getName());
            } else {
                HangManTurn.play(actualPlayerIA1.getName());
            }

        }
    }

    private static void choiceSelectedByWinnerPlayer3(int choiceWinner3) {
        if (choiceWinner3 == 1) {
            if (HangManTurn.createSecretWord() == null) {
                System.out.println("player lowest highestRollDiceNumber creating secret word");
                HangManTurn.createSecretWord();
                HangManTurn.play(actualPlayerIA1.getName());
            } else {
                HangManTurn.play(actualPlayerIA1.getName());
            }

        } else if (choiceWinner3 == 2) {
            HangManTurn.createSecretWord();
            if (actualPlayerHuman1 != null) {
                HangManTurn.play(actualPlayerHuman1.getName());
            } else {
                HangManTurn.play(actualPlayerHuman2.getName());
            }

        }
    }

    private static void choiceSelectedByWinnerPlayer2(int choiceWinner2) {
        if (choiceWinner2 == 1) {
            if (HangManTurn.createSecretWord() == null) {
                System.out.println("player lowest highestRollDiceNumber creating secret word");
                HangManTurn.createSecretWord();
                HangManTurn.play(actualPlayerHuman2.getName());
            } else {
                HangManTurn.play(actualPlayerHuman2.getName());
            }

        } else if (choiceWinner2 == 2) {
            HangManTurn.createSecretWord();
            if (actualPlayerHuman1 != null) {
                HangManTurn.play(actualPlayerHuman1.getName());
            } else {
                HangManTurn.play(actualPlayerIA1.getName());
            }

        }
    }
}


