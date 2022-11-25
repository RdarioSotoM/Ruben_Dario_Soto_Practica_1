
import java.util.Scanner;

public class Practica_1 {

    public static void Relleno(int[] Mensaje) {
        for (int i = 0; i < Mensaje.length; i++) {
            Mensaje[i] = (int) (Math.random() * 2);
        }
    }

    public static int Paridad(int T) {
        String Binario;
        int Paridad;
        Binario = Integer.toBinaryString(T);
        Paridad = Binario.length();
        Paridad = Paridad + T;
        Binario = Integer.toBinaryString(Paridad);
        Paridad = Binario.length() + 1;
        return Paridad;
    }

    public static void Lectura(int[] Mensaje) {
        System.out.print("Su mensaje es ");
        for (int x = 0; x < Mensaje.length; x++) {
            System.out.print(Mensaje[x]);
        }
    }

    public static boolean Potencia(int N, int A) {

        for (int i = 0; i < A; i++) {
            if (Math.pow(2, i) == N) {
                return true;
            }
        }
        return false;
    }

    public static void Paridades_0_1(int[] B_paridad, int[] Mensaje_F, int contador, int R_P) {
        for (int i = 0; i < B_paridad.length; i++) {
            int pow = (int) Math.pow(2, i);

            for (int j = 0; j < Mensaje_F.length; j++) {
                int temp = pow & j;
                if (temp != 0) {
                    if (Mensaje_F[j] == 1) {
                        contador++;
                    }
                }
            }
            if (contador % 2 == 0) {
                B_paridad[R_P] = 0;
                R_P++;
            } else if (contador % 2 != 0) {
                B_paridad[R_P] = 1;
                R_P++;
            }
            contador = 0;
        }
    }

    public static void Relleno_Sin_Paridades(int[] Mensaje_F, int[] Mensaje, int n) {
        for (int k = 1; k < Mensaje_F.length; k++) {
            if (Potencia(k, Mensaje_F.length) == true) {
                Mensaje_F[k] = 0;
            } else {
                Mensaje_F[k] = Mensaje[n];
                n++;
            }
        }
    }

    public static void Relleno_con_Paridades(int[] Mensaje_F, int[] B_paridad) {
        int i = 0;
        for (int k = 1; k < Mensaje_F.length; k++) {
            if (Potencia(k, Mensaje_F.length) == true) {
                Mensaje_F[k] = B_paridad[i];
                i++;
            }
        }
    }

    public static void main(String arg[]) {
        Scanner Rango = new Scanner(System.in);
        System.out.println("Elija un tamaño para el mensaje.");
        int T = Rango.nextInt();
        int[] Mensaje = new int[T];

        Relleno(Mensaje);
        Lectura(Mensaje);
        System.out.println(" ");
        System.out.println("Necesitas " + Paridad(T) + " bits de paridad mas el global.");
        Paridad(T);
        int Total = Paridad(T) + T;
        System.out.println("El tamaño total será de " + Total + " bits");

        int n = 0;
        int[] Mensaje_F = new int[Total];

        System.out.println(" ");
        Relleno_Sin_Paridades(Mensaje_F, Mensaje, n);

        int[] B_paridad = new int[Paridad(T) - 1];
        int contador = 0;
        int R_P = 0;   //Recorrer Paridad
        Paridades_0_1(B_paridad, Mensaje_F, contador, R_P);

        Relleno_con_Paridades(Mensaje_F, B_paridad);
    }
}
