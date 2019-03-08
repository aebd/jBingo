package jbingo.clases;

import java.util.ArrayList;

/**Clase de tipo bombo.<br/>
 * En el <b><i>bombo</i></b> se encuentran las bolas del juego.
 *
 * @author Jesús Alcalde Alcázar
 * @version 3.5
 */
public class Bombo {
    
    /**
     * Atributo que contiene las bolas.
     */
    private ArrayList bolas;
    
    /**Constructor dado el número de bolas a generar.<br/>
     * Inserta una a una las bolas por orden, al acabar las mezcla.
     * 
     * @param numbolas Numero total de bolas, de <i>1 - <b>numbolas</b></i>.
     * @since 3.5
     */
    public Bombo(int numbolas){
        bolas = new ArrayList<>(numbolas);
        for(int i = 1;i<=numbolas;i++){
            bolas.add(i);
        }
        this.mezclar();
    }
    
    /**Método privado que se encarga de mezclar el bombo.<br/><br/>
     * Con la ayuda de un ArrayList temporal, el método devuelve
     * posiciones aleatorias del bombo y borra esos elementos después de
     * introducirlos en el temporal.<br/>
     * Al acabar en el temporal se encuentran la misma cantidad de bolas pero desordenadas.<br/>
     * Se asigna el temporal a bolas. 
     * @since 3.5
     */
    private void mezclar(){
        int i = this.bolas.size();
        ArrayList temp = new ArrayList<>();       
        while(temp.size()<i){
            int j = (int) (Math.random()*(this.bolas.size())); //Numero aleatorio
            temp.add(this.bolas.get(j));
            this.bolas.remove(j);
        }
        this.setBolas(temp);
    }
    
    /**Método que obtiene una bola aleatoria del bombo.<br/>
     * Aquí se encuentra la chicha del asunto, saca una bola de forma aleatoria
     * y después vuelve a mezclar el bombo.
     * 
     * @return La bola seleccionada.
     * @since 3.5
     */
    public int sacar(){
        int i;
        int j = (int) (Math.random()*(this.bolas.size())); //Numero aleatorio
        i = (int) this.bolas.get(j);
        this.bolas.remove(j);
        this.mezclar();
        return i;
    }
    
    /**Método que calcula la cantidad de bolas en el bombo.
     * 
     * @return El número de bolas del bombo.
     * @since 3.5
     */
    public int tamaño(){
        return(this.bolas.size());
    }
    
    /**Método que comprueba si una bola esta en el bombo.
     * 
     * @param bola El número de la bola. 
     * @return TRUE si esta en el bombo.<br/>FALSE si no lo esta.
     * @since 3.5
     */
    public boolean contiene(int bola){
       return(bolas.contains(bola));
    }
    
   /**Añadir una bola al bombo.<br/>
    * Antes se comprueba si ya esta, en ese caso no se añade.
    * 
    * @param bola El número de la bola.
    * @return TRUE si se ha podido añadir.<br/>FALSE en caso contrario.
    * @since 3.5
    */
    public boolean añadir(int bola){     
        return(bolas.contains(bola) ? false:bolas.add(bola));
    }
    
    /**
     * Representa el bombo.<br/>
     * De forma que con llamar a este método queda ya formateado la representación del mismo.
     * 
     * @return La representación del bombo en forma de String.
     * @since 3.5
     */
    public String toString(){
        return(bolas.toString());
    }
    
    /**Método privado que comprueba si un ArrayList de bolas es valido.<br/>
     * Para comprobar si es así comprueba que la primera y la ultima ocurrencia
     * de una bola se exactamente la misma, si no es así es que hay mas de una y
     * no es valido.
     * 
     * @param bolas ArrayList que contiene las bolas.
     * @return TRUE si es valido.<br/>FALSE en caso contrario.
     * @since 3.5
     */
    private boolean esValido(ArrayList bolas){
        boolean comprobar = true;
        int i = 0;
        while(i<=(bolas.size()-1) && comprobar){
            comprobar = ((bolas.indexOf(bolas.get(i))) == (bolas.lastIndexOf(bolas.get(i))));
            i++;            
        }
        return(comprobar);
    }
    /**Devuelve el ArrayList con las bolas.
     * @return ArrayList con las bolas
     * @since 3.5
     */
    public ArrayList getBolas() {
        return bolas;
    }

    /**Cambia el ArrayList de las bolas.<br/>
     * Pero antes comprueba que este sea válido.
     * @param bolas ArrayList de bolas
     * @see #esValido(ArrayList bolas) 
     * @since 3.5
     */
    public void setBolas(ArrayList bolas) {
        if(esValido(bolas)){
        this.bolas = bolas;
        }
    }
}
