package lab6p1_gabrielalexis;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_GabrielAlexis {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static char[] genRandCharArray(int size) {
        char temporal[] = new char[size];
        int num;

        for (int i = 0; i < size; i++) {
            num = rand.nextInt(65, 73);
            char letra = (char) num;

            temporal[i] = letra;
        }
        return temporal;
    }

  public static void intersection(char array1[], char array2[]) {
    int num_inter = array1.length;
    char intersection[] = new char[num_inter];

    for (int i = 0; i < array1.length; i++) {
        for (int j = 0; j < array2.length; j++) {
            if (array1[i] == array2[j]) {
                intersection[i] = array1[i];
                System.out.print("["+intersection[i]+"]");
                break;
            }

        }

    }
   
}

    public static void difference(char[] array1, char[] array2) {
        System.out.print("Diferencia: ");
        for (int i = 0; i < array1.length; i++) {
            boolean enArray = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    enArray = true;
                    break;
                }
            }
            if (!enArray) {
                System.out.print("[" + array1[i] + "]");
            }
        }
    }

    public static void imprimir(char[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print("[ " + array[j] + " ] ");
        }
    }

    public static void imprimir2(int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print("[ " + array[j] + " ]");
        }
    }

    public static int[] genRand(int size, int lim_inf, int lim_sup) {
        int num;
        int temporal[] = new int[size];
        for (int i = 0; i < size; i++) {
            num = rand.nextInt(lim_inf, lim_sup);
            temporal[i] = num;
        }
        return temporal;
    }

    public static boolean isPrime(int numero) {
        boolean esPrimo = false;
        int cont_div = 0;
        for (int i = 1; i < numero + 1; i++) {
            if (numero % i == 0) {
                cont_div++;
            }
        }
        if (cont_div != 2) {
            esPrimo = false;
        } else {
            esPrimo = true;
        }

        return esPrimo;
    }

    public static int countPrimeFactors(int numero) {
        int numero_primos = 0;
        for (int i = 2; i <= numero; i++) {
            if (isPrime(i) && (numero % i == 0)) {
                numero_primos++;
            }
        }

        return numero_primos;
    }

    public static int[] getTotalPrime(int array[]) {
        int temporal[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temporal[i] = countPrimeFactors(array[i]);
        }
        return temporal;
    }

    public static void main(String[] args) {
        System.out.println("\nMenu\n1. Conjuntos\n2. Primos\n3. Salir");
        int opt = input.nextInt();
        while (opt != 3) {
            switch (opt) {
                case 1:
                    System.out.println("Ingrese el tamagno del primer arreglo: ");
                    int size = input.nextInt();
                    System.out.println("Ingrese el tamagno del segundo arreglo: ");
                    int size2 = input.nextInt();
                    if (size > 0 && size2 > 0) {
                        char array1[] = new char[size];
                        char array2[] = new char[size2];
                        System.out.print("Set1= ");
                        imprimir(array1 = genRandCharArray(size));
                        System.out.print("\nSet2= ");
                        imprimir(array2 = genRandCharArray(size2));
                        System.out.println("\n1. Interseccion\n2. Diference");
                        int opt_case = input.nextInt();

                        if (opt_case == 1) {
                            System.out.println("");
                            intersection(array1, array2);
                        } else if (opt_case == 2) {
                            difference(array1, array2);

                        } else {
                            System.out.println("Opcion incorrecta");
                        }
                    } else {
                        System.out.println("El tamagno del arreglo no puede ser menor a 0");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el tamagno del arreglo a general: ");
                    int tam_arreglo = input.nextInt();
                    System.out.println("Ingrese el limite inferior: ");
                    int lim_inf = input.nextInt();
                    System.out.println("Ingrese el limite superior: ");
                    int lim_sup = input.nextInt();
                    int array_aleat[] = new int[tam_arreglo];
                    int arrayPrimes[] = new int[tam_arreglo];
                    if ((lim_inf < lim_sup) && tam_arreglo >= 0) {
                        System.out.println("");
                        imprimir2(array_aleat = genRand(tam_arreglo, lim_inf, lim_sup));
                        System.out.println("");
                        imprimir2(arrayPrimes = getTotalPrime(array_aleat));
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("\nMenu\n1. Conjuntos\n2. Primos\n3. Salir");
            opt = input.nextInt();
        }
    }
}
