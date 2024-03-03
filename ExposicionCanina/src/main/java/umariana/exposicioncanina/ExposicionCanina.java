/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.exposicioncanina;

import java.util.ArrayList;
import java.util.Scanner;
import mundo.Perro;

/**
 *
 * @author valea
 */
public class ExposicionCanina {
 private  ArrayList<Perro>misPerros;
         private  Scanner lector;
    
    public ExposicionCanina() {
        //Permite inicializar los productos de una clase
        misPerros= new ArrayList<>();
        lector = new Scanner(System.in);
        
       

}
    
     public void mostrarMenu() {
        boolean activo = true;
        
        do {
            //Imprimir el Menu
            System.out.println("====== Menu de opciones ======");
            System.out.println("1. Agregar Perro que esta concursando");
            System.out.println("2. Mostrar informacion de los perros");
            System.out.println("3. Eliminar registro de los perros registrados ");
            System.out.println("4. Menu Para Modificar la informacion");
            System.out.println("5. Menu Lista de Perros ");
            System.out.println("6.Salir");
            System.out.println("Digite su opción");
            System.out.println("=======================================");
            
            
            //Lee las opciones del usuario
            int opcion = lector.nextInt();
                //Ejecuta la accion, de opcion selecionada
                switch (opcion) {
                    
                     case 1:
                         try{
                    agregarPerro();
                         }catch(NombreDuplicadoException e){
                             System.out.println(e.getMessage());

                         }
                    break;
                case 2:
                    if (misPerros.size() == 0) {
                        System.out.println("No hay entradas agregadas.");
                    } else {
                        mostrarInformacion();
                    }
                    break;
                case 3:
                    if (misPerros.size() == 0) {
                        System.out.println("No hay entradas agregadas.");
                    } else {
                        eliminarPerro();
                      
                    }
                    break;

                case 4:
                    if(misPerros.size()==0){
                        System.out.println("No hay entradas agregadas");
                    } else {
                        //Llama al metodo y elimina la entrada
                      menumodificarRegistro();
                    }
                    break;
                case 5:
                   MenuListaPerros();
                     break;
                
                case 6:
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
        
        public void agregarPerro() throws NombreDuplicadoException {
            lector.nextLine();
        System.out.println("Ingrese el nombre del perro: ");
        String nombre = lector.nextLine();
        if (!misPerros.isEmpty())
        {
            for(Perro t: misPerros){
                if(t.getNombre().equalsIgnoreCase(nombre))
                {        
            throw new NombreDuplicadoException();
                }
            }
        }
        System.out.println("Ingrese la raza del perro: ");
        String raza = lector.nextLine();
        System.out.println("Ingrese la edad del perro: ");
        int edad = lector.nextInt();
        System.out.println("Ingrese la puntuacion del perro de 1-5: ");
        int puntuacion = lector.nextInt();lector.nextLine();
        System.out.println("Ingrese la foto del perro: ");
        String foto = lector.nextLine();
        System.out.println("===========================================");
        
        Perro nuevoPerro = new Perro(nombre, raza, edad, puntuacion, foto);
        misPerros.add(nuevoPerro);
        System.out.println("El perro fue registrado exitosamente");
        }
        
        public void mostrarInformacion() {
        
            Scanner scanner = new Scanner(System.in); 
    
            System.out.println("Ingrese el nombre del perro que desea buscar: ");
            String nombreBuscado = scanner.nextLine(); 
    
            boolean encontrado = false; 
    
                for (Perro p : misPerros) {
                    if (p.getNombre().equalsIgnoreCase(nombreBuscado)) { 
                        System.out.println("========= Información del Perro ===========");
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Raza: " + p.getRaza());
                        System.out.println("Edad: " + p.getEdad());
                        System.out.println("Puntuación: " + p.getPuntuacion());
                        System.out.println("Foto: " + p.getFoto());
                        System.out.println("============================================");
                        encontrado = true; 
                        break; 
                    }
                }
    
            if (!encontrado) { 
                System.out.println("No se encontró un perro con el nombre: " + nombreBuscado);
            }

        }
          
          public void eliminarPerro(){
              
       System.out.println("Digite el nombre del perrito que quiere eliminar");
    lector.nextLine();
    String nombre = lector.nextLine();
    boolean encontrado = false;

    for(Perro e: misPerros){
        if(e.getNombre().equals(nombre)){
            System.out.println("¿Está seguro de eliminar este registro?");
            System.out.println("Ingrese: 1 para eliminar o 2 para Salir: ");
            int opcion = lector.nextInt();
            if (opcion == 1) {
                misPerros.remove(e);
                System.out.println("El perrito con nombre: " + nombre + " ha sido eliminado.");
            } else if(opcion == 2){
                System.out.println("El perrito no ha sido eliminado.");
            }
            encontrado = true;
            break;
        }
    }

    if(!encontrado){
        System.out.println("No se encontró ningún perrito con ese nombre.");
    }

          }
        //menu para modificar el registro
       
        public void menumodificarRegistro(){
            lector.nextLine();
              System.out.println("Escriba el nombre del perrito que desea modificar la informacion");
              String nombre = lector.nextLine();
              boolean activo = false;
             
              for (Perro p : misPerros) {
                  if (p.getNombre().equals(nombre)) { 
                      System.out.println("====== Menu para modificar la informacion ======");
                      System.out.println("1.Modificar la edad.");
                      System.out.println("2.Cambiar la raza.");
                      System.out.println("3.Modificar el puntaje."); 
                      System.out.println("4.Salir del menu de modificaciones.");
                      System.out.println("=======================================");
                      
                      int opcion = lector.nextInt();
                      lector.nextLine(); // Limpiar el buffer de entrada
                      
                      switch (opcion) {
                          case 1:
                              modificarEdad(p);
                              break;
                          case 2:
                              modificarRaza(p);
                              break;
                          case 3:
                              modificarPuntaje(p);
                              break;
                          case 4:
                             //Cambia la variable para salir del menu
                    activo = false;
                    System.out.println("Programa terminado");
                    break;                        
               
                default:
                    //Para opciones invalidas
                    System.out.println("opcion no valida");
                      }
                      
                  }
              }
        	  }
        

            //Metodos para el menu de listar perros
            
            public void buscarGanador(){
                if (misPerros.isEmpty()) {
        System.out.println("No hay perros registrados");
    } else {
        System.out.println("========== PERRO GANADOR ==========");
        
        // Ordenar los perros por puntuación de manera descendente
        for (int i = 0; i < misPerros.size() - 1; i++) {
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro perro1 = misPerros.get(i);
                Perro perro2 = misPerros.get(j);
                if (perro1.getPuntuacion() < perro2.getPuntuacion()) {
                    // Intercambiar perros
                    misPerros.set(i, perro2);
                    misPerros.set(j, perro1);
                }
            }
        }
        
        // El ganador será el primer perro en la lista ordenada
        Perro ganador = misPerros.get(0); 
        System.out.println("El perro ganador es: " + ganador.getNombre() + " con una puntuación de: " + ganador.getPuntuacion());
    }


           }
            public void buscarMenorPuntaje(){
                lector.nextLine();
                if (misPerros.isEmpty()) {
        System.out.println("No hay perros registrados");
    } else {
        System.out.println("========== PERRO CON MENOR PUNTAJE ==========");
        for (int i = 0; i < misPerros.size(); i++) {
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro perro1 = misPerros.get(i);
                Perro perro2 = misPerros.get(j);
                if (perro1.getPuntuacion() > perro2.getPuntuacion()) {
                    misPerros.set(i, perro2);
                    misPerros.set(j, perro1);
                     break;
                }
            }
        }
        Perro menorPuntaje = misPerros.get(0); // El perro con menor puntaje estará en la primera posición después de ordenar
        System.out.println("El perro con menor puntuación es: " + menorPuntaje.getNombre() + " con una puntuación de: " + menorPuntaje.getPuntuacion());
    }

}
            public void buscarMayorEdad(){
                 if (misPerros.isEmpty()) {
        System.out.println("No hay perros registrados");
    } else {
        System.out.println("========== PERRO CON MAYOR EDAD ==========");
        for (int i = 0; i < misPerros.size(); i++) {
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro perro1 = misPerros.get(i);
                Perro perro2 = misPerros.get(j);
                if (perro1.getEdad() > perro2.getEdad()) {
                    misPerros.set(i, perro2);
                    misPerros.set(j, perro1);
                     break;
                }
            }
        }
        Perro mayorEdad = misPerros.get(misPerros.size() - 1);
        System.out.println("El perro con mayor edad es: " + mayorEdad.getNombre() + " con una edad de: " + mayorEdad.getEdad());
       
    }


}
            public void mostrarListaOrdenada(){
                 if (misPerros.isEmpty()) {
                 System.out.println("No hay perros registrados");
    } 
else {
        System.out.println("========== PERROS ORDENADOS POR PUNTUACIÓN ==========");
        
        // Ordenar los perros por puntuación de manera descendente
        for (int i = 0; i < misPerros.size() - 1; i++) {
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro perro1 = misPerros.get(i);
                Perro perro2 = misPerros.get(j);
                if (perro1.getPuntuacion() < perro2.getPuntuacion()) {
                    // Intercambiar perros
                    misPerros.set(i, perro2);
                    misPerros.set(j, perro1);
                }
            }
        }
        
        // Mostrar todos los perros ordenados
        for (Perro perro : misPerros) {
            System.out.println("Nombre: " + perro.getNombre());
            System.out.println("Raza: " + perro.getRaza());
            System.out.println("Edad: " + perro.getEdad());
            System.out.println("Puntuación: " + perro.getPuntuacion());
            System.out.println("Foto: " + perro.getFoto());
            System.out.println("===============================");
            lector.nextLine();
        }
    }

            }
            //menu lista de perros
            public void MenuListaPerros(){
                  boolean activo = true;
        
        do {
            //Imprimir el Menu
            System.out.println("====== Menu de listas de perros ======");
            System.out.println("1. Perros ordenados por puntuacion");
            System.out.println("2. Perro con menor puntaje");
            System.out.println("3. perro con mayor edad");
            System.out.println("4. perro con mayor puntuacion");
            System.out.println("5.Salir");
            System.out.println("Digite su opción");
            System.out.println("=======================================");
            
            
            //Lee las opciones del usuario
            int opcion = lector.nextInt();
                //Ejecuta la accion, de opcion selecionada
                switch (opcion) {
                    
                 case 1:
                        mostrarListaOrdenada()  ;  
                        lector.nextLine();
                        break;
                case 2:
                    buscarMenorPuntaje();
                    break;
                case 3:
                    buscarMayorEdad();
                    break;
                case 4:
                    buscarGanador();
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
        //Metodos para el menu de modificar
        public void modificarEdad(Perro perro) {
              System.out.println("Ingrese la nueva edad en meses:");
              int nuevaEdad = lector.nextInt();
              perro.setEdad(nuevaEdad);
              System.out.println("Edad modificada con éxito.");
          }

          public void modificarRaza(Perro perro) {
              System.out.println("Ingrese la nueva raza:");
              String nuevaRaza = lector.nextLine();
              perro.setRaza(nuevaRaza);
              System.out.println("Raza modificada con éxito.");
          }

          public void modificarPuntaje(Perro perro) {
              System.out.println("Ingrese el nuevo puntaje:");
              int nuevaPuntuacion = lector.nextInt();
              perro.setPuntuacion(nuevaPuntuacion);
              System.out.println("Puntaje modificado con éxito.");
              
              
          }

         public static void main(String[] args) {
        //Crea un Objeto de la clase tienda1
        ExposicionCanina expo = new ExposicionCanina();
        //Llama al metodo de mostrarmenu de Opciones para la ejecutacion
        expo.mostrarMenu();
                     }}

    



    

