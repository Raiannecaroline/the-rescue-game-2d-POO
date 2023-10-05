import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Placar extends Actor {
    private int valor = 0;
    private int tamanhoFonte;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;

    private static final Color background = new Color(0, 0, 0, 0);

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