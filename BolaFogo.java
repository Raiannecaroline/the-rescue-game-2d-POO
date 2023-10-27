import greenfoot.*;

public class BolaFogo extends Actor {
    public static final String NOME_ARQUIVO_IMAGEM = "ball-enemy/ball-enemy0";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    public BolaFogo() {
        setImage(NOME_ARQUIVO_IMAGEM + EXTENSAO_ARQUIVO_IMAGEM);

    }

    public void act() {
        moveBolaFogo();
        removeBolaFogo();
    }

    private void removeBolaFogo() {

        if (isAtEdge()) {
            World mundo = getWorld();
            mundo.removeObject(this);
        }
    }

    private void moveBolaFogo() {
        int yAtual = getY();
        int XAtual = getX();

        setLocation(XAtual, yAtual + 3);
    }
}
