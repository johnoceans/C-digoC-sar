
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AppCaracter {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Pedimos archivo de entrada
        System.out.print("Nombre del archivo de entrada: ");
        String archivoEntrada = scan.nextLine();

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroEntrada = new File(archivoEntrada);

        if (!ficheroEntrada.exists()) {
            System.out.println("El archivo de entrada no existe.");
            return;
        }

        // Abrimos el archivo para leerlo
        // ALTERNATIVA: FileReader lector = new FileReader("entrada.txt");
        FileReader lector = new FileReader(ficheroEntrada);

        // Pedir desplazamiento
        System.out.print("Introduce el desplazamiento (-25 a 25 siguiendo la tabla ACSII): ");
        int desplazamiento = scan.nextInt();
        scan.nextLine();

        if (desplazamiento < -25 || desplazamiento > 25) {
            System.out.println("El desplazamiento debe estar entre -25 y 25 siguiendo la tabla ASCII.");
            return;
        }

        // Pedimos archivo de salida
        System.out.print("Nombre del archivo de salida: ");
        String archivoSalida = scan.nextLine();

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroSalida = new File(archivoSalida);

        // Creamos el archivo de salida
        // SI NO EXISTE, LO CREA
        // ALTERNATIVA: FileWriter escritor = new FileWriter("salida.txt");
        FileWriter escritor = new FileWriter(ficheroSalida);

        // Se va leyendo del fichero CARACTER A CARACTER
        int caracterInt;

        // Cuando se alcanza EOF (End Of File), se deja de leer
        while ((caracterInt = lector.read()) != -1) {

            char caracter = (char) caracterInt;

            if (caracter >= '!') {
                char desplazado = (char) (caracter + desplazamiento);
                System.out.print(desplazado);
                escritor.write(desplazado);
            } else {
                System.out.print(caracter);
                escritor.write(caracter);
            }
        }

        // Cerramos los archivos
        // MUY IMPORTANTE!!!!!!!
        scan.close();
        lector.close();
        escritor.close();

        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("------------ ARCHIVO PROCESADO ------------");
        System.out.println("-------------------------------------------");

    }
}
