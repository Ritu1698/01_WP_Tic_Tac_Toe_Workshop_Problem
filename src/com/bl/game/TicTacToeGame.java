package com.bl.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final int HEAD = 1;

    public enum Player {USER, COMPUTER}

    ;

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
    public static boolean checkUserMove(char[] board, int userPosition, char playerValue) {
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
    private static Player whoStarts() {
        Random randomValue = new Random();
        int tossValue = randomValue.nextInt(2);
        String whoStartName = (tossValue == HEAD) ? "User" : "Computer";
        System.out.println("Player Fist Chance:- " + whoStartName);
        return (tossValue == HEAD) ? Player.USER : Player.COMPUTER;
    }

    //Our main function
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toe Workshop Problem");
        int playerChances = 1;
        Scanner userInput = new Scanner(System.in);
        char[] boardValues = makeBoard();
        Player player = whoStarts();
        System.out.println("Please Choose X or 0");
        char userValue = userInput.next().charAt(0);
        char playerValue = playerChoosesXor0(userValue);
        while (playerChances < 10) {
            System.out.println("Please Choose the position to make move");
            int userPosition = userInput.nextInt();
            boolean positionFreeCheck = isPositionFree(boardValues, userPosition);
            System.out.println(positionFreeCheck);
            boolean checkIfValidMove = checkUserMove(boardValues, userPosition, playerValue);
            String validityResult = checkIfValidMove ? "Valid move" : "Invalid move";
            System.out.println(validityResult);
            displayBoard(boardValues);
            player = (player == Player.USER) ? Player.COMPUTER : Player.USER;
            String currentPlayer = (player == Player.USER) ? "User" : "Computer";
            System.out.println("Current Player:- " + currentPlayer);
            playerValue = (playerValue == 'X') ? '0' : 'X';
            playerChances++;
        }
    }
}
