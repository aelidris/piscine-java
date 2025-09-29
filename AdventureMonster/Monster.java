public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void attack(Character target) {
        final int monsterDamage = 12;
        target.takeDamage(monsterDamage);
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

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// ------------------------------------------
// Characters currently fighting :
// - Aragorn : 20/20
// - Slime is a monster with 15 HP
// ------------------------------------------
// ------------------------------------------
// Characters currently fighting :
// - Aragorn : 11/20
// - Slime is a monster and is dead
// ------------------------------------------
// $