package com.MTG_Sim;

public class Creature {

    String name;
    int cmc;
    int power;
    int toughness;

    public Creature(String name, int cmc, int power, int toughness) {
        this.name = name;
        this.cmc = cmc;
        this.power = power;
        this.toughness = toughness;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
    public int getToughness() {
        return toughness;
    }

}