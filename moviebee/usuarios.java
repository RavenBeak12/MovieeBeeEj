package com.example.moviebee;

import android.widget.TextView;

public class usuarios {//nuevo

    public String Correo;
    public String contraseña;
    public String numtelefono;
    public String dinero;
    private String color;
    private String Fecha;
    private String CodSeguridad;

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getCodSeguridad() {
        return CodSeguridad;
    }

    public void setCodSeguridad(String codSeguridad) {
        CodSeguridad = codSeguridad;
    }


    public usuarios(String fecha, String codSeguridad) {
        Fecha = fecha;
        CodSeguridad = codSeguridad;
    }



    public usuarios(String registro, int listusuarios) {
    }


    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumtelefono() {
        return numtelefono;
    }

    public void setNumtelefono(String numtelefono) {
        this.numtelefono = numtelefono;
    }

    public String getDinero() {
        return dinero;
    }

    public void setDinero(String dinero) {
        this.dinero = dinero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }




    public usuarios(String correo, String contraseña, String numtelefono) {
        this.Correo = correo;
        this.contraseña = contraseña;
        this.numtelefono = numtelefono;
    }

    public usuarios(String correo, String contraseña, String numtelefono, String dinero) {
        Correo = correo;
        this.contraseña = contraseña;
        this.numtelefono = numtelefono;
        this.dinero = dinero;
    }
}
