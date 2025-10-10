package Characters;

import java.util.Random;

public class NoelStats extends CharacterStats implements DealtStats {
    public int cooldownCtr;

    //Set Colors
    private String RESET = "\u001B[0m";
    private String RED = "\u001B[31m";
    private String GREEN = "\u001B[32m";

    public NoelStats(boolean isLocked){
        super("Noel", "DPS", 100, 80, 80, isLocked);
        cooldownCtr = 0;
    }

    public void printModel(){
        System.out.println(GREEN + " " + RED + "*" + GREEN + "*" + RED + "*"+ GREEN + " " + RESET);
        System.out.println(GREEN + "*****" + RESET);
        System.out.println(GREEN + " *** " + RESET);
    }

    public int usePassiveSkill(){
        if(cooldownCtr != 0)
        {
            cooldownCtr--;
            return 0;
        }
        else
        {
            cooldownCtr = 4;
            return super.getDmg();
        }
    }

    public void setCooldownCtr(int cooldownCtr){ this.cooldownCtr = cooldownCtr; }
    public int getCooldownCtr(){ return cooldownCtr; }

    @Override
    public void printCharacterStats() {
        super.printCharacterStats();
    }

    @Override
    public int damageDealt() {
        Random rand = new Random();
        return rand.nextInt(super.getDmg() + 1) + (int)Math.round(super.getDmg() * .5);
    }

    @Override
    public void damageTaken(int atk) {
        super.setHealth(super.getHealth() - atk);
    }

    @Override
    public void manaTaken(int mana) {
        super.setMana(super.getMana() - mana);
    }
}
