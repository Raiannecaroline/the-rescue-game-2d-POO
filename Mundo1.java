import greenfoot.*;

public class Mundo1 extends MundoDinamico {
    public Mundo1() {
        super("mundo1.png", 336, "cenarios/CenariomovimentIlha/cenario_",
        ".png", true);
    }

    @Override
    public void proximoMundo() {
        if (getBoss().isMorto()) {
            Greenfoot.setWorld(new Mundo2());
        }
    }

    @Override
    public void droparInimigo() {
        int dropInimigo = Greenfoot.getRandomNumber(50);
        int dropInimigoCeu = Greenfoot.getRandomNumber(200);
        if (dropInimigo == 1) {
            EnemyTerrestre inimigo1 = new EnemyTerrestre("enemys/enemys-1", ".png");
            addObject(inimigo1, 699, 340);

        }
        if (dropInimigoCeu == 1 && getTimer() < getTimerObjetivo()) {
            EnemyAereo air = new EnemyAereo("inimigo-aereo/inimigo", ".png",
            1);
            addObject(air, 699, 150);
        }
        if (getTimer() == getTimerObjetivo() && getBoss() == null) {
            setBoss(new Boss("boss-cenario-1/boss-cenario", ".png"));
            VidaBoss vidaBoss = new VidaBoss(getBoss());
            addObject(vidaBoss, 350, 20);
            addObject(getBoss(), 699, 50);
        }
    }
}
