
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
        System.out.println(picazo.mostrarTemperaturaMinima());
        System.out.println(picazo.temperaturasMediasCiudades());
        boolean registroBorrado=picazo.eliminarRegistrosMesDeseado("1/3/22");
        if(registroBorrado){
            System.out.println("borrado con exito");
        } else{
            System.out.println("no se ha borrado");
        } 
            
        
        System.out.println(picazo.crearCSV("Oviedo"));       
        System.out.println(picazo.mostrarContenidoLista());
        
       
    }
    
}
