package Entities;

import java.util.Random;

public class ExceptionPhantom extends EntityStats implements DealtStats {

    //Set Color
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";

    public ExceptionPhantom(){
        super(22, 100);
    }

    public void printModel(){
        System.out.println("##" + PURPLE + "%" + RESET + "##");
        System.out.println(" #" + PURPLE + "%" + RESET + "# ");
        System.out.println("  " + PURPLE + "%" + RESET + "  ");
    }

    @Override
    public String getDescription(){
        return "Appears suddenly in your code and disappears when shown to your professor";
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
