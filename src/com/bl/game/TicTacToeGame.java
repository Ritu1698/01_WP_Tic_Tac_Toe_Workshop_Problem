package com.bl.game;

public class TicTacToeGame {

    public static char [] makeBoard(){

        char [] ourBoardValues = new char[10];

        for(int i=1;i<10;i++){
            ourBoardValues[i] = ' ';
        }

        return ourBoardValues;
    }

    public static void main (String[] args){

        System.out.println("Welcome to tic tac toe Workshop Problem");
        char [] boardValues = makeBoard();

    }
}
