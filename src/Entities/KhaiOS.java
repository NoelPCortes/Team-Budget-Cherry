package Entities;

import java.util.Random;

public class KhaiOS extends EntityStats implements DealtStats {

    //Set Color
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";

    public KhaiOS(){
        super(40, 500);
    }

    public void printModel(){
        System.out.println(PURPLE + "%" + RESET + "#" + PURPLE + "%" + RESET + "#" + PURPLE + "%" + RESET);
        System.out.println(PURPLE + " %%% " + RESET);
        System.out.println(" #" + PURPLE + "%" + RESET + "# ");
    }

    @Override
    public String getDescription(){
        return "The ultimate embodiment of deadlines, exams, and despair";
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
