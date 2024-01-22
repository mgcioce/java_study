package org.me.javastudy.observerpattern.example;

import java.util.Scanner;

public class Driver {

    private static final String GAIN_OR_LOSE_HEALTH_TEMPLATE = "Player Character %s %s for %d hit points";
    private static final String GAIN = "IS HEALED";
    private static final String LOSE = "IS DAMAGED";

    public static void main(String[] args){
        //intialize scenario
        PlayerCharacter pc = new PlayerCharacter("Bob",10);
        HealthBar healthBar = new HealthBar(pc);
        Scanner kb = new Scanner(System.in);
        boolean loop = false;
        do{
           setNewHealthValue(kb,pc);
           loop = loopChoice(kb);
        } while (loop);
    }

    public static void setNewHealthValue(Scanner kb, PlayerCharacter pc){
        System.out.println("Pick one of the following scenarios:");
        System.out.println("\t1. gain health");
        System.out.println("\t2. lose health");
        System.out.println("\t3. increase max health");
        System.out.println("enter 1,2, or 3: ");
        int choice = Integer.parseInt(kb.nextLine());
        switch(choice) {
            case 1: {
                int randomInt = (int) Math.floor(Math.random() * 1000) % 10;
                System.out.println(String.format(GAIN_OR_LOSE_HEALTH_TEMPLATE,pc.getName(),GAIN,randomInt));
                pc.heal(randomInt);
                break;
            }
            case 2: {
                int randomInt = (int) Math.floor(Math.random() * 1000) % 10;
                System.out.println(String.format(GAIN_OR_LOSE_HEALTH_TEMPLATE,pc.getName(),LOSE,randomInt));
                pc.damage(randomInt);
                break;
            }
            default:
                break;
        }
    }

    public static boolean loopChoice(Scanner kb) {
        System.out.println("Continue? (y/n): ");
        String choice = kb.nextLine();
        return choice.matches("^[Yy]{1}+$");
    }

}
