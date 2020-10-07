package com.bl.game;

import java.util.Scanner;

public class TicTacToeGame {

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
    public static boolean checkUserMove(char[] board, int userPosition) {
        if (userPosition > 0 && userPosition < board.length && board[userPosition] == ' ')
            return true;
        else
            return false;
    }

    //Our main function
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toe Workshop Problem");
        char[] boardValues = makeBoard();
        System.out.println("Please Choose X or 0");
        Scanner userInput = new Scanner(System.in);
        char userValue = userInput.next().charAt(0);
        char playerValue = playerChoosesXor0(userValue);
        char computerValue = (playerValue == 'X') ? '0' : 'X';
        System.out.println("Value chosen by Player & Computer are :- " + playerValue + ", " + computerValue);
        System.out.println("Please Choose the position to make move");
        int userPosition = userInput.nextInt();
        boolean checkIfValidMove = checkUserMove(boardValues, userPosition);
        userInput.close();
        String validityResult = checkIfValidMove ? "Valid move" : "Invalid move";
        System.out.println(validityResult);
        boardValues[userPosition] = checkIfValidMove ? playerValue : ' ';
        displayBoard(boardValues);

    }
}
