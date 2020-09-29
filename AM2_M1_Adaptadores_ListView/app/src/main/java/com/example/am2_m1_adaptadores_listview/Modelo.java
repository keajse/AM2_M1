package com.example.am2_m1_adaptadores_listview;

public class Modelo {
    private String nombre;
    private String fchNacimiento;
    private int imagenview;

        public Modelo(String nombre, String fchNacimiento, int imagenview){
            this.nombre = nombre;
            this.fchNacimiento = fchNacimiento;
            this.imagenview = imagenview;
        }


    public String getFchNacimiento() {
        return fchNacimiento;
    }

    public void setFchNacimiento(String fchNacimiento) {
        this.fchNacimiento = fchNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getImagenview() {
        return imagenview;
    }

    public void setImagenview(int imagenview) {
        this.imagenview = imagenview;
    }
}
