package Model;

import java.util.Date;

public class Cuenta_S {
    private int id;
    private int no_Semana;
    private String razonSocial;
    private float utilidad;
    private String tipo;

    public Cuenta_S(int id, int no_Semana, String razonSocial, float utilidad, String tipo) {
        this.id = id;
        this.no_Semana = no_Semana;
        this.razonSocial = razonSocial;
        this.utilidad = utilidad;
        this.tipo = tipo;
    }

    public Cuenta_S(int no_Semana, String razonSocial, float utilidad, String tipo) {
        this.no_Semana = no_Semana;
        this.razonSocial = razonSocial;
        this.utilidad = utilidad;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_Semana() {
        return no_Semana;
    }

    public void setNo_Semana(int no_Semana) {
        this.no_Semana = no_Semana;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(float utilidad) {
        this.utilidad = utilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cuenta_S{" +
                "id=" + id +
                ", no_Semana=" + no_Semana +
                ", razonSocial='" + razonSocial + '\'' +
                ", utilidad=" + utilidad +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
