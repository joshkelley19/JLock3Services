package kelley.josh.model;

/**
 * Created by joshuakelley on 6/16/17.
 */
public class PasswordConfig {
//    todo overload method differentiating between fully random and specifics added
    private boolean custom;
    private int length;
    private CharacterConfig upperCase;
    private CharacterConfig lowerCase;
    private CharacterConfig numbers;
    private CharacterConfig characters;
    private boolean charStandard;

    public PasswordConfig(boolean custom, int length, boolean charStandard, CharacterConfig upperCase,
                          CharacterConfig lowerCase, CharacterConfig numbers, CharacterConfig characters){
        this.custom = custom;
        this.length = length;
        this.charStandard = charStandard;
        this.upperCase = upperCase;
        this.lowerCase = lowerCase;
        this.numbers = numbers;
        this.characters = characters;
    }

    public PasswordConfig(){

    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public CharacterConfig getUpperCase() {
        return upperCase;
    }

    public void setUpperCase(CharacterConfig upperCase) {
        this.upperCase = upperCase;
    }

    public CharacterConfig getLowerCase() {
        return lowerCase;
    }

    public void setLowerCase(CharacterConfig lowerCase) {
        this.lowerCase = lowerCase;
    }

    public CharacterConfig getNumbers() {
        return numbers;
    }

    public void setNumbers(CharacterConfig numbers) {
        this.numbers = numbers;
    }

    public CharacterConfig getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterConfig characters) {
        this.characters = characters;
    }

    public boolean isCharStandard() {
        return charStandard;
    }

    public void setCharStandard(boolean charStandard) {
        this.charStandard = charStandard;
    }
}
