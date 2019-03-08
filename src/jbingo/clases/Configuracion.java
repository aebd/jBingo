package jbingo.clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**Clase de tipo configuración.<br/>
 * En ella se especifican las configuraciones del juego.
 *
 * @author Jesús Alcalde Alcázar
 * @version 4.0.3
 */
public class Configuracion implements Serializable{
    
    /** Atributo que establece la duración de la partida.
     * @since 3.5
     */
    private byte duracion;
    /**Atributo que establece la voz.
     * @since 3.5
     */
    private String voz;
    /**Atributo que dice que si se pasan solas o no.
     * @since 3.5
     */
    private boolean solas;
    
    /**Constructor con los valores de configuración por defecto.
     * @since 4.0.1
     */
    public Configuracion(){
        duracion = 1;
        voz = "Leonor";
        solas = true;      
    }
    
    /**Guarda en el archivo <i>config.dat</i> la configuración actual.
     * 
     * @throws IOException Si no es capaz de abrir el archivo.
     * @since 3.5
     */
    public void guardar() throws IOException
    {
        try {
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file= new ObjectOutputStream(new FileOutputStream("config.dat"));
            //Se escribe el objeto en archivo
            file.writeObject(this);
            //se cierra archivo
            file.close();
            } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    /**Carga el archivo <i>config.dat</i> la configuración actual.
     * 
     * @throws IOException Si no es capaz de abrir el archivo.
     * @since 3.5
     */
     public void cargar(){
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("config.dat"));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            Configuracion pepe = (Configuracion) file.readObject();
            //se cierra archivo
            file.close();
            this.duracion = pepe.getDuracion();
            this.voz = pepe.getVoz();
            this.solas = pepe.isSolas();            
        } catch (ClassNotFoundException | IOException ex) {
             System.out.println(ex);
        }
    }
    
    /**Comprueba si existe el archivo <i>config.dat</i> existe.
     * 
     * @return TRUE si existe.<br/>FALSE en caso contrario.
     * @since 3.5
     */
    public boolean existe(){
        File f = new File("config.dat");
        return(f.exists());
    }
    
    /**Representa la configuración.<br/>
     * 
     * @return Un String con la configuración.
     * @since 3.5
     */
    public String toString(){
        return("Duracion: "+duracion+"\n Voz: "+voz+"\n Solas: "+solas);
    }
    
    /**La duración de la partida.
     * @return La duración.
     * @since 3.5
     */
    public byte getDuracion() {
        return duracion;
    }

    /**Cambia la duración de la partida.
     * @param duracion La duración de la partida.<br/><ol><li>CORTA <i>(40 bolas)</i></li><li>MEDIA <i>(60 bolas)</i></li><li>LARGA <i>(90 bolas)</i></li></0l>
     * @since 3.5
     */
    public void setDuracion(int duracion) throws IOException {
        if(1<= duracion && duracion <= 3){
        this.duracion = (byte) duracion;
        this.guardar();
        }
    }

    /**La voz desde la cual se van a reproducir los sonidos.
     * @return El nombre de la voz.
     * @since 3.5
     */
    public String getVoz() {
        return voz;
    }

    /**Cambia la voz desde la cual se van a reproducir los sonidos.
     * @param voz La voz a cambiar.
     * @since 3.5
     */
    public void setVoz(String voz) {
        int i = 0;
        boolean contenido = false;
        while(i<getVoces().length && !(contenido)){
            contenido = (getVoces()[i].equals(voz));
        }
    }

    /**¿Se pasan solas las bolas?
     * @return Si se van a pasar solas las bolas o no.
     * @since 3.5
     */
    public boolean isSolas() {
        return solas;
    }

    /**Cambia si se pasan solas las bolas.
     * @param solas TRUE si se pueden pasar solas.<br/>FALSE en caso contrario.
     * @since 3.5
     */
    public void setSolas(boolean solas) {
        this.solas = solas;
    }

    /**Lista de voces posibles.
     * @return Las posibles voces
     * @since 4.0.3
     */
    public String[] getVoces() {
        return (new File("Sonidos/").list());
    }

}