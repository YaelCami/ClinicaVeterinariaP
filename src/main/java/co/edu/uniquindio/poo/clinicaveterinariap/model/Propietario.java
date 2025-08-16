package co.edu.uniquindio.poo.clinicaveterinariap.model;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Persona {
    private String telefono;
    private String direccion;
    private List<Mascota> listMascotas;


    public Propietario(String nombre, String id, String telefono, String direccion) {
        super(nombre, id);
        this.telefono = telefono;
        this.direccion = direccion;
        this.listMascotas = new ArrayList<Mascota>();
    }

    public void agregarMascota(Mascota mascota) {
        listMascotas.add(mascota);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }
}
