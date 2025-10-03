package Characters;

public class RemrieStats extends CharacterStats implements Stats {
    public RemrieStats(boolean isLocked){// Fill the parameters
        super("Remrie", "Tank/Utility", 130, 90, 80, isLocked);
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
