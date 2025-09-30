public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void heal(Character target) {
        int potentialHealth = target.getCurrentHealth() + this.healCapacity;
        target.setCurrentHealth(potentialHealth);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() <= 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.",
                    getName(), this.healCapacity);
        } else {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.",
                    getName(), getCurrentHealth(), this.healCapacity);
        }
    }

}