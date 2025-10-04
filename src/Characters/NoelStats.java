package Characters;

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
        return 0;
    }

    @Override
    public int damageTaken(int atk) {
        return 0;
    }

    @Override
    public int manaTaken(int mana) {
        return 0;
    }
}
