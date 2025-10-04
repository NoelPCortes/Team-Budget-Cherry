package Entities;

import java.util.Random;

public class DeadlineGhost extends EntityStats implements DealtStats {

    //Set Color
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    
    public DeadlineGhost(){
        super(12, 50);
    }

    public void printModel(){
        System.out.println( " ### ");
        System.out.println("#" + PURPLE + "%" + RESET + "#" + PURPLE + "%" + RESET + "#");
        System.out.println("#####");
    }

    @Override
    public String getDescription(){
        return "Forever haunting those who missed deadlines. Their presence reminds you of what ifs";
    }    

    @Override // need to modify
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
