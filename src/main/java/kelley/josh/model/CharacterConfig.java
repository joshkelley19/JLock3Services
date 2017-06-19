package kelley.josh.model;

/**
 * Created by joshuakelley on 6/17/17.
 */
public class CharacterConfig {
    public enum STATUS{
        NONE("NONE"), ONEPLUS("ONEPLUS"), CUSTOM("CUSTOM");

        STATUS(String str){
        }
    }

    public STATUS type;
    public int amount;

    public CharacterConfig(int amount, String status){
        this.amount = amount;
        this.type = STATUS.valueOf(status);
    }

    public STATUS getType() {
        return type;
    }

    public void setType(STATUS type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
