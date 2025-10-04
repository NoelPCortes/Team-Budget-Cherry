package Characters;

interface DealtStats {
    public abstract int damageDealt();
    public abstract int damageTaken(int atk);
    public abstract int manaTaken(int mana);
}

public class CharacterStats {
    private String name;
    private String role;
    private int baseHealth;
    private int baseMana;
    private int baseDmg;
    private boolean isLocked;

    public CharacterStats(){
        name = "Unknown";
        role = "Unknown";
        baseHealth = 0;
        baseMana = 0;
        baseDmg = 0;
        isLocked = true;
    }

    public CharacterStats(String name, String role, int baseHealth, int baseMana, int baseDmg, boolean isLocked){
        this.name = name;
        this.role = role;
        this.baseHealth = baseHealth;
        this.baseMana = baseMana;
        this.baseDmg = baseDmg;
        this.isLocked = isLocked;
    }

    public String getName(){ return name; }

    public String getRole(){ return role; }

    public int getHealth(){ return baseHealth; }
    public void setHealth(int baseHealth){ this.baseHealth = baseHealth; }

    public int getMana(){ return baseMana; }
    public void setMana(int baseMana){ this.baseMana = baseMana; }

    public int getDmg(){ return baseDmg; }

    public boolean getIsLocked(){ return isLocked; }

    public void printCharacterStats(){
        System.out.println("--------------------------------");
        System.out.println("        Name: " + name);
        System.out.println("        Role: " + role);
        System.out.println("        Health: " + baseHealth);
        System.out.println("        Mana: " + baseMana);
        System.out.println("        ATK: " + baseDmg);
        System.out.println("--------------------------------");
        System.out.println();
    }
}