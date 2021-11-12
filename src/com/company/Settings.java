package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Settings {

    public String pickAWord(String a, String b) {
        Random rNum = new Random();
        int lineNum = 0, randomPick = 0, currentLine = 0;
        String thePick = "", temp = "";
        ArrayList<String> difOption = new ArrayList<>();

        File gameFile = new File("C:\\GenSpark\\TeamProject\\GitFork\\Team-Project\\src\\" + a + ".txt");

        try {
            Scanner myReader = new Scanner(gameFile);
            while (myReader.hasNextLine()){
                temp = myReader.nextLine();
                if(b.equals("easy")){
                    if(temp.length() < 5){
                        difOption.add(temp);
                    }
                }
                else if(b.equals("normal")){
                    if(temp.length() < 7 && temp.length() > 4){
                        difOption.add(temp);
                    }
                }
                else if(b.equals("hard")){
                    if(temp.length() > 6){
                        difOption.add(temp);
                    }
                }

                //myReader.nextLine();
            }
        }catch (Exception d){
            System.out.println("Read error 1");
        }

        randomPick = rNum.nextInt(difOption.size());

        /*
        try {
            Scanner myReader = new Scanner(gameFile);
            while (myReader.hasNextLine()){
                currentLine++;
                if(currentLine == randomPick){
                    thePick = myReader.nextLine();

                }
                myReader.nextLine();
            }
        }catch (Exception e){
            System.out.println("Read error");
        }
        */
        thePick = difOption.get(randomPick);

        return thePick;

    }

    public ArrayList<String> wordList(String a, String b){

        ArrayList<String> words = new ArrayList<>();
        String temp = "";
        //ArrayList<String> difOption = new ArrayList<>();


        File gameFile = new File("C:\\GenSpark\\TeamProject\\GitFork\\Team-Project\\src\\" + a + ".txt");

        try {
            Scanner myReader = new Scanner(gameFile);
            while (myReader.hasNextLine()){
                temp = myReader.nextLine();
                if(b.equals("easy")){
                    if(temp.length() < 5){
                        words.add(temp);
                    }
                }
                else if(b.equals("normal")){
                    if(temp.length() < 7 && temp.length() > 4){
                        words.add(temp);
                    }
                }
                else if(b.equals("hard")){
                    if(temp.length() > 6){
                        words.add(temp);
                    }
                }

                //myReader.nextLine();
            }
        }catch (Exception e){
            System.out.println("Read error 2");
        }

        return words;

    }



}
