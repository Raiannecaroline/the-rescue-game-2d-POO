import greenfoot.*;

public abstract class PlayerBase extends Personagem {
    private String direita;
    private String esquerda;
    private String atirar;
    private String cima;
    private int identificadorPlayer;
    private boolean atirando = false;
    private static int vidaMaxima = 5;
    private static Class<? extends Disparo> disparoRival = DisparoEnemy.class;
    private boolean terrestre;

    public PlayerBase(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int quantidadeAnimacoes,
            int identificadorPlayer, String direita, String esquerda, String atirar, String cima, boolean terrestre) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, vidaMaxima, disparoRival);
        this.identificadorPlayer = identificadorPlayer;
        this.direita = direita;
        this.esquerda = esquerda;
        this.atirar = atirar;
        this.cima = cima;
        this.terrestre = terrestre;
    }

    public void ataque() {
        if (deveatirar() && !isAtirando()) {
            DisparoPlayer tiro = criarTiro();
            atirar(tiro);
            ajustarDirecaoDoTiro(tiro);
        } else if (!deveatirar()) {
            pararatirar();
        }
    }

    private boolean deveatirar() {
        return Greenfoot.isKeyDown(atirar);
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
        if (Greenfoot.isKeyDown(cima) && Greenfoot.isKeyDown(direita)) {
            tiro.setRotation(-45);
        } else if (Greenfoot.isKeyDown(cima) && Greenfoot.isKeyDown(esquerda)) {
            tiro.setRotation(-135);
        } else if (Greenfoot.isKeyDown(cima)) {
            tiro.setRotation(-90);
        } else if (Greenfoot.isKeyDown(direita)) {
            tiro.setRotation(0);
        } else if (Greenfoot.isKeyDown(esquerda)) {
            tiro.setRotation(180);
        }
    }

    private void pararatirar() {
        this.atirando = false;
    }

    public int getIdentificadorPlayer() {
        return identificadorPlayer;
    }

    public String getDireita() {
        return direita;
    }

    public String getEsquerda() {
        return esquerda;
    }

    public String getAtirar() {
        return atirar;
    }

    public String getCima() {
        return cima;
    }

    public boolean isTerrestre() {
        return terrestre;
    }
}
