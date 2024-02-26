/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.taller3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import mundo.DiarioPersonal;

/**
 *
 * @author valea
 */
public class Taller3 {
    private  ArrayList<DiarioPersonal> miDiario;
    private  Scanner lector;
    
    public Taller3() {
        //Permite inicializar los productos de una clase
        miDiario= new ArrayList<>();
        lector = new Scanner(System.in);

    }
    
     public void mostrarMenu() {
        boolean activo = true;
        
        do {
            //Imprimir el Menu
            System.out.println("====== Menu de opciones ======");
            System.out.println("1. Agregar Entrada");
            System.out.println("2. Consultar Entrada");
            System.out.println("3. Eliminar Entrada");
            System.out.println("4. Modificar entrada");
            System.out.println("5. Salir");
            System.out.println("Digite su opción");
            System.out.println("=======================================");
            
            
            //Lee las opciones del usuario
            int opcion = lector.nextInt();
                //Ejecuta la accion, de opcion selecionada
                switch (opcion) {
                    
                     case 1:
                   //Llama al metodo que Agrega la entrada
                    agregarEntrada();
                    break;
                case 2:
                    if (miDiario.size() == 0) {
                        System.out.println("No hay entradas agregadas.");
                    } else {
                        //Llama al metodo que llama a miDiario
                        consultarEntrada();
                    }
                    break;
                case 3:
                    if (miDiario.size() == 0) {
                        System.out.println("No hay entradas agregadas.");
                    } else {
                        //Permite modificar las entradas
                        eliminarEntrada();
                      
                    }
                    break;

                case 4:
                    if(miDiario.size()==0){
                        System.out.println("No hay entradas agregadas");
                    } else {
                        //Llama al metodo y elimina la entrada
                      modificarEntrada();
                    }
                    break;
                case 5:
                    //Cambia la variable para salir del menu
                    activo = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    //Para opciones invalidas
                    System.out.println("opcion no valida");
            }
        } 
        //Bucle para cuando se cumple las variables
        while (activo);
     }
        
        public void agregarEntrada() {
            lector.nextLine();
        //Obtener la descripción
        System.out.println("Ingrese la nueva descripcion: ");
        String descripcion =lector.nextLine();
        System.out.println("===========================================");
        //Obtener el ultimo idEntrada ingresado
        int nuevoIdEntrada = 1;
        if (!miDiario.isEmpty()) {
        DiarioPersonal ultimaEntrada = miDiario.get(miDiario.size() - 1);
        nuevoIdEntrada = ultimaEntrada.getIdEntrada() + 1;
        }
        //Obtener la fecha del sistema
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoFecha.format(fechaActual);
        // Crear una nueva entrada y agregarla a la lista
        DiarioPersonal nuevaEntrada = new DiarioPersonal(nuevoIdEntrada, fecha, descripcion);
        miDiario.add(nuevaEntrada);

        System.out.println("La entrada fue agregada satisfacctoriamente");
        }
          public void consultarEntrada() {
        
                        System.out.println("==== Consulte su entrada ====");
                        //Repite la informacion del inventario
                        for(DiarioPersonal diario: miDiario){
                            System.out.println("idEntrada: "+diario.getIdEntrada());
                            System.out.println("Fecha: "+diario.getFecha());
                            Date fecha=new Date();
                            System.out.println("Descripcion: "+diario.getDescripcion());
                            System.out.println("==================");
                        }  
          }
          
          public void eliminarEntrada(){
              
        System.out.println("Digite el Id del La Entrada que quiere eliminar");
                    int id = lector.nextInt();
                        for(DiarioPersonal e: miDiario){
                        if(e.getIdEntrada()== id){
		                    System.out.println("¿Esta seguro de eliminar esta Entrada?");
		                    System.out.println("Ingrese: 1 para eliminar o 2 para Salir: ");
		                    int opcion = lector.nextInt();
		                    if (opcion == 1) {
		                        miDiario.remove(e);
		                        System.out.println("La Entrada con Id: " + id + " ha sido eliminado.");
		                    } else if(opcion==2){
		                        System.out.println("La Entrada no ha sido eliminado.");
		                    }
		                    break;
		                } else{
		                System.out.println("No se encontro ninguna Entradao con ese Id.");
		            }
                        }
          }

       
              public void modificarEntrada(){
              System.out.println("Digite el Id de la entrada que quiere modificar");
        int id = lector.nextInt();
        boolean encontrado = false;

        for (DiarioPersonal entrada : miDiario) {
            if (entrada.getIdEntrada() == id) {
                System.out.println("Ingrese la nueva descripción:");
                lector.nextLine(); // Consume la nueva línea pendiente
                String nuevaDescripcion = lector.nextLine();
                entrada.setDescripcion(nuevaDescripcion);
                encontrado = true;
                System.out.println("Entrada modificada satisfactoriamente");
   
              break;   
            }

        }
         }
     
         public static void main(String[] args) {
        //Crea un Objeto de la clase tienda1
        Taller3 organizador = new Taller3();
        //Llama al metodo de mostrarmenu de Opciones para la ejecutacion
        organizador.mostrarMenu();
                     }
    

}