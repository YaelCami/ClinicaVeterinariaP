package co.edu.uniquindio.poo.clinicaveterinariap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
    private String nombre;
    private String direccion;
    private Sede sede;
    private List<Propietario> listPropietarios;
    private List<Mascota> listMascotas;
    private List<Veterinario> listVeterinarios;
    private List<Secretaria> listSecretarias;
    private List<Aseo> listAseos;
    private List<Cita> listCitas;
    private List<Consulta> listConsultas;
    private List<Tratamiento> listTratamientos;

    public Veterinaria(String nombre, String direccion, Sede sede) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sede = sede;
        this.listPropietarios = new ArrayList<>();
        this.listMascotas = new ArrayList<>();
        this.listVeterinarios = new ArrayList<>();
        this.listSecretarias = new ArrayList<>();
        this.listAseos = new ArrayList<>();
        this.listCitas = new ArrayList<>();
        this.listConsultas = new ArrayList<>();
    }

    public boolean verificarPropietario(String id) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarMascota(String id) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarVeterinario(String id) {
        boolean centinela = false;
        for (Veterinario veterinario : listVeterinarios) {
            if (veterinario.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarSecretaria(String id) {
        boolean centinela = false;
        for (Secretaria secretaria : listSecretarias) {
            if (secretaria.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarAseo(String id) {
        boolean centinela = false;
        for (Aseo aseo : listAseos) {
            if (aseo.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarConsulta(String id) {
        boolean centinela = false;
        for (Consulta consulta : listConsultas) {
            if (consulta.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCita(String id) {
        boolean centinela = false;
        for (Cita cita : listCitas) {
            if (cita.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarTratamiento(String id) {
        boolean centinela = false;
        for (Tratamiento t: listTratamientos) {
            if (t.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean eliminarPropietario(String id) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getId().equals(id)) {
                listPropietarios.remove(propietario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarMascota(String id) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getId().equals(id)) {
                listMascotas.remove(mascota);
                centinela = true;
                break;
            }

        }
        return centinela;
    }

    public boolean eliminarVeterinario(String id) {
        boolean centinela = false;
        for (Veterinario veterinario : listVeterinarios) {
            if (veterinario.getId().equals(id)) {
                listVeterinarios.remove(veterinario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarSecretaria(String id) {
        boolean centinela = false;
        for (Secretaria secretaria : listSecretarias) {
            if (secretaria.getId().equals(id)) {
                listSecretarias.remove(secretaria);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarAseo(String id) {
        boolean centinela = false;
        for (Aseo aseo : listAseos) {
            if (aseo.getId().equals(id)) {
                listAseos.remove(aseo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarCita(String id) {
        boolean centinela = false;
        for (Cita cita : listCitas) {
            if (cita.getId().equals(id)) {
                listCitas.remove(cita);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarConsulta(String id) {
        boolean centinela = false;
        for (Consulta consulta : listConsultas) {
            if (consulta.getId().equals(id)) {
                listConsultas.remove(consulta);
                centinela = true;
                break;
            }
        }
        return centinela;

    }

    public boolean eliminarTratamiento(String id) {
        boolean centinela = false;
        for (Tratamiento tratamiento : listTratamientos) {
            if (tratamiento.getId().equals(id)) {
                listTratamientos.remove(tratamiento);
                centinela = true;
                break;
            }
        }
        return centinela;

    }

    public boolean agregarPropietario(Propietario propietario) {
        boolean centinela = false;
        for (Propietario p : listPropietarios) {
            if (!verificarPropietario(propietario.getId())) {
                listPropietarios.add(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarMascota(Mascota mascota) {
        boolean centinela = false;
        for (Mascota m : listMascotas) {
            if (!verificarMascota(m.getId())) {
                listMascotas.add(m);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarVeterinario(Veterinario veterinario) {
        boolean centinela = false;
        for (Veterinario v : listVeterinarios) {
            if (!verificarVeterinario(v.getId())) {
                listVeterinarios.add(v);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarSecretaria(Secretaria secretaria) {
        boolean centinela = false;
        for (Secretaria s : listSecretarias) {
            if (!verificarSecretaria(s.getId())) {
                listSecretarias.add(s);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarAseo(Aseo aseo) {
        boolean centinela = false;
        for (Aseo as : listAseos) {
            if (!verificarAseo(aseo.getId())) {
                listAseos.add(as);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarCita(Cita cita) {
        boolean centinela = false;
        for (Cita c : listCitas) {
            if (!verificarCita(cita.getId()) && disponibilidadCitas(c)) {
                listCitas.add(c);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarConsulta(Consulta consulta) {
        boolean centinela = false;
        for (Consulta co : listConsultas) {
            if (!verificarConsulta(consulta.getId())) {
                listConsultas.add(co);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarTratamiento(Tratamiento tratamiento) {
        boolean centinela = false;
        for (Tratamiento t : listTratamientos) {
            if (!verificarTratamiento(t.getId())) {
                listTratamientos.add(t);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarPropietario(String id, Propietario actualizado) {
        boolean centinela = false;
        for (Propietario p : listPropietarios) {
            if (p.getId().equals(id)) {
                p.setNombre(actualizado.getNombre());
                p.setId(actualizado.getId());
                p.setTelefono(actualizado.getTelefono());
                p.setDireccion(actualizado.getDireccion());
                centinela = true;
                break;
            }
        }
        return centinela;

    }

    public boolean actualizarMascota(String id, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota a : listMascotas) {
            if (a.getId().equals(id)) {
                a.setNombre(actualizado.getNombre());
                a.setRaza(actualizado.getRaza());
                a.setEdad(actualizado.getEdad());
                a.setId(actualizado.getId());
                a.setEspecie(actualizado.getEspecie());
                a.setPropietario(actualizado.getPropietario());
                centinela = true;
                break;

            }
        }
        return centinela;
    }

    public boolean actualizarVeterinario(String id, Veterinario actualizado) {
        boolean centinela = false;
        for (Veterinario v : listVeterinarios) {
            if (v.getId().equals(id)) {
                v.setNombre(actualizado.getNombre());
                v.setId(actualizado.getId());
                v.setLicencia(actualizado.getLicencia());
                v.setEspecialidad(actualizado.getEspecialidad());
                centinela = true;
                break;

            }
        }
        return centinela;
    }


    public boolean actualizarSecretaria(String id, Secretaria actualizado) {
        boolean centinela = false;
        for (Secretaria s : listSecretarias) {
            if (s.getId().equals(id)) {
                s.setNombre(actualizado.getNombre());
                s.setId(actualizado.getId());
                s.setSalario(actualizado.getSalario());
                s.setExperiencia(actualizado.getExperiencia());
                centinela = true;
                break;

            }
        }
        return centinela;
    }

    public boolean actualizarAseo(String id, Aseo actualizado) {
        boolean centinela = false;
        for (Aseo as : listAseos) {
            if (as.getId().equals(id)) {
                as.setNombre(actualizado.getNombre());
                as.setId(actualizado.getId());
                as.setSalario(actualizado.getSalario());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCita(String id, Cita actualizado) {
        boolean centinela = false;
        for (Cita c : listCitas) {
            if (c.getId().equals(id)) {
                c.setId(actualizado.getId());
                c.setFecha(actualizado.getFecha());
                c.setHora(actualizado.getHora());
                c.setSede(actualizado.getSede());
                c.setConsultorio(actualizado.getConsultorio());
                c.setMascota(actualizado.getMascota());
                c.setVeterinario(actualizado.getVeterinario());
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean actualizarConsulta(String id, Consulta actualizado) {
        boolean centinela = false;
        for (Consulta a : listConsultas) {
            if (a.getId().equals(id)) {
                a.setId(actualizado.getId());
                a.setMascota(actualizado.getMascota());
                a.setFecha(actualizado.getFecha());
                a.setHora(actualizado.getHora());
                a.setMotivo(actualizado.getMotivo());
                a.setDiagnostico(actualizado.getDiagnostico());
                a.setVeterinario(actualizado.getVeterinario());

            }
        }
        return centinela;
    }
    public boolean actualizarTratamiento(String id, Tratamiento actualizado) {
        boolean centinela = false;
        for(Tratamiento t : listTratamientos){
            if (t.getId().equals(id)) {
                t.setMedicamento(actualizado.getMedicamento());
                t.setId(actualizado.getId());
                t.setDosis(actualizado.getDosis());
                t.setTiempo(actualizado.getTiempo());

            }
        }
        return centinela;
    }

    public Propietario buscarPropietario(String id) {
        for (Propietario p : listPropietarios) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Mascota buscarMascota(String id) {
        for (Mascota m : listMascotas) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public Veterinario buscarVeterinario(String id) {
        for (Veterinario v : listVeterinarios) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public Secretaria buscarSecretaria(String id) {
        for (Secretaria s : listSecretarias) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Aseo buscarAseo(String id) {
        for (Aseo as : listAseos) {
            if (as.getId().equals(id)) {
                return as;
            }
        }
        return null;
    }

    public Cita buscarCita(String id) {
        for (Cita c : listCitas) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Consulta buscarConsulta(String id) {
        for (Consulta a : listConsultas) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    public Tratamiento buscarTramiento(String id) {
        for (Tratamiento t : listTratamientos) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public int cantidadPerros() {
        int perros = 0;
        for (Mascota m : listMascotas) {
            if (m.getEspecie().equals(Especie.PERRO)) {
                perros++;
            }
        }
        return perros;
    }

    public int cantidadGatos() {
        int gatos = 0;
        for (Mascota m : listMascotas) {
            if (m.getEspecie().equals(Especie.GATO)) {
                gatos++;
            }
        }
        return gatos;
    }

    public int cantidadAves() {
        int aves = 0;
        for (Mascota m : listMascotas) {
            if (m.getEspecie().equals(Especie.AVE)) {
                aves++;
            }
        }
        return aves;
    }

    public int cantidadOtrasMascotas() {
        int otros = 0;
        for (Mascota m : listMascotas) {
            if (m.getEspecie().equals(Especie.OTRO)) {
                otros++;
            }
        }
        return otros;
    }

    public List<Cita> hallarListaCitasVeterinario(String id, LocalDate fecha){
        List<Cita> listCitasVeterinario = new ArrayList<>();
        for(Cita c : listCitas){
            if(c.getFecha().equals(fecha) && c.getVeterinario().getId().equals(id)){
                listCitasVeterinario.add(c);
            }

        }
        return listCitasVeterinario;

    }
    public List<Consulta> hallarlistaConsultasMascota(String id){
        List<Consulta> listConsultasMascota = new ArrayList<>();

        for(Consulta c : listConsultas){
            if(c.getMascota().getId().equals(id)){
                listConsultasMascota.add(c);
            }
        }
        return listConsultasMascota;
    }
    public boolean disponibilidadCitas(Cita citanueva) {
        boolean disponibilidad = true;
        for (Cita c : listCitas) {
            if (c.getFecha().equals(citanueva.getFecha()) && c.getHora().equals(citanueva.getHora()) && c.getVeterinario().equals(citanueva.getVeterinario())) {
                disponibilidad = false;


            }
        }
        return disponibilidad;
    }








    public List<Consulta> getListConsultas() {
        return listConsultas;
    }

    public void setListConsultas(List<Consulta> listConsultas) {
        this.listConsultas = listConsultas;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Propietario> getListPropietarios() {
        return listPropietarios;
    }

    public void setListPropietarios(List<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public List<Veterinario> getListVeterinarios() {
        return listVeterinarios;
    }

    public void setListVeterinarios(List<Veterinario> listVeterinarios) {
        this.listVeterinarios = listVeterinarios;
    }

    public List<Secretaria> getListSecretarias() {
        return listSecretarias;
    }

    public void setListSecretarias(List<Secretaria> listSecretarias) {
        this.listSecretarias = listSecretarias;
    }

    public List<Aseo> getListAseos() {
        return listAseos;
    }

    public void setListAseos(List<Aseo> listAseos) {
        this.listAseos = listAseos;
    }

    public List<Cita> getListCitas() {
        return listCitas;
    }

    public void setListCitas(List<Cita> listCitas) {
        this.listCitas = listCitas;
    }


}



