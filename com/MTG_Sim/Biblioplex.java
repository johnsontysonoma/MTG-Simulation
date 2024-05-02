package com.MTG_Sim;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

import static com.MTG_Sim.Card.cardReadout;

public class Biblioplex {

    public static Card cardPull(String cardName) {

        // this is the file path of the database relative to this class
        String filePath = "allCardsTrimmed.csv";
        int lineNumber = 1;

        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord csvRecord : csvParser) {
                // Check cardName in the 37th column (index 36)
                String value = csvRecord.get(36);
                if (value.equalsIgnoreCase(cardName)) {
                    // Storing the data pulled from the spreadsheet
                    String name = csvRecord.get(36);
                    String supertype = csvRecord.get(56);
                    String type = csvRecord.get(55);
                    int cmc = Integer.parseInt(csvRecord.get(35));
                    int power = Integer.parseInt(csvRecord.get(35));
                    int toughness = Integer.parseInt(csvRecord.get(35));
                    String rulestext = csvRecord.get(40);
                    String keywords = csvRecord.get(27);

                    // Creating a card object with all the pulled data
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


    public static void main(String[] args) {
        Card Brudiclad_Telchor_Engineer = cardPull("Brudiclad, Telchor Engineer");
        cardReadout(Brudiclad_Telchor_Engineer);
    }
}