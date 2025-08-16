package co.edu.uniquindio.poo.clinicaveterinariap.model;

public class Tratamiento {
    private String medicamento, id;
    private String dosis;
    private String tiempo;

    public Tratamiento(String medicamento, String id, String dosis, String tiempo) {
        this.medicamento = medicamento;
        this.id = id;
        this.dosis = dosis;
        this.tiempo = tiempo;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "medicamento='" + medicamento + '\'' +
                ", id='" + id + '\'' +
                ", dosis='" + dosis + '\'' +
                ", tiempo='" + tiempo + '\'' +
                '}';
    }
}

