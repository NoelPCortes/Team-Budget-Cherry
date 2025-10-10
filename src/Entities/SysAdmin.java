package Entities;

import java.util.Random;

public class SysAdmin extends EntityStats implements DealtStats {
    
    //Set Color
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";

    public SysAdmin(){
        super(33, 180, "SysAdmin");
    }

    @Override
    public void printModel(){
        System.out.println(PURPLE + "%%" + RESET + "#" + PURPLE + "%%" + RESET);
        System.out.println(" #" + PURPLE + "%" + RESET +"# ");
        System.out.println(PURPLE + " %" + RESET + "#" + PURPLE + "% " + RESET);
    }

    @Override
    public void printStats(){
        System.out.println("------------------------------");
        System.out.println("Health: " + String.valueOf(super.getHealth()));
        System.out.println("Damage: " + String.valueOf(super.getDmg()));
        System.out.println("------------------------------");
    }

    @Override
    public String getName(){ return super.getName(); }

    @Override
    public String getDescription(){
        return "Cold, Efficient, and Merciless. Can restore defeated minions";
    }

    @Override
    public int damageDealt() {
        Random rand = new Random();
        return rand.nextInt((super.getDmg() + 1)) + (int)Math.round(super.getDmg() * .5);
    }

    @Override
    public int damageTaken(int atk) {
        super.setHealth(super.getHealth() - atk);
        return super.getHealth();
    }
}
