public class CharacterStats {
    private String name;
    private String role;
    private int health;
    private int mana;
    private boolean isLocked;

    public CharacterStats(){
        name = "Unknown";
        role = "Unknown";
        health = 0;
        mana = 0;
        isLocked = true;
    }

    public CharacterStats(String name, String role, int health, int mana, boolean isLocked){
        this.name = name;
        this.role = role;
        this.health = health;
        this.mana = mana;
        this.isLocked = isLocked;
    }

    String getName(){
        return name;
    }

    String getRole(){
        return role;
    }

    int getHealth(){
        return health;
    }
    void setHealth(int health){
        this.health = health;
    }

    int getMana(){
        return mana;
    }
    void setMana(int mana){
        this.mana = mana;
    }

    String getIsLocked(){
        return (isLocked) ? "[Locked]" : "";
    }

    void printCharacterStats(){
        System.out.println("--------------------------------");
        System.out.println("        Name: " + name);
        System.out.println("        Role: " + role);
        System.out.println("        Health: " + health);
        System.out.println("        Mana: " + mana);
        System.out.println("--------------------------------");
        System.out.println();
    }
}

class ChelseyStats extends CharacterStats{
    public ChelseyStats(boolean isLocked){// Fill the parameters
        super("idk", "idk", 10, 10, isLocked);
    }

    @Override
    void printCharacterStats() {
        super.printCharacterStats();
        //fill this part
    }
}

class NoelStats extends CharacterStats{
    public NoelStats(String name, String role, int health, int  mana, boolean isLocked){
        super(name, role, health, mana, isLocked);
    }

    @Override
    void printCharacterStats() {
        System.out.println("--------------------------------");
        System.out.println("        Name: " + getName());
        System.out.println("        Role: " + getRole());
        System.out.println("        Health: " + getHealth());
        System.out.println("        Mana: " + getMana());
        System.out.println("--------------------------------");
        System.out.println();
    }
}

class RemrieStats extends CharacterStats{
    public RemrieStats(){// Fill the parameters
        super();
    }

    @Override
    void printCharacterStats() {
        super.printCharacterStats();
        //fill this part
    }
}