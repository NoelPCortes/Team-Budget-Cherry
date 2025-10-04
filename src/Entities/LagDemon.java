package Entities;

import java.util.Random;

public class LagDemon extends EntityStats implements DealtStats {
    public LagDemon(){
        super(25, 135);
    }

    @Override
    public String getDescription(){
        return "Slows your progress and corrupt determination";
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
