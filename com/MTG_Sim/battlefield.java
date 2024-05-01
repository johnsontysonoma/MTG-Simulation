package com.MTG_Sim;

import java.util.Arrays;

public class battlefield {

    public static String combatDamage(Creature attacker, Creature blocker) {
        int atkHP = attacker.getToughness();
        int defHP = blocker.getToughness();
        int atkPower = attacker.getPower();
        int defPower = blocker.getPower();
        String result = "";
        defHP -= atkPower;
        atkHP -= defPower;
        int trample = Math.abs(defHP);

        if (defHP <= 0 && atkHP <= 0) {
            result = String.format("Both the attacker's %s and the blocker's %s have died in combat.", attacker.getName(), blocker.getName());
        } else if (defHP <= 0 && atkHP > 0) {
            result = String.format("Attacker's %s has killed the blocker's %s.", attacker.getName(), blocker.getName());
        } else if (defHP > 0 && atkHP <= 0) {
            result = String.format("Blocker's %s has killed the attacker's %s.", blocker.getName(), attacker.getName());
        } else if (defHP > 0 && atkHP > 0) {
            result = String.format("Both the attacker and blocker survive combat with %d and %d respectively", atkHP, defHP);
        }
        return(result);
    }

    public static void main(String[] args) {

        Creature c1 = new Creature("Brudiclad, Telchor Engineer", 6, 4, 4);

        System.out.println(c1.name);
        System.out.println(c1.cmc);

        Creature c2 = new Creature("Bearer of Memory", 3, 3, 2);


        System.out.println(combatDamage(c1, c2));

    }


}