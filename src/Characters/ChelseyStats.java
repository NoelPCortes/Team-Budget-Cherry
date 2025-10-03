package Characters;

public class ChelseyStats extends CharacterStats implements Stats { 
    public ChelseyStats(boolean isLocked){
        super("Chelsey", "Strategist/Support", 150, 70, 50, isLocked);
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
