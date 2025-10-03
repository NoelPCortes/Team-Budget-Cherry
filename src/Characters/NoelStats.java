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
