package com.codecool.game;

import com.codecool.termlib.Color;
import com.codecool.termlib.Direction;
import com.codecool.termlib.Terminal;

public class Java_Freestyle {

    public static void main(String[] args) {

        Terminal terminal = new Terminal();
        terminal.clearScreen();
        terminal.moveTo(10, 10);        
        terminal.drawCard(4);
        terminal.flipCard();
        
    };

}