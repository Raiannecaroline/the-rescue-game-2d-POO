import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Placar extends Actor {
<<<<<<< HEAD
    protected int valor = 0;
    protected int tamanhoFonte;
    protected Color lineColor = Color.BLACK;
    protected Color fillColor = Color.WHITE;

    protected static final Color background = new Color(0, 0, 0, 0);
=======
    private int valor = 0;
    private int tamanhoFonte;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;

    private static final Color background = new Color(0, 0, 0, 0);
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696

    public Placar(int valor, int tamanhoFonte) {
        this.valor = valor;
        this.tamanhoFonte = tamanhoFonte;
        setImage(new GreenfootImage(Integer.toString(valor), tamanhoFonte, fillColor, background, lineColor));
    }

    private void incrementaPlacar() {
        valor++;
    }

    public void atualizaPlacar() {
        incrementaPlacar();
        setImage(new GreenfootImage(Integer.toString(valor), tamanhoFonte, fillColor, background, lineColor));
    }
}