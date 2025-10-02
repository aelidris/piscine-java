public class DeadCharacterException extends Exception {
    private final Character character;
    private final String characterType;

    public DeadCharacterException(Character character) {
        super();
        this.character = character;

        String type;
        if (character instanceof Sorcerer) {
            type = "sorcerer";
        } else if (character instanceof Templar) {
            type = "templar";
        } else if (character instanceof Monster) {
            type = "monster";
        } else {
            type = "character";
        }
        this.characterType = type;
    }

    @Override
    public String getMessage() {
        return String.format("The %s %s is dead.", this.characterType, this.character.getName());
    }
}