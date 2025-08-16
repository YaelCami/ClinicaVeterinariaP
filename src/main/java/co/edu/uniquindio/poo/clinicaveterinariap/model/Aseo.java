package co.edu.uniquindio.poo.clinicaveterinariap.model;
public class Aseo extends Personal{


    public Aseo(String nombre, String id, double salario){
        super(nombre, id, salario);
    }

    @Override
    public String toString() {
        return "Aseo{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
