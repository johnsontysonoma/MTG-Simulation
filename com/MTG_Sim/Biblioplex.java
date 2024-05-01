package com.MTG_Sim;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.Arrays;

public class Biblioplex {

    public static String[] cardPull(String filePath, String cardName) {
        int lineNumber = 1;
        String[] cardData = new String[8];

        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord csvRecord : csvParser) {
                // Check cardName in the 37th column (index 36)
                String value = csvRecord.get(36);
                if (value.equalsIgnoreCase(cardName)) {
                    cardData[0] = csvRecord.get(36);
                    cardData[1] = csvRecord.get(56);
                    cardData[2] = csvRecord.get(55);
                    cardData[3] = csvRecord.get(35);
                    cardData[4] = csvRecord.get(43);
                    cardData[5] = csvRecord.get(58);
                    cardData[6] = csvRecord.get(40);
                    cardData[7] = csvRecord.get(27);
                    //System.out.println(Arrays.toString(cardData));

                    return cardData;
                }

                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Card not found
    }

    public static void cardReadout(String[] cardData) {

        System.out.println("Name: " + cardData[0]);
        System.out.println("Supertype: " + cardData[1]);
        System.out.println("Type: " + cardData[2]);
        System.out.println("CMC: " + cardData[3]);
        System.out.println("Power: " + cardData[4]);
        System.out.println("Toughness: " + cardData[5]);
        System.out.println("Rules Text: " + cardData[6]);
        System.out.println("Keywords: " + cardData[7]);

    }

    public static void main(String[] args) {
        String[] cardData = cardPull("allCardsTrimmed.csv", "Brudiclad, Telchor Engineer");

        cardReadout(cardData);
    }
}