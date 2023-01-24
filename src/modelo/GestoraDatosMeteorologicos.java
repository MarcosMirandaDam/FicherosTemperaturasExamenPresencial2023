package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Marcos Miranda
 */
public class GestoraDatosMeteorologicos {

    /**
     * ALmacenaremos los datos en un ArrayList
     */
    ArrayList<DatosMeteorologicos> listaDatosMeteorologicos= new ArrayList<>();

    /**
     * fichero de texto obtenido a partir del JSON descargado.
     */
    private final String ficheroTxt = "datos.txt"; // fichero estatico, y final

    

    /**
     * metodo que crea y añade un registro meteorologico
     *
     * @param ciudad
     * @param dia
     * @param temperaturaMin
     * @param temperaturaMax
     * @param temperaturaMedia
     * @return
     */
    public boolean crearRegistroClimatológico(String ciudad, String dia, int temperaturaMin, int temperaturaMax, int temperaturaMedia) {
        if (listaDatosMeteorologicos.add(new DatosMeteorologicos(ciudad, dia, temperaturaMin, temperaturaMax, temperaturaMedia))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * lee el contenido del fichero, limpia de lo que desees, "," , " ", comas,
     * espacios, etc...
     *
     * @param fichero
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String leerFichero(File fichero) throws FileNotFoundException, IOException {
        String contenido = "";
        String linea;
        String texto;
        if (!fichero.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        while ((linea = br.readLine()) != null) {
            contenido += linea;
        }
        texto = contenido.replaceAll(",", "");
        return texto;
    }

    /**
     * leer del fichero y añadir a la lista deseada
     *
     * @param fichero
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public List<DatosMeteorologicos> aniadirDatosLista(File fichero) throws FileNotFoundException, IOException {
        if (!fichero.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader br = new BufferedReader(new FileReader(ficheroTxt));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            String ciudad = st.nextToken();
            String dia = st.nextToken();
            int temperaturaMin = Integer.parseInt(st.nextToken().trim());
            int temperaturaMax = Integer.parseInt(st.nextToken().trim());
            int temperaturaMedia = Integer.parseInt(st.nextToken().trim());

            listaDatosMeteorologicos.add(new DatosMeteorologicos(ciudad, dia, temperaturaMin, temperaturaMax, temperaturaMedia));

        }
        return listaDatosMeteorologicos;
        
    }

    /**
     * muestra los registros introducidos
     *
     * @return
     */
    public String mostrarContenidoLista() {
        String datos = "";
        for (int i = 0; i < listaDatosMeteorologicos.size(); i++) {
            datos += listaDatosMeteorologicos.get(i).toString() + "\n";
        }
        return datos;

    }

    /**
     * ¿Qué dia fue la mínima temperatura y dónde?
     *
     * @return
     */
    public String mostrarTemperaturaMinima() {
        String resultado="";
        DatosMeteorologicos datos=Collections.min(listaDatosMeteorologicos, Comparator.comparing(s->s.getTemperaturaMin()));
        resultado+=+datos.getTemperaturaMin()+" grados " + " el dia "+datos.getDia()+ " en la ciudad de "+datos.getCiudad();
        return resultado;
    }


    /**
     * -Retornar un Hashmap con la media de la temperatura de cada ciudad.
     *
     * @return
     */
    public Map<String, Integer> temperaturasMediasCiudades() {
        Map<String, Integer> mapTemperaturasMediasCiudades = new HashMap<>();
        for (DatosMeteorologicos dato : listaDatosMeteorologicos) {
            mapTemperaturasMediasCiudades.put(dato.getCiudad(), dato.getTemperaturaMedia());
        }
        return mapTemperaturasMediasCiudades;

    }

    /**
     * -Crear un método que recibe como parámetro el nombre de una ciudad y crea
     * un fichero csv con todos los datos de esa ciudad. Ejemplo recibe Oviedo y
     * crea oviedo.csv con los datos de esa ciudad.
     */
    
    public boolean crearCSV(String nombreCiudad) throws IOException{
        String CiudadDatos="";
        String nombreArchivo = "datosCiudad.csv";
        
           
           Map<String, List<String>> hashmapCiudadDatosMetereologicos = new HashMap<>();
           List<String> listaDatos=new ArrayList<>();
            for (DatosMeteorologicos dato : listaDatosMeteorologicos) {
                listaDatos.add(dato.getDia());
                listaDatos.add(String.valueOf(dato.getTemperaturaMin()));
                listaDatos.add(String.valueOf(dato.getTemperaturaMax()));
                listaDatos.add(String.valueOf(dato.getTemperaturaMedia()));
                hashmapCiudadDatosMetereologicos.put(nombreCiudad, listaDatos);
            }
            
            for (Map.Entry<String, List<String>> entry : hashmapCiudadDatosMetereologicos.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                CiudadDatos=key + ":" + value + "\n";
              
               FileWriter fw=new FileWriter(nombreArchivo);
               fw.write(CiudadDatos);
               fw.close();
               
        }

        return true;

    }
        
    
    
    
    
    
    /**
     * -Crear un método que elimina todas las líneas de un determinado mes
     * (especificado por un número).Pista: Usar un patrón (expresión regular)
     *
     * @param listaDatosMeteorologicos
     * @param diaBorrar
     * @return
     */
    
    public boolean eliminarRegistrosMesDeseado(String diaBorrar) {
       boolean borrado=false;
        for (Iterator<DatosMeteorologicos> iterator = listaDatosMeteorologicos.iterator(); iterator.hasNext();) {
            DatosMeteorologicos next = iterator.next();
            if(next.getCiudad().equalsIgnoreCase(diaBorrar)){
                iterator.remove();
                borrado=true;
            }
        }
        return borrado;
}
}