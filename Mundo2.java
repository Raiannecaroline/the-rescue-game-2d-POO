import greenfoot.*;

public class Mundo2 extends MundoDinamico {
    public Mundo2() {
        super("mundo2.png", 349, "cenarios/CenariomovimentIlha-2/cenario_",
        ".png", true);
    }

    @Override
    public void proximoMundo() {
        if (getBoss().isMorto()) {
            Greenfoot.setWorld(new Mundo2to3());
        }
    }

    @Override
    public void droparInimigo() {
        int dropInimigo = Greenfoot.getRandomNumber(50);
        int dropInimigoCeu = Greenfoot.getRandomNumber(200);
        if (dropInimigo == 1) {
            EnemyTerrestre inimigo1 = new EnemyTerrestre("enemys/enemys-2", ".png");
            addObject(inimigo1, 699, getAlturaSolo() + 5);

        }
        if (dropInimigoCeu == 1 && getTimer() < getTimerObjetivo()) {
            EnemyAereo air = new EnemyAereo("enemys-cenario2/wall-turret", ".png",
                    1);
            addObject(air, 699, 150);
        }
        if (getTimer() == getTimerObjetivo() && getBoss() == null) {
            setBoss(new Boss("boss-cenario-2/boss-2", ".png"));
            VidaBoss vidaBoss = new VidaBoss(getBoss());
            addObject(vidaBoss, 350, 20);
            addObject(getBoss(), 699, 50);
        }
    }
}