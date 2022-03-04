package com.starwars.startWarsProject.model;
/*Adicionei value para facilitar a multiplicação*/
public enum Items {
    WEAPON(4),
    AMMO(3),
    WATER(2),
    FOOD(1);

    public final int value;

    Items(int value) {
        this.value = value;
    }
}
