package jbingo.clases;

import java.io.IOException;
import java.util.Scanner;

/**Clase principal de jBingo.
 *
 * @author Jesús Alcalde Alcázar
 * @version 3.5
 */
public class Consola {

    /**Método principal.
     * @param args Linea de comandos de argumentos.
     * @since 3.5
     */
    public static void main(String[] args) throws IOException, Exception {
        
        Configuracion conf = new Configuracion();
        if(conf.existe()){
            conf.cargar();
            System.out.println("Cargando configuracion...");
            System.out.println(conf.toString());
        }else{
            System.out.println("Generando archivo de configuracion config.dat por defecto...");
            conf.guardar();
        }
        int numbolas=0;
        limpiarpantalla();
        boolean salir = false;
        switch(conf.getDuracion()){
                            case 1:numbolas=40;break;
                            case 2:numbolas=60;break;
                            case 3:numbolas=90;break;
                        }
        do{
            menu();
            Scanner leer = new Scanner(System.in);
            switch(leer.nextInt()){
                case 1:switch(conf.getDuracion()){
                            case 1:numbolas=40;break;
                            case 2:numbolas=60;break;
                            case 3:numbolas=90;break;
                        }
                       Bombo bingo = new Bombo(numbolas);
                       System.out.println("Creando un bombo de "+bingo.tamaño()+" bolas...");
                       System.out.println("Pulsa enter para que vayan saliendo las bolas.");
                       do{
                            Scanner leer2 = new Scanner(System.in);
                            Sonido sonido = new Sonido();
                            if(leer2.hasNextLine()){
                                int i = bingo.sacar();
                                System.out.print((i/10)+""+(i%10));
                                sonido.reproducir(conf.getVoz(),i);
                            }
                       }while(bingo.tamaño()>0);
                       break;
                case 2:Scanner leer2 = new Scanner(System.in);
                       System.out.print("Cuantos cartones quieres generar :");
                       int numcartones = leer2.nextInt();
                       leer2 = new Scanner(System.in);
                       System.out.print("Donde quieres guardarlo :");
                       Cartones cartones = new Cartones(numbolas,numcartones,leer2.nextLine());
                       break;
                case 3:boolean salir2=false;
                       do{
                           menuConf(conf.getDuracion(),conf.getVoz());
                           leer2 = new Scanner(System.in);
                           int opcion = leer2.nextInt();
                           switch(opcion){
                               case 1:Scanner leer3 = new Scanner(System.in);
                                      System.out.print("Como quieres que sea la partida [1-3]");
                                      int opcion2 = leer3.nextInt();
                                      if(opcion2>=1 && opcion2<=3){
                                          conf.setDuracion(opcion2);
                                      }
                                      break;
                               case 2:case 3:System.out.println("NOT IMPLEMENTES YET");
                                             leer2 = new Scanner(System.in);
                                             leer2.nextLine();
                                             break;
                               case 4: conf = new Configuracion();break;
                               case 5:salir2=true;break;
                           }
                       }while(!(salir2));
                       break;
                case 4:salir=true;
                       break;
               }
        }while(!(salir));
        
        
        
    }
    
   public static void limpiarpantalla(){
       for(int i=0;i<25;i++){
           System.out.println();
       }
   }
   
   public static void menu(){
       System.out.println("**********************************");
       System.out.println("*                                *");
       System.out.println("*           jBingo"+(char)169+" v4.0         *");
       System.out.println("*                                *");
       System.out.println("**********************************");
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("Bienvenido, escoge entre estas opciones:");
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("1.- JUGAR");
       System.out.println();
       System.out.println("2.- CARTONES");
       System.out.println();
       System.out.println();
       System.out.println("3.- CONFIGURACION");
       System.out.println();
       System.out.println();
       System.out.println("4.- SALIR");
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.print("Que quieres hacer : ");
   }
   public static void menuConf(int duracion,String voz){
       System.out.println("**********************************");
       System.out.println("*                                *");
       System.out.println("*           jBingo"+(char)169+" v4.0         *");
       System.out.println("*                                *");
       System.out.println("**********************************");
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("Estas son las opciones disponibles para modificar:");
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.print("1.Duracion de la partida: ");
       switch(duracion){
            case 1:System.out.println("CORTA");break;
            case 2:System.out.println("MEDIA");break;
            case 3:System.out.println("LARGA");break;
        }
       System.out.println();
       System.out.println("2.Voz: "+voz);
       System.out.println();
       System.out.println("3.Pasar bolas automaticamente: NO");
       System.out.println(); 
       System.out.println();
       System.out.println("4.Valores Por Defecto");
       System.out.println();
       System.out.println("5.- VOLVER");
       System.out.println();
       System.out.println();
       System.out.print("Que quieres cambiar : ");
   }
}
