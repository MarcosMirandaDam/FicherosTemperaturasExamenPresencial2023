
package controlador;

import java.io.File;
import java.io.IOException;
import modelo.GestoraDatosMeteorologicos;

/**
 *
 * @author Marcos Miranda
 */
public class Main {

    
    public static void main(String[] args) throws IOException {
        

        File ficheroTxt = new File("datos.txt");           // fichero 
       GestoraDatosMeteorologicos picazo=new GestoraDatosMeteorologicos(); 
       
        System.out.println(picazo.leerFichero(ficheroTxt));
        System.out.println(picazo.aniadirDatosLista(ficheroTxt));
        System.out.println(picazo.mostrarTemperaturaMinima());
        System.out.println(picazo.temperaturasMediasCiudades());
        System.out.println(picazo.eliminarRegistrosMesDeseado(1));
    }
    
}
