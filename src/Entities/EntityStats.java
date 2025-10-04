package Entities;

interface DealtStats {
    public abstract int damageDealt();
    public abstract int damageTaken(int atk);
}

public abstract class EntityStats {
    public int baseDmg;
    public int baseHealth;

    public EntityStats(){
        baseDmg = 0;
        baseHealth = 0;
    }

    public EntityStats(int baseDmg, int baseHealth){
        this.baseDmg = baseDmg;
        this.baseHealth = baseHealth;
    }

    public abstract String getDescription();

    public int getDmg(){ return baseDmg; }

    public void setHealth(int health){ this.baseHealth = health; }
    public int getHealth(){ return baseHealth; }
}
