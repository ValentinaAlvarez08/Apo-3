/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.Date;

/**
 *
 * @author 
 *Anyeli Jaramillo 
 *Valentina Alvarez
 */
public class DiarioPersonal {
    //Atributos
    private int idEntrada;
    private String fecha;
    private String descripcion;
    
     //Constructor vacio

    public DiarioPersonal() {
    }
    //Constructor lleno 

    public DiarioPersonal(int idEntrada, String fecha, String descripcion) {
        this.idEntrada = idEntrada;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

   
    

    
    
    
    //getters

    public int getIdEntrada() {
        return idEntrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
    

   
    public String getDescripcion() {
        return descripcion;
    }
    //setters

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
