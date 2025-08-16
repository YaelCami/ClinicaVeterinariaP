package co.edu.uniquindio.poo.clinicaveterinariap.model;

import java.util.List;

public class Veterinario extends Persona {
    private String licencia;
    private Especialidad especialidad;
    private Veterinaria veterinaria;
    private List<Consulta> consultas;

    public Veterinario(String nombre, String id, String licencia, Especialidad especialidad) {
        super(nombre, id);
        this.licencia = licencia;
        this.especialidad = especialidad;

    }
    public void eliminarConsulta(String id) {

        veterinaria.eliminarConsulta(id);
    }
    public void agregarConsulta(Consulta consulta){

        veterinaria.agregarConsulta(consulta);
    }
    public void actualizarConsulta(String id, Consulta consulta){

        veterinaria.actualizarConsulta(id, consulta);
    }



    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }


}
