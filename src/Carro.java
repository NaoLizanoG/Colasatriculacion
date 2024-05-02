import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
public class Carro {
    private String propietario;
    private String marca;
    private int anio;

    public Carro(String propietario, String marca, int anio) {
        this.propietario = propietario;
        this.marca = marca;
        this.anio = anio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double calcularValorMatricula(){
        GregorianCalendar gc = new GregorianCalendar();
        int anioActual = gc.get(Calendar.YEAR);
        return 250-(5*(anioActual-this.anio));
    }

    @ Override
    public String toString(){
        return "*********Auto**********"+"\nPropietario: "+propietario+"\nMarca: "+marca+"\nAño: "+anio;
    }
}
