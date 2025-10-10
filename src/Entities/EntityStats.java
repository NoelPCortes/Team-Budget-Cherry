package Entities;

interface DealtStats {
    public abstract int damageDealt();
    public abstract int damageTaken(int atk);
}

public abstract class EntityStats {
    private int baseDmg;
    private int baseHealth;
    private String name;

    public EntityStats(){
        baseDmg = 0;
        baseHealth = 0;
    }

    public EntityStats(int baseDmg, int baseHealth, String name){
        this.baseDmg = baseDmg;
        this.baseHealth = baseHealth;
        this.name = name;
    }

    public String getName(){ return name; }

    public abstract void printModel();
    public abstract void printStats();

    public abstract String getDescription();

    public int getDmg(){ return baseDmg; }

    public void setHealth(int health){ this.baseHealth = health; }
    public int getHealth(){ return baseHealth; }
}
