package org.mvpigs.cotxox.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_conductores")
public class Conductor {

    @Id
    @Column(name="co_tarjeta_credito", nullable = false)
    private String tarjeta;

    @Column(name="co_nombre")
    private String nombre;

    @Column(name="co_modelo")
    private String modelo;

    @Column(name = "co_matricula")
    private String matricula;

    @Column(name = "co_valoracion_media")
    private double valoracionMedia;

    @Column(name = "co_ocupado")
    private boolean ocupado;

    @Transient
    private ArrayList<Byte> valoraciones = new ArrayList<>();

    @Transient
    private Set<Carrera> carreras = new HashSet<>();

    /**
     * Constructores: necesitamos el constructor por defecto
     * para trabajar con Spring JPA
     */

    public Conductor() {
    }

    public Conductor(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Getters y setters
     */

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValoracion() {
        return this.valoracionMedia;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumeroValoraciones() {
        return this.valoraciones.size();
    }

    public void setValoracion(byte valoracion) {
        this.valoraciones.add(valoracion);
        this.calcularValoracionMedia();
    }

    /*
     * Lógica de la clase
     */

    private double calcularValoracionMedia() {
        int sumaValoraciones = 0;
        for (byte valoracion : this.valoraciones) {
            sumaValoraciones += valoracion;
        }
        this.valoracionMedia = (double) sumaValoraciones / this.valoraciones.size();
        return this.valoracionMedia;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

}
