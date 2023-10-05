import greenfoot.*;
import javax.sound.sampled.*;
import java.io.*;

public class Sound extends Actor {
    private GreenfootSound sound;

    public Sound() {
        // Carregue o arquivo de áudio
        sound = new GreenfootSound("tema.mp3");
    }

    public void play() {
        // Reproduza a trilha sonora
        sound.play();
    }

    public void stop() {
        // Pare a trilha sonora
        sound.stop();
    }
}
