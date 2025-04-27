package com.example.refood;

public class Donacion {

    // Atributos que almacenan la información de la donación
    private String nombreDonante;      // Nombre de la persona o establecimiento que dona
    private String contacto;           // Número de teléfono o forma de contacto
    private String descripcion;        // Descripción de los productos donados
    private String nota;               // Notas adicionales sobre la donación
    private String metodoEntrega;      // Método de entrega: "Recoger" o "Envío"

    /**
     * Constructor para crear un nuevo objeto Donacion
     */

    public Donacion(String metodoEntrega, String nota, String descripcion, String contacto, String nombreDonante) {
        this.metodoEntrega = metodoEntrega;
        this.nota = nota;
        this.descripcion = descripcion;
        this.contacto = contacto;
        this.nombreDonante = nombreDonante;
    }

    // Métodos getter para acceder a los atributos privados

    public String getNombreDonante() {
        return nombreDonante;
    }

    public String getContacto() {
        return contacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNota() {
        return nota;
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }
}
