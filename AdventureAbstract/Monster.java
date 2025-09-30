public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }
    
    @Override
    public void takeDamage(int damage) {
        int effectiveDamage = (int) Math.floor(damage * 0.80);
        this.applyDamage(effectiveDamage);
    }

    @Override
    public void attack(Character target) {
        final int monsterDamage = 7;
        target.takeDamage(monsterDamage);
    }
    
    @Override
    public String toString() {
        if (getCurrentHealth() <= 0) {
            return this.getName() + " is a monster and is dead";
        }
        return this.getName() + " : " + this.getCurrentHealth() + "/" + this.getMaxHealth();
    }
}
