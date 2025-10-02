public class Templar extends Character implements Healer, Tank {
    
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

 
    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        int damageBlocked = Math.min(this.shield, damage);
        int effectiveDamage = damage - damageBlocked;
        if (effectiveDamage < 0) {
            effectiveDamage = 0;
        }
        this.applyDamage(effectiveDamage); 
    }


    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        final int templarDamage = (getWeapon() != null) ? getWeapon().getDamage() : 6;
        this.heal(this); 
        target.takeDamage(templarDamage);
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
    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() <= 0)
            ? String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", getName(), this.shield, this.healCapacity)
            : String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", getName(), getCurrentHealth(), this.healCapacity, this.shield);
            
        if (getWeapon() != null) {
            base += String.format("\n\tHe has the weapon %s", getWeapon().toString());
        }
        return base;
    }


}
