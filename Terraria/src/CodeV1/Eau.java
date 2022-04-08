package CodeV1;

public class Eau extends Secteur {
    private String type;

    public Eau() {
        this.type = "Eau";
    }


    @Override
    public int[] getposition() {
        return new int[0];
    }

    @Override
    public String gettype() {
        return this.type;
    }
}
