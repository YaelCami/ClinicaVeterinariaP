package co.edu.uniquindio.poo.clinicaveterinariap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Personal{
    private String experiencia;
    private Veterinaria veterinaria;
    private List<Propietario> listPropietarios;
    private List<Veterinario> listVeterinarios;
    private List<Mascota> listMascotas;
    private List<Cita> listCitas;

    public Secretaria(String nombre, String id, double salario, String experiencia) {
        super(nombre, id, salario);
        this.experiencia = experiencia;
    }

    public void eliminarVeterinario(String id){
        veterinaria.eliminarVeterinario(id);
    }
    public void eliminarMascota(String id){
        veterinaria.eliminarMascota(id);
    }
    public void eliminarPropietario(String id){
        veterinaria.eliminarPropietario(id);
    }
    public void eliminarSecretaria(String id){
        veterinaria.eliminarSecretaria(id);
    }
    public void eliminarAseo(String id){
        veterinaria.eliminarAseo(id);
    }
    public void eliminarCita(String id){
        veterinaria.eliminarCita(id);
    }

    public void agregarPropietario(Propietario propietario){

        veterinaria.agregarPropietario(propietario);
    }
    public void agregarMascota(Mascota mascota){
        veterinaria.agregarMascota(mascota);
    }
    public void agregarVeterinario(Veterinario veterinario){
        veterinaria.agregarVeterinario(veterinario);
    }
    public void agregarSecretaria(Secretaria secretaria){
        veterinaria.agregarSecretaria(secretaria);
    }
    public void agregarAseo(Aseo aseo){
        veterinaria.agregarAseo(aseo);
    }
    public void agregarCita(Cita cita){
        veterinaria.agregarCita(cita);
    }
    public void actualizarPropietario(String id, Propietario actualizado){
        veterinaria.actualizarPropietario(id, actualizado);
    }
    public void actualizarMascota(String id, Mascota actualizado){
        veterinaria.actualizarMascota(id, actualizado);
    }
    public void actualizarVeterinario(String id, Veterinario actualizado){
        veterinaria.actualizarVeterinario(id, actualizado);
    }
    public void actualizarSecretaria(String id, Secretaria actualizado){
        veterinaria.actualizarSecretaria(id, actualizado);
    }
    public void actualizarAseo(String id, Aseo actualizado){
        veterinaria.actualizarAseo(id, actualizado);
    }
    public void actualizarCita(String id, Cita cita){
        veterinaria.actualizarCita(id, cita);
    }

    public int cantidadPerros(){
        int perros= veterinaria.cantidadPerros();
        return perros;
    }
    public int cantidadGatos(){
        int gatos= veterinaria.cantidadGatos();
        return gatos;
    }
    public int cantidadAves(){
        int aves= veterinaria.cantidadAves();
        return aves;
    }
    public int cantidadOtrasMascotas(){
        int otros= veterinaria.cantidadOtrasMascotas();
        return otros;
    }

    public boolean disponibilidadCitas(Cita citanueva) {
        Boolean disponibilidad= veterinaria.disponibilidadCitas(citanueva);
        return disponibilidad;
    }

    public List<Consulta> hallarlistaConsultasMascota(String id){
        return  veterinaria.hallarlistaConsultasMascota(id);
    }

    public List<Hora> buscarVeterinarioOcupado(String id, LocalDate fecha){
        List<Hora> listVeterinarioOcupado = new ArrayList<>();

        for(Cita c : listCitas){
            if(c.getFecha().equals(fecha) && c.getVeterinario().getId().equals(id)){
                listVeterinarioOcupado.add(c.getHora());

            }
        }
        return listVeterinarioOcupado;

    }

    public List<Hora> disponibilidadVeterinario(String id, LocalDate fecha){
        List<Hora> listVeterinarioLibre = new ArrayList<>();
        for(Cita c : listCitas){
            if(!buscarVeterinarioOcupado(id,fecha).contains(c.getHora())){
                listVeterinarioLibre.add(c.getHora());
            }
        }
        return listVeterinarioLibre;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
        System.out.println("DEBUG - Se asignó veterinaria" +getNombre()+ veterinaria) ;
    }

    public List<Propietario> getListPropietarios() {
        return listPropietarios;
    }

    public void setListPropietarios(List<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    public List<Veterinario> getListVeterinarios() {
        return listVeterinarios;
    }

    public void setListVeterinarios(List<Veterinario> listVeterinarios) {
        this.listVeterinarios = listVeterinarios;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public List<Cita> getListCitas() {
        return listCitas;
    }

    public void setListCitas(List<Cita> listCitas) {
        this.listCitas = listCitas;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }
}
