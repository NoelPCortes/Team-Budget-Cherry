package Entities;

import java.util.Random;

public class SyntaxSerpent extends EntityStats implements DealtStats {
    public SyntaxSerpent(){
        super(23, 120);
    }

    @Override
    public String getDescription(){
        return "Slithers through your code waiting for a missing semicolon";
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
