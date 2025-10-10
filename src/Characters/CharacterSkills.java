package Characters;
/*
 * Implement skills to each character
 * Implement dmg, mana cost and cooldowns
 */

public class CharacterSkills {
    private String nameOfSkill;
    private String descriptionOfSkill;
    private int dmg;
    private int cooldown;
    private int manaConsumed;

    public CharacterSkills(){
        nameOfSkill = "Unknown";
        dmg = 0;
        cooldown = 0;
        manaConsumed = 0;
    }

    public CharacterSkills(String nameOfSkill, int dmg,
                            int cooldown, int manaConsumed){
        this.nameOfSkill = nameOfSkill;
        this.dmg = dmg;
        this.cooldown = cooldown;
        this.manaConsumed = manaConsumed;    
    }

    public void setNameOfSkill(String nameOfSkill){ this.nameOfSkill = nameOfSkill; }
    public String getNameOfSkill(){ return nameOfSkill; }

    public void setDescription(String descriptionOfSkill){ this.descriptionOfSkill = descriptionOfSkill; }
    public String getDescription(){ return descriptionOfSkill; }

    public void setDmg(int dmg){ this.dmg = dmg; }
    public int getDmg(){ return dmg; }

    public void setCooldown(int cooldown){ this.cooldown = cooldown; }
    public int getCooldown(){ return cooldown; }

    public void setManaConsumed(int manaConsumed) { this.manaConsumed = manaConsumed; }
    int getManaConsumed(){ return manaConsumed; }
}