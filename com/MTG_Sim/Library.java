package com.MTG_Sim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.MTG_Sim.Biblioplex.cardPull;

public class Library {

    public Library(String filename){



    }

    public static List<String> parseDeckList(String filename) {

        List<String> deckList = new ArrayList<>();

        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while((line = reader.readLine()) != null) {
                deckList.add(line);
            }

            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return deckList;
    }

    public static List<Card> buildDeck(List<String> deckList) {

        List<Card> deck = new ArrayList<>();

        for(String s : deckList) {

            String[] cardval = s.split(" ", 2);
            if (cardval.length < 2) {
                // Skip this iteration or handle error depending on your needs
                System.out.println("Invalid format in deck list for entry: " + s);
                continue;
            }
            String name = cardval[1];

            for(int i = 0; i < Integer.parseInt(cardval[0]); i++ ){
                deck.add(cardPull(cardval[1]));
            }
        }
        System.out.println(deck);
        return deck;

    }

//    public static void main(String[] args) {
//
//        List<String> deckList = parseDeckList("deck example purphoros.txt");
//
//    }


}
