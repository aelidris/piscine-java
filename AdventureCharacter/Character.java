public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    

    public void takeDamage(int damage) {
        int newHealth = currentHealth - damage;
        if (newHealth < 0) {
            newHealth = 0;
        }
        this.currentHealth = newHealth;
    }

    public void attack(Character target) {
        final int defaultDamage = 9;
        // System.out.println(this.name + " attacks " + target.getName() + " for " + defaultDamage + " damage.");
        target.takeDamage(defaultDamage);
    }

    //<name> : <currentHealth>/<maxHealth>
    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
        // return super.toString();
    }
}
