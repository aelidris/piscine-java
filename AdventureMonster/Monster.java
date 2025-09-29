public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }
 
    @Override
    public String toString() {
        String baseStatus = super.toString();

        if (this.getCurrentHealth() <= 0) {
            return baseStatus.replace(" : KO", " is a monster and is dead");
        } else {
            return this.getName() + " is a monster with " + this.getCurrentHealth() + " HP";
        }
    }
}