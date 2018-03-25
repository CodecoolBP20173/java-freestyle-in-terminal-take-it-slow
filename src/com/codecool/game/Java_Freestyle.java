package com.codecool.game;

import com.codecool.termlib.Color;
import com.codecool.termlib.Direction;
import com.codecool.termlib.Terminal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Java_Freestyle {


    public static void main(String[] args) {
        Boolean gameIsOn = true;
        while (gameIsOn) {
            Scanner userInput = new Scanner(System.in);
            Terminal terminal = new Terminal();
            terminal.clearScreen();
            terminal.moveTo(5, 10);
            System.out.println("Hello and Welcome to Coloured Cards!");
            System.out.print("How many cards would you like to play with, my friend? ");
            int numberOfCards = userInput.nextInt();

            terminal.drawCard(numberOfCards);
            try {    
                Thread.sleep(1000);
            
            } catch(InterruptedException e) {
                System.out.println("Something went wrong.");
            }
            System.out.println("You'll have 2 seconds to memorize the cards");
            System.out.println("Press \"f\" and enter when you are ready to flip the cards");
            String flipping = userInput.next();
            Color[] colourSequence = new Color[numberOfCards];
            colourSequence = terminal.flipCard(numberOfCards);
            try {    
                Thread.sleep(2000);
            
            } catch(InterruptedException e) {
                System.out.println("Something went wrong. Please, come back later.");
            }
            terminal.flipBack(numberOfCards);
            terminal.moveTo(35, 0);        

            System.out.println("So what colours have you seen popping up? Mind the sequence!");
            System.out.println("Use these shortcuts:\nBLACK = b\nRED = r\nGREEN = g\nYELLOW = y\nBLUE = bl\nMAGENTA = m\nCYAN = c\nWHITE = w\n");
            
            System.out.println("What colours have you seen?");
            String[] usersPerception = new String[numberOfCards];
            for (int i=0; i<numberOfCards; i++) {
                usersPerception[i] = userInput.next(); 
            }

            for (int inp=0; inp<numberOfCards; inp++) {
                if (terminal.convertInput(usersPerception[inp]) == (colourSequence[inp])) {
                    ;
                }
                else {
                    System.out.println("You missed it. You should quit.");
                }
            }

            System.out.println("This is what you've seen:");
            for (int i=0; i<numberOfCards; i++) {
                System.out.println(colourSequence[i]);
            }
            

            gameIsOn = false;
        }
        
    };

}
