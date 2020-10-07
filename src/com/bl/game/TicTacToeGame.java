package com.bl.game;

import java.util.Scanner;

public class TicTacToeGame {

    public static char [] makeBoard(){
        char [] ourBoardValues = new char[10];
        for(int boardPosition=1;boardPosition<ourBoardValues.length;boardPosition++){
            ourBoardValues[boardPosition] = ' ';
        }
        return ourBoardValues;
    }  //Function to create the board

    public static char playerChoosesXor0(char userValue){
       char playerValue = userValue;
        return playerValue;
    } //Function to assign player value

    public  static void  displayBoard(char [] ourBoard){
        System.out.println("The board currently:-");
        System.out.println("\n"+ourBoard[1]+" | "+ourBoard[2]+ " | "+ourBoard[3]);
        System.out.println("----------");
        System.out.println(ourBoard[4]+" | "+ourBoard[5]+ " | "+ourBoard[6]);
        System.out.println("----------");
        System.out.println(ourBoard[7]+" | "+ourBoard[8]+ " | "+ourBoard[9]);
    } //Displaying Board Values

    public static void main(String[] args){
        System.out.println("Welcome to tic tac toe Workshop Problem");
        char [] boardValues = makeBoard();

        System.out.println("Please Choose X or 0");
        Scanner sc = new Scanner(System.in);
        char userValue = sc.next().charAt(0);
        sc.close();

        char playerValue = playerChoosesXor0(userValue);
        char computerValue = (playerValue == 'X') ? '0' : 'X';
        System.out.println("Value chosen by Player & Computer are :- "+playerValue+", "+computerValue);

        displayBoard(boardValues);
    } //Our main function
}
