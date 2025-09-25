/*
 * Implement skills to each character
 * Implement dmg, mana cost and cooldowns
 */

public class CharacterSkills {
    private String nameOfSkill;
    private int dmgOfSkill;
    private int cooldownOfSkill;
    private int manaConsumedOfSkill;

    public CharacterSkills(){
        nameOfSkill = "Unknown";
        dmgOfSkill = 0;
        cooldownOfSkill = 0;
        manaConsumedOfSkill = 0;
    }

    public CharacterSkills(String nameOfSkill, int dmgOfSkill,
                            int cooldownOfSkill, int manaConsumedOfSkill){
        this.nameOfSkill = nameOfSkill;
        this.dmgOfSkill = dmgOfSkill;
        this.cooldownOfSkill = cooldownOfSkill;
        this.manaConsumedOfSkill = manaConsumedOfSkill;    
    }
}