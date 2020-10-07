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

    public static char playerChoosesXor0(){
        System.out.println("Please Choose X or 0");
        Scanner sc = new Scanner(System.in);
        char playerValue = sc.next().charAt(0);
        sc.close();
        return playerValue;
    } //Function to assign player value

    public static void main (String[] args){
        System.out.println("Welcome to tic tac toe Workshop Problem");
        char [] boardValues = makeBoard();
        char playerValue = playerChoosesXor0();
        char computerValue;
        if (playerValue == 'X')
            computerValue = '0';
        else  computerValue = 'X';
        System.out.println("Value chosen by Player & Computer are :- "+playerValue+", "+computerValue);
    } //Our main function
}
