package Entities;

import java.util.Random;

public class PopQuizGoblin extends EntityStats implements DealtStats {
    public PopQuizGoblin(){
        super(18, 70);
    }

    @Override
    public String getDescription(){
        return "Loves ambushing students with surprise quiz";
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
