
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
        String[] tipoDcumentoPermitodo = {"CC", "CE", "TI", "PA", "DNI", "RUT"};
        // tipoDocumento[0] = "CC";
        // documento[0] = 123456789;
        // nombre[0] = "Juan Perez";
        // correo[0] = "juan.perez@example.com";

        int i = 0;
        int j = 0;

        for(i=0; i<tipoDocumento.length; i++){
            //Datos permitidos: Depende de la data del array tipoDcumentoPermitodo
            System.out.print("Ingrese el tipo de documento del estudiante " + (i+1)+ ": ");
            for(j=0; j<tipoDcumentoPermitodo.length; j++){
                System.out.print("("+(j+1)+"=>" + tipoDcumentoPermitodo[j]+") ");
            }
            System.out.print(": ");
            tipoDocumento[i] = scanner.next();

            System.out.print("Ingrese el número de documento del estudiante " + (i+1) + ": ");
            documento[i] = scanner.nextInt();

            System.out.print("Ingrese el nombre del estudiante " + (i+1) + ": ");
            nombre[i] = scanner.next();

            System.out.print("Ingrese el correo del estudiante " + (i+1) + ": ");
            correo[i] = scanner.next();

        }

    }
}