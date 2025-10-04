package Characters;

public class NoelStats extends CharacterStats implements Stats {
    public NoelStats(boolean isLocked){
        super("Noel", "DPS", 100, 80, 80, isLocked);
    }

    @Override
    public void printCharacterStats() {
        super.printCharacterStats();
    }

    @Override
    public int damageDealt(int atk) {
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
