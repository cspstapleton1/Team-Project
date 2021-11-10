package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ReadAndWrite {

    public String pickAWord(String a, String b) {
        Random rNum = new Random();
        int lineNum = 0, randomPick = 0, currentLine = 0;
        String thePick = "";
        ArrayList<String> difOption = new ArrayList<>();

        File gameFile = new File("C:\\GenSpark\\TeamProject\\GitFork\\Team-Project\\src\\" + a + ".txt");

        try {
            Scanner myReader = new Scanner(gameFile);
            while (myReader.hasNextLine()){
                if(b.equals("easy")){
                    if(myReader.nextLine().length() < 5){
                        difOption.add(myReader.nextLine());
                    }
                }
                else if(b.equals("normal")){
                    if(myReader.nextLine().length() < 7 && myReader.nextLine().length() > 4){
                        difOption.add(myReader.nextLine());
                    }
                }
                else if(b.equals("hard")){
                    if(myReader.nextLine().length() > 6){
                        difOption.add(myReader.nextLine());
                    }
                }

                myReader.nextLine();
            }
        }catch (Exception e){
            System.out.println("Read error");
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

    public ArrayList<String> wordList(String a){

        ArrayList<String> words = new ArrayList<>();


        File gameFile = new File("C:\\GenSpark\\TeamProject\\GitFork\\Team-Project\\src\\" + a + ".txt");

        try {
            Scanner myReader = new Scanner(gameFile);
            while (myReader.hasNextLine()){
                words.add(myReader.nextLine());
                //myReader.nextLine();
            }
        }catch (Exception e){
            System.out.println("Read error");
        }



        return words;

    }



}
