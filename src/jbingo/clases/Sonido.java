package jbingo.clases;

import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;

/**Clase de sonido.<br/>
 * En ella se implementan los métodos para reproducir las bolas.
 *
 * @author Jesús Alcalde Alcázar
 * @version 3.5
 */
public class Sonido {
 
 /**Reproduce es sonido de la bola.
  * 
  * @param voz La voz desde la que se reproducen los sonidos.
  * @param bola La bola que tiene que reproducir.
  * @since 3.5
  */   
 public void reproducir(String voz,int bola) throws MalformedURLException, InterruptedException{
     try {
        File f=new File("Sonidos/"+voz+"/"+(bola/10)+(bola%10)+".wav");
        URL u=f.toURL();
        AudioClip sonido=JApplet.newAudioClip(u);
        sonido.play();
        Thread.currentThread().sleep(3000);
     }catch (MalformedURLException | InterruptedException ex) {
         System.out.println (ex);
     }

 }
}
