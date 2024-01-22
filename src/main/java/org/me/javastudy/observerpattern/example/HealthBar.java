package org.me.javastudy.observerpattern.example;

import org.me.javastudy.observerpattern.Observer;
import org.me.javastudy.observerpattern.Subject;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HealthBar extends Node implements Observer {


    private static final String UPDATE_METHOD_CALLED =  String.format("The update method for %s has been called",HealthBar.class.toString());
    private static final String UPDATE_METHOD_EXECUTING_TEMPLATE = "The logic for updating after %s state change is executing";
    private static final String HEALTH_VALUE_CHANGE_DESCRIPTION = "The red health bar value %s from %s pixels to %s pixels in length";
    private static final String HEALTH_MAX_VALUE_CHANGE_DESCRIPTION = "The health bar %s from %s pixels to %s pixels in length";
    private static final String INCREASES = "increases";
    private static final String DECREASES = "decreases";
    private static final String PIXEL_FACTOR = "*PIXEL_FACTOR";
    private static final Integer PIXEL_FACTOR_INT = 100;

    private final Map<Subject, Function<Subject,?>> subjectsBeingObserved = new HashMap<>();
    private final Function<Subject, Health> updateOnPlayerHealthChange = (subject -> {
        PlayerCharacter pc = (PlayerCharacter) subject;
        Health newHealth = pc.getHealth();
        if(!this.displayedHealth.equals(newHealth))
            changeHealthBar(this.displayedHealth,newHealth);
        return newHealth;
    });

    private Health displayedHealth;
    private Integer healthBarSizeInPixels;
    private Integer healthBarCurrentValueInPixels;



    public HealthBar(PlayerCharacter pc){
        super();
        this.displayedHealth = new Health(pc.getHealth());
        pc.subscribe(this);
        this.subjectsBeingObserved.put(pc,this.updateOnPlayerHealthChange);
    }

    public Health getDisplayedHealth() {
        return displayedHealth;
    }

    public void setDisplayedHealth(Health displayedHealth) {
        this.displayedHealth = displayedHealth;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(UPDATE_METHOD_CALLED);
        if(subjectsBeingObserved.containsKey(subject)){
            System.out.println(String.format(UPDATE_METHOD_EXECUTING_TEMPLATE,subject.getClass().toString()));
            subjectsBeingObserved.get(subject).apply(subject);
        }
    }

    public String getDisplayedHealthVisual() {
        return this.toString();
    }

    private void increaseOrDescreaseMaxHealth(Integer currentMax, Integer newMax) {
        if(currentMax < newMax)
            increaseToNewMax(newMax);
        else if(currentMax > newMax)
            decreaseToNewMax(newMax);
    }

    private void increaseOrDescreaseCurrentHealth(Integer currentHealth, Integer newHealth) {
        if(currentHealth < newHealth)
            increaseToNewHealth(newHealth);
        else if(currentHealth > newHealth)
            decreaseToNewHealth(newHealth);
    }

    private void increaseToNewHealth(Integer newHealth) {
        //logic here to change the red value in the bar
        this.healthBarCurrentValueInPixels = newHealth * PIXEL_FACTOR_INT;
        System.out.println(String.format(HEALTH_MAX_VALUE_CHANGE_DESCRIPTION,INCREASES,
                this.displayedHealth.getCurrentHealth().toString()+PIXEL_FACTOR,
                newHealth.toString()+PIXEL_FACTOR));
    }
    private void decreaseToNewHealth(Integer newHealth) {
        this.healthBarCurrentValueInPixels = newHealth * PIXEL_FACTOR_INT;
        //logic here to change the red value in the bar
        System.out.println(String.format(HEALTH_VALUE_CHANGE_DESCRIPTION,DECREASES,
                this.displayedHealth.getCurrentHealth().toString()+PIXEL_FACTOR,
                newHealth.toString()+PIXEL_FACTOR));
    }

    private void increaseToNewMax(Integer newMaxHealth) {
        this.healthBarSizeInPixels = newMaxHealth * PIXEL_FACTOR_INT;
        //logic here to change the size of the bar
        System.out.println(String.format(HEALTH_MAX_VALUE_CHANGE_DESCRIPTION,INCREASES,
                                         this.displayedHealth.getCurrentHealth().toString()+PIXEL_FACTOR,
                                         newMaxHealth.toString()+PIXEL_FACTOR));
    }
    private void decreaseToNewMax(Integer newMaxHealth) {
        this.healthBarSizeInPixels = newMaxHealth * PIXEL_FACTOR_INT;
        //logic here to change the size of the bar
        System.out.println(String.format(HEALTH_MAX_VALUE_CHANGE_DESCRIPTION,DECREASES,
                this.displayedHealth.getMaxHealth().toString()+PIXEL_FACTOR,
                newMaxHealth.toString()+PIXEL_FACTOR));
    }
    private void changeHealthBar(Health currentHealth, Health newHealth) {
        increaseOrDescreaseMaxHealth(currentHealth.getMaxHealth(),newHealth.getMaxHealth());
        increaseOrDescreaseCurrentHealth(currentHealth.getCurrentHealth(),newHealth.getCurrentHealth());
        setDisplayedHealth(new Health(newHealth));
    }

    @Override
    public String toString() {
        return "HealthBar{" +
                "displayedHealth=" + displayedHealth +
                ", healthBarSizeInPixels=" + healthBarSizeInPixels +
                ", healthBarCurrentValueInPixels=" + healthBarCurrentValueInPixels +
                '}';
    }
}
