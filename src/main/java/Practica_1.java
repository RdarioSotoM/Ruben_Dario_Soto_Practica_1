
import java.util.Scanner;

public class Practica_1 {

    public static void Relleno(int[] Mensaje) {
        for (int i = 0; i < Mensaje.length; i++) {
            Mensaje[i] = (int) (Math.random() * 2);
        }
    }

    public static void Lectura(int T, int[] Mensaje) {
        for (int k = 0; k < T; k++) {
            System.out.print(Mensaje[T - k - 1]);
        }
    }

    public static void main(String arg[]) {
        Scanner Rango = new Scanner(System.in);
        System.out.println("Elija un tamaño para el mensaje");
        int T = Rango.nextInt();
        int[] Mensaje = new int[T];

        Relleno(Mensaje);
        Lectura(T, Mensaje);
    }
}
