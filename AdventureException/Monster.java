public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }
    
    @Override
    public void takeDamage(int damage) {
        int effectiveDamage = (int) Math.floor(damage * 0.80);
        this.applyDamage(effectiveDamage);
    }

    @Override
    public void attack(Character target) {
        final int monsterDamage = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        target.takeDamage(monsterDamage);
    }
    
    @Override
    public String toString() {
        String base = (getCurrentHealth() <= 0) 
            ? getName() + " : KO (Monster)"
            : getName() + " : " + getCurrentHealth() + "/" + getMaxHealth() + " (Monster)";
            
        if (getWeapon() != null) {
            base += String.format("\n\tHe has the weapon %s", getWeapon().toString());
        }
        return base;
    }
}
