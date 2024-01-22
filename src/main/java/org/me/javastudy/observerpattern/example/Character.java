package org.me.javastudy.observerpattern.example;

public abstract class Character extends Node  {

    private Health health;

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }
}
