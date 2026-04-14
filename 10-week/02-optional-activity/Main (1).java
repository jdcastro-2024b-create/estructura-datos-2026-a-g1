
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidadEstudiante = scanner.nextInt();

        String[] tipoDocumento = new String[cantidadEstudiante];
        String[] documento = new String[cantidadEstudiante];
        String[] nombre = new String[cantidadEstudiante];
        String[] correo = new String[cantidadEstudiante];

        String[] tipoDcumentoPermitodo = {"CC", "CE", "TI", "PA", "DNI", "RUT", "NIT"};
        // tipoDocumento[0] = "CC";
        // documento[0] = 123456789;
        // nombre[0] = "Juan Perez";
        // correo[0] = "juan.perez@example.com";
        for(int i = 0; i < cantidadEstudiante; i++) {
				  
		

            // ---------------- TIPO DOCUMENTO ----------------
			  
																					   
																																												
						  
																																								 
																				 
																										   
			  
            System.out.print("\nIngrese el tipo de documento del estudiante " + (i+1) + ": ");
            for(int j = 0; j < tipoDcumentoPermitodo.length; j++){
                System.out.print("("+(j+1)+"=>" + tipoDcumentoPermitodo[j]+") ");
            }
            System.out.print(": ");

            int pos = -1;// Variable para almacenar la posición del tipo de documento seleccionado

            while(pos < 0 || pos >= tipoDcumentoPermitodo.length){
                try {
                    pos = scanner.nextInt();
                    pos--;

                    if (pos < 0 || pos >= tipoDcumentoPermitodo.length) {
                        System.out.print("Error. Ingrese un número entre 1 y " + tipoDcumentoPermitodo.length + ": ");
                    } else {
                        tipoDocumento[i] = tipoDcumentoPermitodo[pos];
                    }

                } catch (Exception e) {
                    System.out.print("Dato inválido. Por favor ingrese el tipo de documento del estudiante " + (i+1) + ": ");
                    scanner.next();
                    pos = -1;
                }
            }

            scanner.nextLine(); // limpiar buffer
			

            // ---------------- DOCUMENTO VALIDADO ----------------
            boolean valido = false;

            while(!valido){
                System.out.print("Ingrese el número de documento: ");
                String doc = scanner.nextLine();

                String tipo = tipoDocumento[i];

                switch(tipo){

                    case "CC":
                        if(doc.matches("\\d{8,10}")){
                            valido = true;
                        } else {
                            System.out.println("Error: CC debe tener entre 8 y 10 dígitos numéricos.");
                        }
                        break;

                    case "CE":
                        if(doc.matches("\\d{6,10}")){
                            valido = true;
                        } else {
                            System.out.println("Error: CE debe tener entre 6 y 10 dígitos.");
                        }
                        break;

                    case "TI":
                        if(doc.matches("\\d{10,11}")){
                            valido = true;
                        } else {
                            System.out.println("Error: TI debe tener 10 u 11 dígitos.");
                        }
                        break;

                    case "PA":
                        if(doc.matches("[A-Za-z0-9]{9}")){
                            valido = true;
                        } else {
                            System.out.println("Error: Pasaporte debe tener 9 caracteres alfanuméricos.");
                        }
                        break;

                    case "DNI":
                        if(doc.matches("\\d{8}") || doc.matches("\\d{8}[A-Za-z]")){
                            valido = true;
                        } else {
                            System.out.println("Error: DNI debe ser 8 números o 8 números + 1 letra.");
                        }
                        break;

                    case "RUT":
                        if(doc.matches("\\d{9,11}")){
                            valido = true;
                        } else {
                            System.out.println("Error: RUT debe tener entre 9 y 11 dígitos.");
                        }
                        break;

                    case "NIT":
                        if(doc.matches("\\d{9}-\\d") || doc.matches("\\d{10}")){
                            valido = true;
                        } else {
                            System.out.println("Error: NIT debe ser 9 dígitos + '-' + 1 (ej: 900123456-7).");
                        }
                        break;

                    default:
                        System.out.println("Tipo no válido.");
                }

                if(valido){
                    documento[i] = doc;
                }
            }

            // ---------------- NOMBRE ----------------
            System.out.print("Ingrese el nombre: ");
            nombre[i] = scanner.nextLine();

            // ---------------- CORREO VALIDADO ----------------
            boolean correoValido = false;

            while(!correoValido){
                System.out.print("Ingrese el correo: ");
                String email = scanner.nextLine().toLowerCase();

                String dominios = "(gmail|outlook|hotmail|yahoo|icloud|live)";

                if(email.matches("^[a-z0-9._%+-]+@(" + dominios + "\\.com|[a-z0-9.-]+\\.(com|co|org|net|edu))$")){
                    correo[i] = email;
                    correoValido = true;
                } else {
                    System.out.println("Error: correo inválido. Use dominios reales o empresariales.");
                }
            }
        }

        // ---------------- MOSTRAR DATOS ----------------
        System.out.println("\n===== LISTA DE ESTUDIANTES =====");
        for(int i = 0; i < cantidadEstudiante; i++){
            System.out.println("Estudiante " + (i+1));
            System.out.println("Tipo Documento: " + tipoDocumento[i]);
            System.out.println("Documento: " + documento[i]);
            System.out.println("Nombre: " + nombre[i]);
            System.out.println("Correo: " + correo[i]);
            System.out.println("---------------------------");
        }

        System.out.println("Programa ejecutado correctamente");
        scanner.close();
    }
}