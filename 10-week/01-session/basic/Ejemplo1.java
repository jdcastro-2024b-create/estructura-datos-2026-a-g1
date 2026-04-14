
import java.util.Scanner;

public class Ejemplo1 {
    public static void main(String[] args) {
        /*  
            Se requiere almacenar los datos básicos de una lista de estudiantes, dónde se guarde.
            * Tipo documento (Array)
            * Documento (Integer)
            * Nombre (String)
            * Correo (String)
        */

        /*
            Posibilidades: objetos para almacenar datos
            - array (problema: respeta a un solo tipo de dato)
            - map <key>,<value>
            - arrayList (problema: respeta a un solo tipo de dato)
        */
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidadEstudiante = scanner.nextInt();

        String[] tipoDocumento = new String[cantidadEstudiante];
        Integer[] documento = new Integer[cantidadEstudiante];
        String[] nombre = new String[cantidadEstudiante];
        String[] correo = new String[cantidadEstudiante];
        String[] tipoDcumentoPermitodo = {"CC", "CE", "TI", "PA", "DNI", "RUT", "NIT"};
        // tipoDocumento[0] = "CC";
        // documento[0] = 123456789;
        // nombre[0] = "Juan Perez";
        // correo[0] = "juan.perez@example.com";

        int i = 0;
        int j = 0;
        

        for(i=0; i<tipoDocumento.length; i++){
            /*
                1. Datos permitidos: Depende de la data del array tipoDcumentoPermitodo
                2. Validar que el número este entre 0 y tipoDcumentoPermitodo.length, para que elija un tipo de documento permitido
                    Nota: 
                        - El usuario, agraga del 1 al tipoDcumentoPermitodo.length + 1, para que el programa sea legible.
                        - El programa internamente, resta 1 al número ingresado.
                3. Si no esta en el rango, volve a preguntar hasta que elija un tipo de documento permitido
            */
            System.out.print("Ingrese el tipo de documento del estudiante " + (i+1)+ ": ");
            for(j=0; j<tipoDcumentoPermitodo.length; j++){
                System.out.print("("+(j+1)+"=>" + tipoDcumentoPermitodo[j]+") ");
            }
            System.out.print(": ");

            int pos = -1; // Variable para almacenar la posición del tipo de documento seleccionado
            while(pos<0 || pos>=tipoDcumentoPermitodo.length){
                try {
                    pos = scanner.nextInt(); // Leer la posición ingresada por el usuario
                    pos--; // Restar 1 para convertir a índice de array
                    if (pos < 0 || pos >= tipoDcumentoPermitodo.length) {
                    System.out.print("Error en el dato ingresado. Por favor, ingrese un número entre 1 y " + tipoDcumentoPermitodo.length+", ingresar de nuevo el dato: "); 
                    }else{
                        tipoDocumento[i] = tipoDcumentoPermitodo[pos]; // Asignar el tipo de documento seleccionado al array
                    }
                } catch (Exception e) {
                   System.out.println("Dato no válido: "); 
                   pos = -1; // Reiniciar la posición para volver a solicitar el dato
                }                
            }

            
            

            // System.out.print("Ingrese el número de documento del estudiante " + (i+1) + ": ");
            // documento[i] = scanner.nextInt();

            // System.out.print("Ingrese el nombre del estudiante " + (i+1) + ": ");
            // nombre[i] = scanner.next();

            // System.out.print("Ingrese el correo del estudiante " + (i+1) + ": ");
            // correo[i] = scanner.next();
            System.out.println("Programa ejecutado correctamente");

        }

    }
}