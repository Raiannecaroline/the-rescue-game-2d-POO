import greenfoot.*;
import javax.sound.sampled.*;
import java.io.*;

public class Sound extends Actor {
    private GreenfootSound sound;
    public String nomeSom;

    public Sound(String nomeSom) {
        // Carregue o arquivo de áudio
        sound = new GreenfootSound(nomeSom);
        
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
