package modelo;

/**
 *
 * @author sssoc
 */
public class DatosMeteorologicos {

    private String ciudad;
    private String dia;
    private int temperaturaMin;
    private int temperaturaMax;
    private int temperaturaMedia;

    public DatosMeteorologicos(String ciudad, String dia, int temperaturaMin, int temperaturaMax, int temperaturaMedia) {
        this.ciudad = ciudad;
        this.dia = dia;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMedia = temperaturaMedia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(int temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public int getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(int temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public int getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(int temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    @Override
    public String toString() {
        return "DatosMeteorologicos{" + "ciudad=" + ciudad + ", dia=" + dia + ", temperaturaMin=" + temperaturaMin + ", temperaturaMax=" + temperaturaMax + ", temperaturaMedia=" + temperaturaMedia + '}';
    }

    
}
