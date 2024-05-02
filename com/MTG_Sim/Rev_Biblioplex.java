package com.MTG_Sim;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.Arrays;

public class Rev_Biblioplex {

    public static Card cardPull(String cardName) {
        String filePath = "allCardsTrimmed.csv";
        int lineNumber = 1;

        //String[] cardData = new String[8];
        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord csvRecord : csvParser) {
                // Check cardName in the 37th column (index 36)
                String value = csvRecord.get(36);
                if (value.equalsIgnoreCase(cardName)) {
                    String name = csvRecord.get(36);
                    String supertype = csvRecord.get(56);
                    String type = csvRecord.get(55);
                    int cmc = Integer.parseInt(csvRecord.get(35));
                    int power = Integer.parseInt(csvRecord.get(35));
                    int toughness = Integer.parseInt(csvRecord.get(35));
                    String rulestext = csvRecord.get(40);
                    String keywords = csvRecord.get(27);

                    Card card = new Card(name, supertype, type, cmc, power, toughness, rulestext, keywords);

                    return card;
                }

                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Card not found
    }

    public static void cardReadout(Card card) {

        System.out.println("Name: " + card.getName());
        System.out.println("Supertype: " + card.getSupertype());
        System.out.println("Type: " + card.getType());
        System.out.println("CMC: " + card.getCmc());
        System.out.println("Power: " + card.getPower());
        System.out.println("Toughness: " + card.getToughness());
        System.out.println("Rules Text: " + card.getRulestext());
        System.out.println("Keywords: " + card.getKeywords());

    }

//    public static Card createCardFromPull(String[] cardStats) {
//
//        //Card card = new Card(cardStats[0], cardStats[1], cardStats[2], Integer.parseInt(cardStats[3]), Integer.parseInt(cardStats[4]), Integer.parseInt(cardStats[5]), cardStats[6], cardStats[7]);
//
//        return new Card(cardStats[0], cardStats[1], cardStats[2], Integer.parseInt(cardStats[3]), Integer.parseInt(cardStats[4]), Integer.parseInt(cardStats[5]), cardStats[6], cardStats[7]);
//    }

    public static void main(String[] args) {
        Card Brudiclad_Telchor_Engineer= cardPull("Brudiclad, Telchor Engineer");
        cardReadout(Brudiclad_Telchor_Engineer);
    }
}