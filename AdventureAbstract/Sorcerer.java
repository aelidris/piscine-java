public class Sorcerer extends Character implements Healer {
    
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public void takeDamage(int damage) {
        this.applyDamage(damage);
    }

    @Override
    public void attack(Character target) {
        final int sorcererDamage = 10;
        this.heal(this); 
        target.takeDamage(sorcererDamage);
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void heal(Character target) {
        target.applyHealing(this.healCapacity);
        
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", 
                                 this.getName(), this.healCapacity);
        } else {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", 
                                 this.getName(), this.getCurrentHealth(), this.healCapacity);
        }
    }
}
