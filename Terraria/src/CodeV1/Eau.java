package CodeV1;

public class Eau extends Secteur {
    private String type;

    public Eau() {
        this.type = "Eau";
    }

    @Override
    public int[] getposition() {
        return this.coodonnee;
    }

    @Override
    public String gettype() {
        return this.type;
    }

    @Override
    public StringBuilder afficher(int k) {
        StringBuilder X = new StringBuilder();
        X.append( " X " +"|"+" X ");
        return X;
    }


}
