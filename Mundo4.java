import greenfoot.*;

public class Mundo4 extends MundoDinamico {
    public Mundo4() {
        super("mundo4.png", 302, "cenarios/cenario4/cenario-4_0",
                ".png", true);
    }

    @Override
    public void proximoMundo() {
        if (getBoss().isMorto()) {
            Greenfoot.setWorld(new Menu());
        }
    }

    @Override
    public void droparInimigo() {
        setBoss(new BossFinal("Boss-final/boss-final", ".png"));
        VidaBoss vidaBoss = new VidaBoss(getBoss());
        addObject(vidaBoss, 350, 20);
        addObject(getBoss(), 350, 206);
    }
}
