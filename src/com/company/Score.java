package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Score {

    public int getScore(String difficulty, int guesses){

        int scoreTotal = 0, multiplier = 0;

        if(difficulty.equals("easy")){
            multiplier = 1;
        }
        else if(difficulty.equals("normal")){
            multiplier = 2;
        }
        else if(difficulty.equals("hard")){
            multiplier = 3;
        }

        scoreTotal = multiplier * 1500 - guesses * 100;

        return scoreTotal;
    }

    public void record(String name, int playerScore){

        File scoreFile = new File("C:\\GenSpark\\TeamProject\\GitFork\\Team-Project\\src\\score.txt");
        boolean nan = false;
        String temporary = "";
        int score = 0;

        try{
            Scanner writeScore = new Scanner(scoreFile);
            FileWriter fw = new FileWriter(scoreFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(name + " " + playerScore);
            System.out.println("This is a test");


        }catch (Exception scoreWrite){
            System.out.println("There was a problem writing the score.");
        }

        //return scoreFile;
    }
    public ArrayList<String> scoreBoard(){

        File scoreFile = new File("C:\\GenSpark\\TeamProject\\GitFork\\Team-Project\\src\\score.txt");
        ArrayList<String> board = new ArrayList<>();

        try{
            Scanner writeScore = new Scanner(scoreFile);
            //System.out.println("This is a test");
            while(writeScore.hasNextLine()){
                //System.out.println(writeScore.nextLine());
                board.add(writeScore.nextLine());
            }

        }catch (Exception scoreWrite){
            System.out.println("There was a problem writing the score.");
        }

        return board;

    }



}
