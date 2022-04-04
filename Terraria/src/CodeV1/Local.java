package CodeV1;

public abstract class Local extends Terre {

    public Local(int abs, int ord) {
        super(abs, ord);
        this.x=abs;
        this.y=ord;
    }


    public abstract String getinfo();
}
