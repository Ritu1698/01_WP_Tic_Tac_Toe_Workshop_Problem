package com.bl.game;

public class TicTacToeGame {

    public static void main (String[] args){

        char [] boardValues = makeBoard();
    }

    public static char [] makeBoard(){

        char [] ourBoardValues = new char[10];

        for(int i=0;i<10;i++){
            ourBoardValues[i] = ' ';
        }

        return ourBoardValues;
    }
}
