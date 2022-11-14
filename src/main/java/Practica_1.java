
import java.util.Scanner;

public class Practica_1 {

    public static void Relleno(int[] Mensaje) {
        for (int i = 0; i < Mensaje.length; i++) {
            Mensaje[i] = (int) (Math.random() * 2);
        }
    }

    public static void Lectura(int T, int[] Mensaje) {
        System.out.println("Su mensaje es: ");
        for (int k = 0; k < T; k++) {
            System.out.print(Mensaje[T - k - 1]);
        }
    }

    public static void Paridad(int T) {
        String Binario;
        int Paridad;
        int Total;
        Binario = Integer.toBinaryString(T);
        Paridad = Binario.length();
        Paridad = Paridad + T;
        Binario = Integer.toBinaryString(Paridad);
        Paridad = Binario.length() + 1;
        System.out.println("Necesitas " + Paridad + " bits de paridad mas el global.");
        Total = Paridad + T;
        System.out.println("El tamaño total será de " + Total + " bits.");
    }

    public static void main(String arg[]) {
        Scanner Rango = new Scanner(System.in);
        System.out.println("Elija un tamaño para el mensaje.");
        int T = Rango.nextInt();
        int[] Mensaje = new int[T];
        String Binario;
        int Paridad;
        int Total;

        Relleno(Mensaje);
        Lectura(T, Mensaje);
        System.out.println(" ");
        Paridad(T);
    }

}
