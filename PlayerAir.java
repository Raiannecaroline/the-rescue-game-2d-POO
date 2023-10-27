import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerAir extends Personagem {
    public String NOME_ARQUIVO_IMAGEM = "helicopter-players/helicopter-player-";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    public int proximoPasso = 1;
    public String Direita;
    public String Esquerda;
    public String Atirar;
    public String Cima;
    public String Baixo;
    public int vidas = 5;
    public int timer = 0;
    private int cicloAtual = 0;

    public static int TAXA_DE_ATUALIZACAO = 2;

    protected int identificadorPlayer;
    private boolean atirando = false;
    public boolean morte1;

    public int getVidas() {
        return vidas;
    }

    public int getIdentificadorPlayer() {
        return identificadorPlayer;
    }

    public PlayerAir(int identificadorPlayer, String Direita, String Esquerda, String Baixo, String Atirar,
            String Cima) {
        this.identificadorPlayer = identificadorPlayer;
        this.Direita = Direita;
        this.Esquerda = Esquerda;
        this.Baixo = Baixo;
        this.Atirar = Atirar;
        this.Cima = Cima;

        setImage(NOME_ARQUIVO_IMAGEM + identificadorPlayer + "-" + proximoPasso + EXTENSAO_ARQUIVO_IMAGEM);
    }

    public void act() {

        morte();
        movimentacao();
        disparo();

    }

    private void morte() {

        if (isTouching(DisparoEnemy.class)) {
            removeTouching(DisparoEnemy.class);
            vidas--;

            if (vidas == 0) {

                morte1 = true;

                getWorld().removeObject(this);

            }

        }

        if (isTouching(BolaFogo.class)) {
            removeTouching(BolaFogo.class);
            vidas--;

            if (vidas == 0) {

                morte1 = true;

                getWorld().removeObject(this);

            }

        }

    }

    public void disparo() {
        if (deveAtirar() && !isAtirando()) {
            DisparoPlayer tiro = criarTiro();
            atirar(tiro);
            ajustarDirecaoDoTiro(tiro);
        } else if (!deveAtirar()) {
            pararAtirar();
        }
    }

    private boolean deveAtirar() {
        return Greenfoot.isKeyDown(Atirar);
    }

    private boolean isAtirando() {
        return this.atirando;
    }

    private DisparoPlayer criarTiro() {
        DisparoPlayer tiro = new DisparoPlayer();
        tiro.playSomDisparo();
        this.atirando = true;
        return tiro;
    }

    private void atirar(DisparoPlayer tiro) {
        getWorld().addObject(tiro, getX() + 5, getY());
    }

    private void ajustarDirecaoDoTiro(DisparoPlayer tiro) {
        if (Greenfoot.isKeyDown(Cima)) {
            if (Greenfoot.isKeyDown(Direita)) {
                tiro.setRotation(-45);
            } else {
                tiro.setRotation(-90);
            }
        }
    }

    private void pararAtirar() {
        this.atirando = false;
    }

    private void movimentacao() {
        if (!morte1) {

            gerenciamentoDaCaminhada();

            if (Greenfoot.isKeyDown(Direita)) {
                move(3);
                setRotation(0);
            }
            if (Greenfoot.isKeyDown(Esquerda)) {
                move(-3);
                setRotation(0);
            }
            if (Greenfoot.isKeyDown(Cima)) {
                setLocation(getX(), getY() - 3);
                setRotation(0);
            }
            if (Greenfoot.isKeyDown(Baixo)) {
                setLocation(getX(), getY() + 3);
                setRotation(0);
            }
        }

    }

    private void gerenciamentoDaCaminhada() {

        setImage(new GreenfootImage(
                NOME_ARQUIVO_IMAGEM + identificadorPlayer + "-" + proximoPasso + EXTENSAO_ARQUIVO_IMAGEM));

        if (possoAtualizar()) {
            proximoPasso++;
        }
        if (proximoPasso > 5) {

            proximoPasso = 0;
        }

    }

    public int alturaDosPes() {
        return getY() + getImage().getHeight() / 2;

    }

    public int alturaAtual() {

        if (getWorld() instanceof Mundo1) {
            return ((alturaDosPes() - 20) - Mundo1.NIVEL_DO_SOLO) * -1;
        } else if (getWorld() instanceof Mundo2) {
            return ((alturaDosPes() - 20) - Mundo2.NIVEL_DO_SOLO) * -1;
        } else if (getWorld() instanceof Mundo3) {
            return ((alturaDosPes() - 20) - Mundo3.NIVEL_DO_SOLO) * -1;
        } else {
            // Lógica de retorno padrão caso o objeto não esteja em Mundo1 ou Mundo2
            return 0;
        }
    }

    private boolean possoAtualizar() {

        return (cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

    public int cicloAtual() {
        return cicloAtual;
    }

    private void contaCiclo() {
        cicloAtual++;
        if ((cicloAtual() % 16) == 0) {
            timer++;
        }
        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }

    private boolean timer() {
        World mundo = getWorld();

        if (mundo instanceof Mundo3) {
            Mundo3 mundo3 = (Mundo3) mundo;
            return (mundo3.cicloAtual() % 106) == 0;

        } else if (mundo instanceof Mundo1) {
            Mundo1 mundo1 = (Mundo1) mundo;

        } else if (mundo instanceof Mundo2) {
            Mundo2 mundo2 = (Mundo2) mundo;
        }

        return false;
    }

    public boolean existemObjetosDaClasse(Class classeDesejada) {
        World mundo = getWorld(); // Obtém o mundo atual

        // Percorre todos os objetos no mundo
        for (Object objeto : mundo.getObjects(null)) {
            if (objeto.getClass() == classeDesejada) {
                return true; // Encontrou pelo menos um objeto da classe
            }
        }

        return false; // Não encontrou objetos da classe
    }

}
