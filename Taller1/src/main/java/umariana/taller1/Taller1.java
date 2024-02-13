/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.taller1;

import Mundo.Tarea;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Valentina Alvarez
 */
public class Taller1 {

    public static void main(String[] args) {
        Scanner lector= new Scanner (System.in);
        
        //Creacion del ArrayList
         ArrayList<Tarea>  misTareas=new ArrayList <>();
        
        boolean activo=true;
        
        do{
            System.out.println("-----menu de opciones------\n"
                    + "agregar tarea\n"
                    + "mostrar tareas\n"
                    + "terminar programa\n"
                    );
            int opcion = lector.nextInt();
            
            switch (opcion){
                case 1:
                     System.out.println("Opcion 1");
                     
                         System.out.println("ingrese el Id de la tarea");
                         int idTarea= lector.nextInt(); lector.nextLine();
                         System.out.println("ingrese la descripcion de la tarea");
                         String descripcion = lector.nextLine();
                         System.out.println("ingrese la prioridad de 1-5");
                         int prioridad=lector.nextInt();
                         
                         
                         //creacion del objeto y llenar la informacion 
                         Tarea nuevaTarea= new Tarea (idTarea, descripcion, prioridad);
                         
                         //Almacenar el objeto a la contenedora
                         misTareas.add(nuevaTarea);
                         
                         System.out.println("Tarea agregada satisfactoriamente");
                         
                     break;
            
                case 2:
                     System.out.println("Opcion 2");
                        System.out.println("-------TAREAS REGISTRADAS------");
                        
                        // Tareas ordenadas por prioridad con orden descendente
                                for (int i = 5;i >=1 ; i--){
                                    for (Tarea tarea : misTareas){
                                        if(tarea.getPrioridad() ==i){
                                    
                            System.out.println("id: \n"+ tarea.getIdTarea()); 
                            System.out.println("descripcion: \n" + tarea.getDescripcion());
                            System.out.println("prioridad: \n" + tarea.getPrioridad());
                            System.out.println("--------------------------");
                        }
            }        
        }
                     break;
                case 3:
                    System.out.println("programa terminado");
                    break;
                default :
                     System.out.println("opcion no valida");
                     break;
            }
            
            
        }while (activo);
    
}
}