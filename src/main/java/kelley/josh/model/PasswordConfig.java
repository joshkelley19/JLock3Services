package kelley.josh.model;

/**
 * Created by joshuakelley on 6/16/17.
 */
public class PasswordConfig {
//    todo overload method differentiating between fully random and specifics added
    private int length;
    private boolean symbols;
    private boolean numbers;
    private boolean letters;

    public PasswordConfig(int length, boolean symbols, boolean numbers, boolean letters) {

        this.length = length;
        this.symbols = symbols;
        this.numbers = numbers;
        this.letters = letters;
    }

    public PasswordConfig() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isSymbols() {
        return symbols;
    }

    public void setSymbols(boolean symbols) {
        this.symbols = symbols;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isLetters() {
        return letters;
    }

    public void setLetters(boolean letters) {
        this.letters = letters;
    }
}
