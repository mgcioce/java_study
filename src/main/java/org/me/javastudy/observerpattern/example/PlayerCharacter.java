package org.me.javastudy.observerpattern.example;

import org.me.javastudy.observerpattern.Observer;
import org.me.javastudy.observerpattern.Subject;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerCharacter extends Character implements Subject {

    private static final String OBSERVER_CHANGE = "%s %s as an observer to subject %s";
    private static final String SUBSCRIBING = "subscribing";
    private static final String UNSUBSCRIBING = "unsubscribing";

    private final Collection<Observer> observers = new ArrayList<>();

    private String characterName;
    private Integer maxWeight;

    public PlayerCharacter(String characterName, Integer maxHealth){
        super();
        this.characterName = characterName;
        this.setHealth(new Health());
        this.getHealth().setMaxHealth(maxHealth);
        this.getHealth().setCurrentHealth(maxHealth);
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
        for(Observer observer: this.observers) {
            observer.update(this);
        }
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
        for(Observer observer: this.observers) {
            observer.update(this);
        }
    }

    @Override
    public void setHealth(Health health) {
        super.setHealth(health);
        for(Observer observer: this.observers) {
            observer.update(this);
        }
    }

    public void heal(Integer healing) {
        Health healthField = this.getHealth();
        Integer newHealth = healthField.getCurrentHealth() + healing;
        if(newHealth > healthField.getMaxHealth())
            healthField.setCurrentHealth(healthField.getMaxHealth());
        else
            healthField.setCurrentHealth(newHealth);
        this.setHealth(healthField);
    }

    public void damage(Integer damage){
        Health healthField = this.getHealth();
        Integer newHealth = healthField.getCurrentHealth() - damage;
        if(newHealth < 0)
            healthField.setCurrentHealth(0);
        else
            healthField.setCurrentHealth(newHealth);
        this.setHealth(healthField);
    }

    @Override
    public void subscribe(Observer observer) {
        if(observer == null)
            return;
        if(this.observers.contains(observer))
            return;
        System.out.println(String.format(OBSERVER_CHANGE,SUBSCRIBING,observer.toString(),this.getClass().getName()));
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        if(observer == null)
            return;
        if(!this.observers.contains(observer))
            return;
        System.out.println(String.format(OBSERVER_CHANGE,UNSUBSCRIBING,observer.toString(),this.getClass().getName()));
        this.observers.remove(observer);
    }


}
