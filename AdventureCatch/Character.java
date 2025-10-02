import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private static List<Character> allCharacters = new ArrayList<>();
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private final Weapon weapon;

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    protected void setCurrentHealth(int health) {
        if (health < 0) {
            this.currentHealth = 0;
        } else if (health > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        } else {
            this.currentHealth = health;
        }
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

    public Weapon getWeapon() {
        return weapon;
    }

    public abstract void takeDamage(int damage) throws DeadCharacterException;

    public abstract void attack(Character target) throws DeadCharacterException;

    protected void applyDamage(int damage) {
        int newHealth = this.currentHealth - damage;
        if (newHealth < 0) {
            newHealth = 0;
        }
        this.currentHealth = newHealth;
    }

    protected void applyHealing(int healAmount) {
        int newHealth = this.currentHealth + healAmount;
        if (newHealth > this.maxHealth) {
            newHealth = this.maxHealth;
        }
        this.currentHealth = newHealth;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + this.currentHealth + "/" + maxHealth;
    }

    public static String printStatus() {
        String separator = "------------------------------------------";
        StringBuilder sb = new StringBuilder(separator).append("\n");

        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
            for (Character character : allCharacters) {
                sb.append(" - ").append(character.toString()).append("\n");
            }
        }
        return sb.append(separator).append("\n").toString();
    }

    public static Character fight(Character fighter1, Character fighter2) {
        while (fighter1.getCurrentHealth() > 0 && fighter2.getCurrentHealth() > 0) {

            try {
                fighter1.attack(fighter2);
            } catch (DeadCharacterException e) {
                return fighter2.getCurrentHealth() > 0 ? fighter2 : null;
            }

            if (fighter2.getCurrentHealth() <= 0) {
                return fighter1;
            }

            try {
                fighter2.attack(fighter1);
            } catch (DeadCharacterException e) {
                return fighter1.getCurrentHealth() > 0 ? fighter1 : null;
            }

            if (fighter1.getCurrentHealth() <= 0) {
                return fighter2;
            }
        }
        return null;
    }
}
