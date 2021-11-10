package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public void setting() {

        JFrame frame = new JFrame("JoptionPane Test");
        String txtfile = "", theWord = "", playerPick = "", pAgain = "", difSwitch = "",
        difficulty = "", difficultyLowerCase = "";
        boolean correctGuess = false, playAgain = true;
        ReadAndWrite gameSet = new ReadAndWrite();
        ArrayList<String> theList = new ArrayList<>();

                /*
    System.out.println("Welcome to Guess!"+"\n"+"What difficulty would you like? (Easy, Normal, Hard)");
    //Easy, normal, hard
    //easy = 3~4 letter words. normal 5~6, hard 7+
    //choose subjects
    //Fruit, animals, colors, clothing,

        */

        while(playAgain == true) {
            String topic = JOptionPane.showInputDialog(null, "What topic would you like to guess from?.");

            switch (topic) {
                case "Fruit":
                    txtfile = "fruit";
                    break;
                case "Vegetables":
                    txtfile = "fruit";
                    break;
                default:
                    txtfile = "fruit";
                    topic = "Fruit";
                    break;
            }


            while(!difficultyLowerCase.equals("easy") && !difficultyLowerCase.equals("normal") &&
                    !difficultyLowerCase.equals("hard")) {
                difficulty = JOptionPane.showInputDialog(null, "What difficulty would you like?");

                difficultyLowerCase = difficulty.toLowerCase();

            }


            theWord = gameSet.pickAWord(txtfile, difficultyLowerCase);
            theList = gameSet.wordList(txtfile);


            System.out.println(theWord);
            System.out.println(theList);
            System.out.println("Didn't inf loop");


            while (correctGuess == false) {
                playerPick = JOptionPane.showInputDialog(null, "Guss a word from " + topic
                        + "\n" + "Type \"list\" to see the remaining choices.");

                if (playerPick.equals("list")) {
                    JOptionPane.showMessageDialog(frame, theList);
                }
                else if (playerPick.equals(theWord)) {
                    correctGuess = true;
                    JOptionPane.showMessageDialog(frame, "You got it!");

                } else if (theList.contains(playerPick) && !playerPick.equals(theWord)) {
                    theList.remove(playerPick);
                    JOptionPane.showMessageDialog(frame, "Nope, it's not " + playerPick);
                } else {
                    JOptionPane.showMessageDialog(frame, "That's not a(n) " + topic);
                }
            }

            while(pAgain.equals("")) {
                pAgain = JOptionPane.showInputDialog(null, "Play Again?");

                if(pAgain.equals("yes")){
                    playAgain = true;
                    correctGuess = false;
                }
                else if(pAgain.equals("no")){
                    playAgain = false;
                }
                else{
                    pAgain = "";
                    JOptionPane.showMessageDialog(frame, "That's not a Yes or a No.");
                }

            }

            pAgain = "";
        }

        System.exit(0);


    }
}
