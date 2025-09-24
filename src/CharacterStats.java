public class CharacterStats {

    private String name;
    private String role;
    private int health;
    private int mana;
    private boolean isLocked;

    public CharacterStats()
    {
        name = "Unknown";
        role = "Unknown";
        health = 0;
        mana = 0;
        isLocked = true;
    }

    public CharacterStats(String name, String role, int health, int mana, boolean isLocked)
    {
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

    int getMana(){
        return mana;
    }

    boolean getIsLocked(){
        return isLocked;
    }
}

class ChelseyStats extends CharacterStats{
    public ChelseyStats(boolean isLocked){// Fill the parameters
        super("idk", "idk", 10, 10, isLocked);
    }
}

class NoelStats extends CharacterStats{
    public NoelStats(String name, String role, int health, int  mana, boolean isLocked){
        super(name, role, health, mana, isLocked);
    }
}

class RemrieStats extends CharacterStats{
    public RemrieStats(){// Fill the parameters
        super();
    }
}