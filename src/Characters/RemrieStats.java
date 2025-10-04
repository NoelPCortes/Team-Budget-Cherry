package Characters;

public class RemrieStats extends CharacterStats implements DealtStats {
    public int cooldownCtr;

    //Set Colors
    private String RESET = "\u001B[0m";
    private String RED = "\u001B[31m";
    private String BLUE = "\u001B[34m";

    public RemrieStats(boolean isLocked){
        super("Remrie", "Tank/Utility", 130, 90, 80, isLocked);
        cooldownCtr = 0;
    }

    public void printModel(){
        System.out.println(BLUE + "*" + RED + "*" + BLUE + "*" + RED + "*"+ BLUE + "*" + RESET);
        System.out.println(BLUE + " *** " + RESET);
        System.out.println(BLUE + "  *  " + RESET);
    }

    public int usePassiveSkill(){
        cooldownCtr = 5;
        return cooldownCtr;//means nothing
    }

    public void setCooldownCtr(int cooldownCtr){ this.cooldownCtr = cooldownCtr; }
    public int getCooldownCtr(){ return cooldownCtr; }

    @Override
    public void printCharacterStats() {
        super.printCharacterStats();
    }

    @Override
    public int damageDealt() {
        throw new UnsupportedOperationException("Unimplemented method 'damageDealt'");
    }

    @Override
    public int damageTaken(int atk) {
        throw new UnsupportedOperationException("Unimplemented method 'damageTaken'");
    }

    @Override
    public int manaTaken(int mana) {
        throw new UnsupportedOperationException("Unimplemented method 'manaTaken'");
    }
}
