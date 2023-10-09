import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Placar extends Actor {
    protected int valor = 0;
    protected int tamanhoFonte;
    protected Color lineColor = Color.BLACK;
    protected Color fillColor = Color.WHITE;

    protected static final Color background = new Color(0, 0, 0, 0);

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