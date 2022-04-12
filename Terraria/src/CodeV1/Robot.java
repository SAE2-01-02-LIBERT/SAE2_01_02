package CodeV1;

public class Robot extends Batiment {
    private static String type;
    private static String typeMine; // Or ou nickel

    private int soute;
    private int capacitee;
    private int numero;
    private int[] position;

    public Robot(String typeMine, int num) {
        this.type = "Robot";
        this.typeMine = typeMine;
        this.numero = num;
        this.soute = 0;
        this.capacitee = 0;
        this.position = new int[2];
        this.position[0] = 0; // par defaut
        this.position[1] = 0; // par defaut
    }

    public Robot(Robot r, int[] Npos) {
        this.soute = r.soute;
        this.position = Npos;
        this.capacitee = r.capacitee;
        this.numero = r.numero;
        this.type = r.type;
    }

    public void recolter() {
        // TODO implement here
    }

    public void deposer() {
        // TODO implement here
    }

    /**
     * partie des deplacements
     * Attention on doit faire gaffe a ce que deux robot ne soient pas dans
     * le meme secteur
     * Et que le robot ne sorte pas de la map, ça serait problematique.
     * <p>
     * Utilisation du constructeur par recopie en repassant de monde a secteur... c'est pour ca que Monde a une
     * liste de Robot, Mine et Entrepot.
     * <p>
     * Bon courage  =) !
     */

    public void nord() {
        // TODO implement here
    }

    public void sud() {
        // TODO implement here
    }

    public void est() {
        // TODO implement here
    }

    public void ouest() {
        // TODO implement here
    }

    @Override
    public String afficher() {
        return " R | " + this.numero + " ";
    }

    @Override
    public int getStock() {
        return this.soute;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getInfo() {
        return "| " + "R" + this.numero + "   " +"[ "+ this.position[0] +", "+this.position[1]+" ]  " + this.typeMine +"  "+ this.soute + " / " + this.capacitee+"\t |";
    }
}
