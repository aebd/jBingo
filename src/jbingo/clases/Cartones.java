package jbingo.clases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**Clase Cartones.<br/>
 * En ella se implementan los métodos para generar los cartones.
 *
 * @author Jesús Alcalde Alcázar
 * @version 3.5
 */
public class Cartones {
    
    /**Constructor de la clase cartones.
     * 
     * @param numbolas Bolas del juego.
     * @param numcartones Numero de cartones a generar.
     * @param dirarchivo Donde guardar el archivo.
     * @since 3.5
     */
    public Cartones(int numbolas,int numcartones,String dirarchivo){
        try {
            PrintStream archivo = new PrintStream (new FileOutputStream(dirarchivo));
            for(int i =1;i<=numcartones;i++){
                archivo.println("Carton Nº"+i);
                archivo.println();
                archivo.println(generar(numbolas));
                archivo.println();
                archivo.println();
            }
        } catch (FileNotFoundException ex){}
    }
    
    /**Método privado que genera los cartones.<br/>
     * Escoge 4 por cada decena de números.
     * 
     * @param numbolas
     * @return Un String con los números del cartón
     * @since 3.5
     */
    private String generar(int numbolas){
        String salida = ("");
        Bombo bolas = new Bombo(numbolas);
        for(int i =1;i<(numbolas/10*4);i++){      
            salida += (" "+bolas.sacar());
        }
        return(salida);
    }
}
