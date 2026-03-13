
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AppCaracter {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroEntrada;
        String archivoEntrada;

        // Pedimos archivo de entrada
        do {
            System.out.print("Nombre del archivo de entrada (ruta completa sin comillas): ");
            archivoEntrada = scan.nextLine();

            ficheroEntrada = new File(archivoEntrada);

            if (!ficheroEntrada.exists()) {
                System.out.println("El archivo no existe. Inténtalo de nuevo.");
            }

        } while (!ficheroEntrada.exists());

        // Abrimos el archivo para leerlo
        // ALTERNATIVA: FileReader lector = new FileReader("entrada.txt");
        FileReader lector = new FileReader(ficheroEntrada);

        // Pedir desplazamiento
        int desplazamiento;
        do {
            System.out.print("Introduce el desplazamiento (-25 a 25 siguiendo la tabla ASCII): ");
            desplazamiento = scan.nextInt();
            scan.nextLine();

            if (desplazamiento < -25 || desplazamiento > 25) {
                System.out.println("Desplazamiento inválido. Inténtalo de nuevo.");
            }

        } while (desplazamiento < -25 || desplazamiento > 25);

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        String archivoSalida;
        File ficheroSalida;

        // Pedimos archivo de salida
        do {
            System.out.print("Nombre del archivo de salida (debe ser ruta absoluta y no existir): ");
            archivoSalida = scan.nextLine();

            ficheroSalida = new File(archivoSalida);

            if (ficheroSalida.exists()) {
                System.out.println("El archivo ya existe. Inténtalo con otro nombre.");
            }

        } while (ficheroSalida.exists());

        // Creamos el archivo de salida
        // SI NO EXISTE, LO CREA
        // ALTERNATIVA: FileWriter escritor = new FileWriter("salida.txt");
        FileWriter escritor = new FileWriter(ficheroSalida);

        // Se va leyendo del fichero CARACTER A CARACTER
        int caracterInt;

        // Cuando se alcanza EOF (End Of File), se deja de leer
        while ((caracterInt = lector.read()) != -1) {

            char caracter = (char) caracterInt;

            if (caracter >= 33) { // ACII de '!'
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
