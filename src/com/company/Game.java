package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    public void setting() {

        JFrame frame = new JFrame("JoptionPane Test");
        String txtfile = "", theWord = "", playerPick = "", pAgain = "", difSwitch = "",
        difficulty = "", difficultyLowerCase = "", recordScore = "", playerName = "", recordScoreToLowerCase = "",
        pAtLC = "";
        boolean correctGuess = false, playAgain = true, recorded = false;
        Settings gameSet = new Settings();
        Score gameScore = new Score();
        ArrayList<String> theList = new ArrayList<>();
        int attempts = 1, totalScore = 0;

                /*
    System.out.println("Welcome to Guess!"+"\n"+"What difficulty would you like? (Easy, Normal, Hard)");
    //Easy, normal, hard
    //easy = 3~4 letter words. normal 5~6, hard 7+
    //choose subjects
    //Fruit, animals, colors, clothing,

        */

        while(playAgain == true) {
            String topic = JOptionPane.showInputDialog(null, "What topic would you like to guess from?." +
                    "\n" + "1. Fruits" + "\n" + "2. Vegetables" + "\n" + "3. Animals");

            switch (topic) {
                case "Fruits":
                    txtfile = "fruit";
                    break;
                case "Vegetables":
                    txtfile = "vegetables";
                    break;
                case "Animals":
                    txtfile = "animals";
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
            theList = gameSet.wordList(txtfile, difficultyLowerCase);

            while (correctGuess == false) {
                playerPick = JOptionPane.showInputDialog(null, "Guess a word from " + topic
                        + "\n" + "Type \"list\" to see the remaining choices.");

                if (playerPick.equals("list")) {
                    JOptionPane.showMessageDialog(frame, theList);
                }
                else if (playerPick.equals(theWord)) {
                    correctGuess = true;
                    JOptionPane.showMessageDialog(frame, "You got it!");

                } else if (theList.contains(playerPick) && !playerPick.equals(theWord)) {
                    theList.remove(playerPick);
                    attempts++;
                    JOptionPane.showMessageDialog(frame, "Nope, it's not " + playerPick + ".");
                } else {
                    JOptionPane.showMessageDialog(frame, "That's not a(n) " + topic + ".");
                }
            }

            totalScore = gameScore.getScore(difficultyLowerCase, attempts);

            while(!recordScoreToLowerCase.equals("exit")) {
                recordScore = JOptionPane.showInputDialog(null,
                        "You guessed the word in " + attempts + " guess(es)! Your score is: "
                                + totalScore + "." + "\n" + "\n" +
                        "Type \"record\" to record you score, \"scoreboard\" to see scores"
                        + "type \"exit\" or leave blank to exit.");
                recordScoreToLowerCase = recordScore.toLowerCase();
                switch (recordScoreToLowerCase) {
                    case "scoreboard":
                        JOptionPane.showMessageDialog(frame, gameScore.scoreBoard());
                        break;
                    case "record":
                        if (recorded == false) {
                            playerName = JOptionPane.showInputDialog(null, "Player name?");
                            gameScore.record(playerName, totalScore);
                            recorded = true;
                        }
                        break;
                    case "exit":
                        break;
                    default:
                        recordScoreToLowerCase = "exit";
                        break;
                }
            }


            while(pAgain.equals("")) {
                pAgain = JOptionPane.showInputDialog(null, "Play Again? (Yes or No)");
                pAtLC = pAgain.toLowerCase();

                if(pAtLC.equals("yes")){
                    playAgain = true;
                    correctGuess = false;
                    difficultyLowerCase = "";
                    recorded = false;
                    recordScoreToLowerCase = "";
                }
                else if(pAtLC.equals("no")){
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
