import java.util.ArrayList;
import java.util.List;

public class Character {
    private static List<Character> allCharacters = new ArrayList<>();
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    public void setCurrentHealth(int newHealth) {
        if (newHealth < 0) {
            this.currentHealth = 0;
        } else if (newHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        } else {
            this.currentHealth = newHealth;
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

    public void takeDamage(int damage) {
        int newHealth = currentHealth - damage;
        if (newHealth < 0) {
            newHealth = 0;
        }
        this.currentHealth = newHealth;
    }

    public void attack(Character target) {
        final int defaultDamage = 9;
        target.takeDamage(defaultDamage);
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
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
            fighter1.attack(fighter2);
            if (fighter2.getCurrentHealth() <= 0) {
                return fighter1;
            }
            fighter2.attack(fighter1);
            if (fighter1.getCurrentHealth() <= 0) {
                return fighter2;
            }
        }
        return null;
    }
}
