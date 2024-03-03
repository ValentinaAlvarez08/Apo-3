/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author valea
 */
public class Perro {
     private  String nombre;
    private String raza;
    private int edad;
    private int puntuacion;
    private String foto;
    
    //constructor vacio

    public Perro() {
    }
    //constructor lleno

    public Perro(String nombre, String raza, int edad, int puntuacion, String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.puntuacion = puntuacion;
        this.foto = foto;
    }
    //setters y getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}


