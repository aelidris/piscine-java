public class Sorcerer extends Character implements Healer {
    
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        this.applyDamage(damage);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        final int sorcererDamage = (getWeapon() != null) ? getWeapon().getDamage() : 10;
        this.heal(this); 
        target.takeDamage(sorcererDamage);
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void heal(Character target) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        target.applyHealing(this.healCapacity);
        
    }

   @Override
    public String toString() {
        String base = (getCurrentHealth() <= 0)
            ? String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), this.healCapacity)
            : String.format("%s is a sorcerer with %d HP. It can heal %d HP.", getName(), getCurrentHealth(), this.healCapacity);
            
        if (getWeapon() != null) {
            base += String.format("\n\tHe has the weapon %s", getWeapon().toString());
        }
        return base;
    }
}
