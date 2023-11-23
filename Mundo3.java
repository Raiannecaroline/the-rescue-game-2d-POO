import greenfoot.*;

public class Mundo3 extends MundoDinamico {
    public Mundo3() {
        super("mundo3.png", 349, "cenarios/CenariomovimentIlha-3/cenario_",
        ".png", false);
    }

    @Override
    public void proximoMundo() {
        if (getBoss().isMorto()) {
            Greenfoot.setWorld(new Mundo3to4());
        }
    }

    @Override
    public void droparInimigo() {
        int posicaoInimigo = Greenfoot.getRandomNumber(370) + 10;
        int posicaoBolaFogo = Greenfoot.getRandomNumber(640) + 30;

        int DropInimigo = Greenfoot.getRandomNumber(50);
        int DropInimigoCeu = Greenfoot.getRandomNumber(100);

        if (DropInimigo == 1) {
            EnemyAereo air = new EnemyAereo("helicopter/helicopter-players-1", ".png", 3);
            addObject(air, 699, posicaoInimigo);

        }
        if (posicaoBolaFogo == 1) {
            BolaFogo bolaFogo = new BolaFogo();
            addObject(bolaFogo, posicaoBolaFogo, 50);
        }
    }
}
