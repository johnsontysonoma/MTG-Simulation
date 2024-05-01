package com.MTG_Sim;

public class Card {

    String name;
    String type;
    String supertype;
    int cmc;
    int power;
    int toughness;
    String rulestext;
    String keywords;

    public Card(String name, String type, String supertype, int cmc, int power, int toughness, String rulestext, String keywords) {
        this.name = name;
        this.type = type;
        this.supertype = supertype;
        this.cmc = cmc;
        this.power = power;
        this.toughness = toughness;
        this.rulestext = rulestext;
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSupertype() {
        return supertype;
    }

    public int getCmc() {
        return cmc;
    }

    public int getPower() {
        return power;
    }
    public int getToughness() {
        return toughness;
    }

    public String getRulestext() {
        return rulestext;
    }

    public String getKeywords() {
        return keywords;
    }
}
