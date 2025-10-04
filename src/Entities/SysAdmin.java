package Entities;

import java.util.Random;

public class SysAdmin extends EntityStats implements DealtStats {
    public SysAdmin(){
        super(33, 180);
    }

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
