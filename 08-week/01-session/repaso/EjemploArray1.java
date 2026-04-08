package repaso;

import java.util.Scanner;

public class EjemploArray1 {
    
    public static void main(String[] args) {
        // String => |hola|Pedro|Buenas|Veinte|
		// 	 0	  1		2		3
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos datos quieres ingresar: ");
        Integer cantidad = sc.nextInt();
        String datos[] = new String[cantidad];
        int i=0;

        // for(i=0; i<datos.length; i++){
        //     System.out.print("Ingrese el dato " + (i+1)+": ");
        //     datos[i] = sc.next();
        // }

        // Integer => |2|4|9|1|
		//    0 1 2 3
        Integer numeros[] = new Integer[cantidad];
        for(i=0; i<numeros.length; i++){
            System.out.print("Ingrese el numero " + (i+1)+": ");
            numeros[i] = sc.nextInt();
            datos[i] = "Ingresado" + (numeros[i]); // Asignar un dato relacionado al numero
        }

        System.out.println("\n=== DATOS INGRESADOS ===");
        for(i=0; i<datos.length; i++){
            System.out.println("Dato " + (i+1) + ": " + datos[i]);
        }

        System.out.println("\n=== NUMEROS INGRESADOS ===");
        for(i=0; i<numeros.length; i++){
            System.out.println("Numero " + (i+1) + ": " + numeros[i]);
        }

        sc.close();
    }
}
