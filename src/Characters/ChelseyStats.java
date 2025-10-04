package Characters;

public class ChelseyStats extends CharacterStats implements DealtStats { 
    public int cooldownCtr;

    //Set Colors
    private String RESET = "\u001B[0m";
    private String RED = "\u001B[31m";
    private String YELLOW = "\u001B[33m";

    public ChelseyStats(boolean isLocked){
        super("Chelsey", "Strategist/Support", 150, 70, 50, isLocked);
        cooldownCtr = 0;
    }

    public void printModel(){
        System.out.println(YELLOW + "*" + RED + "*" + YELLOW + "*" + RED + "*"+ YELLOW + "*" + RESET);
        System.out.println(YELLOW + "*****" + RESET);
        System.out.println(YELLOW + " *** " + RESET);
    }

    public void usePassiveSkill(){

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
