package com.medrar.parteuno;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

    public class Main {

        public static void main(String[] args) {
            numeroMayorDelArreglo(12);
            sumarDigitos();
            mostrarFactorial();
        }

        public static void numeroMayorDelArreglo(long logitudArreglo){
            Random random = new Random();
            int[] arr = random.ints(logitudArreglo).toArray();
            System.out.println("Valores del arreglo:");
            Arrays.stream(arr).forEach(System.out::println);
            System.out.println("Mayor valor del arreglo: " + obtenerMayor(arr, Integer.MIN_VALUE, 0));

        }

        private static int obtenerMayor(int[] arr, int res, int index) {
            if(index==arr.length){
                return res;
            }
            res = Integer.max(arr[index], res);
            index++;
            return obtenerMayor(arr, res, index);
        }

        public static void sumarDigitos(){
            Random random = new Random();
            int num = random.ints(1,100000,1000000).findFirst().getAsInt();
            int suma = 0;
            System.out.println("Numero de seis caracteres: " + num);
            System.out.println("Suma de sus dígitos: " + obtenerSuma(num, suma, 100000));
        }

        private static int obtenerSuma(int numero, int suma, int limiteSuperior) {
            if(limiteSuperior==1){
                return suma+numero;
            }
            suma+=numero/limiteSuperior;
            numero%=limiteSuperior;
            limiteSuperior/=10;
            return obtenerSuma(numero, suma, limiteSuperior);
        }

        public static void mostrarFactorial(){
            Random random = new Random();
            int num = random.ints(1,1,11).findFirst().getAsInt();
            System.out.println("Numero para factorial: " + num);
            System.out.println(obtenerFactorial(num));
        }

        private static int obtenerFactorial(int num) {
            if(num==1){
                return 1;
            }
            return num*obtenerFactorial(num-1);
        }
}


