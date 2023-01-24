
package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import modelo.DatosMeteorologicos;
import modelo.GestoraDatosMeteorologicos;

/**
 *
 * @author Marcos Miranda
 */
public class Main {

    
    public static void main(String[] args) throws IOException {
        

        File ficheroTxt = new File("datos.txt");           // fichero 
       GestoraDatosMeteorologicos picazo=new GestoraDatosMeteorologicos(); 
        ArrayList<DatosMeteorologicos> listaDatosMeteorologicos= new ArrayList<>();
        
        System.out.println(picazo.leerFichero(ficheroTxt));
        System.out.println(picazo.aniadirDatosLista(ficheroTxt));
        System.out.println("Temperatura minima , dia y ciudad:"+picazo.mostrarTemperaturaMinima());
        System.out.println("Temperaturas medias" +picazo.temperaturasMediasCiudades());
        System.out.println(picazo.eliminarRegistrosMesDeseado("oviedo"));       
        System.out.println(picazo.crearCSV("Oviedo"));       
        System.out.println(picazo.mostrarContenidoLista());
        
       
    }
    
}
