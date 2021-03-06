package com.bl.game;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final int HEAD = 1;
    public static int userPositionReference;

    public enum Player {USER, COMPUTER}

    //Function to create the board
    public static char[] makeBoard() {
        char[] ourBoardValues = new char[10];
        for (int boardPosition = 1; boardPosition < ourBoardValues.length; boardPosition++) {
            ourBoardValues[boardPosition] = ' ';
        }
        return ourBoardValues;
    }

    //Function to assign player value
    public static char playerChoosesXor0(char userValue) {
        char playerValue = userValue;
        return playerValue;
    }

    //Displaying Board Values
    public static void displayBoard(char[] board) {
        System.out.println("The board currently:-");
        System.out.println("\n" + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    //Check Valid Move Or Not
    public static boolean checkUserMoveIfValidMakeMove(char[] board, int userPosition, char playerValue) {
        if (userPosition > 0 && userPosition < board.length && board[userPosition] == ' ') {
            board[userPosition] = playerValue;
            return true;
        } else
            return false;
    }

    //Check Position is Free Or Not
    public static boolean isPositionFree(char[] board, int userPosition) {
        if (board[userPosition] == ' ')
            return true;
        else return false;
    }

    //Check Who Starts First
    public static Player whoStarts() {
        Random randomValue = new Random();
        int tossValue = randomValue.nextInt(2);
        String whoStartName = (tossValue == HEAD) ? "User" : "Computer";
        System.out.println("Player Fist Chance:- " + whoStartName);
        return (tossValue == HEAD) ? Player.USER : Player.COMPUTER;
    }

    //Check For Winner
    public static boolean checkIfWinner(char[] board, char playerValue) {
        if ((board[1] == playerValue && board[2] == playerValue && board[3] == playerValue)
                || (board[4] == playerValue && board[5] == playerValue && board[6] == playerValue)
                || (board[7] == playerValue && board[8] == playerValue && board[9] == playerValue)
                || (board[1] == playerValue && board[5] == playerValue && board[9] == playerValue)
                || (board[3] == playerValue && board[5] == playerValue && board[7] == playerValue)
                || (board[1] == playerValue && board[4] == playerValue && board[7] == playerValue)
                || (board[2] == playerValue && board[5] == playerValue && board[8] == playerValue)
                || (board[3] == playerValue && board[6] == playerValue && board[9] == playerValue))
            return true;
        else return false;
    }

    //Logic Behind Computer Winning Move
    public static int computerWinningMoveLogic(char[] board, char playerValue) {
        for (int boardPosition = 1; boardPosition < board.length; boardPosition++) {
            char[] copyOfBoard = board.clone();
            if (isPositionFree(board, boardPosition)) {
                checkUserMoveIfValidMakeMove(copyOfBoard, boardPosition, playerValue);
                if (checkIfWinner(copyOfBoard, playerValue))
                    return boardPosition;
            }
        }
        return 0;
    }

    //Logic Behind Computer Blocking Move
    public static int computerBlockingMoveLogic(char[] board, char playerValue) {
        char userValue = (playerValue == 'X') ? '0' : 'X';
        int userWinningPosition = computerWinningMoveLogic(board, userValue);
        return (userWinningPosition > 0) ? userWinningPosition : 0;
    }

    //Logic Behind Computer Corner Cases
    public static int computerCornerCaseLogic(char[] board) {
        if (board[1] == ' ')
            return 1;
        else if (board[3] == ' ')
            return 3;
        else if (board[7] == ' ')
            return 7;
        else if (board[9] == ' ')
            return 9;
        else return 0;
    }

    //Logic Behind Computer Center & Side Cases
    public static int computerCenterAndSideCaseLogic(char[] board) {
        if (board[5] == ' ')
            return 5;
        else if (board[2] == ' ')
            return 2;
        else if (board[4] == ' ')
            return 4;
        else if (board[6] == ' ')
            return 6;
        else return 8;
    }

    //What value computer chooses
    public static char computerChooseXor0() {
        Random randomValue = new Random();
        int randomResult = randomValue.nextInt(2);
        char computerValue = (randomResult == 0) ? 'X' : '0';
        return computerValue;
    }

    //Our main function
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int gameAgain = 1;
        while (gameAgain == 1) {
            System.out.println("Welcome to tic tac toe Workshop Problem");
            int playerChances = 1, userPosition, computerPosition;
            boolean checkIfValidMove;
            char playerValue;
            char[] boardValues = makeBoard();
            Player player = whoStarts();
            String currentPlayer = (player == Player.USER) ? "User" : "Computer";
            if (currentPlayer == "User") {
                System.out.println("Please Choose X or 0");
                char userValue = userInput.next().charAt(0);
                playerValue = playerChoosesXor0(userValue);
            } else playerValue = computerChooseXor0();
            while (playerChances < 10) {
                if (currentPlayer == "User") {
                    System.out.println("Please Choose the position to make move");
                    userPosition = userInput.nextInt();
                    boolean positionFreeCheck = isPositionFree(boardValues, userPosition);
                    if (positionFreeCheck)
                        System.out.println("Free Position!");
                    checkIfValidMove = checkUserMoveIfValidMakeMove(boardValues, userPosition, playerValue);
                    String validityResult = checkIfValidMove ? "Valid move" : "Invalid move";
                    System.out.println(validityResult);
                } else {
                    computerPosition = computerWinningMoveLogic(boardValues, playerValue);
                    if (computerPosition == 0)
                        computerPosition = computerBlockingMoveLogic(boardValues, playerValue);
                    if (computerPosition == 0)
                        computerPosition = computerCornerCaseLogic(boardValues);
                    if (computerPosition == 0)
                        computerPosition = computerCenterAndSideCaseLogic(boardValues);
                    checkIfValidMove = checkUserMoveIfValidMakeMove(boardValues, computerPosition, playerValue);
                }
                displayBoard(boardValues);
                if (playerChances == 9) {
                    System.out.println("Tied!!!!!");
                    break;
                }
                boolean winningResults = checkIfWinner(boardValues, playerValue);
                if (winningResults) {
                    if (currentPlayer == "User")
                        System.out.println("You Won!!!!!");
                    else System.out.println("You Lost!!!!!");
                    break;
                }
                player = (player == Player.USER) ? Player.COMPUTER : Player.USER;
                currentPlayer = (player == Player.USER) ? "User" : "Computer";
                System.out.println("Current Player:- " + currentPlayer);
                playerValue = (playerValue == 'X') ? '0' : 'X';
                playerChances++;
            }
            System.out.println("GAME OVER!!!!\nENTER 1 to Play Again\nENTER 0 to Exit");
            gameAgain = userInput.nextInt();
        }
    }
}
