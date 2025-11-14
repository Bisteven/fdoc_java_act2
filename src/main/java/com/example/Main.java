
package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // WHILE
        System.out.println("WHILE: Imprimir 1 a 10 (validando límite antes de cada iteración)");
        int cur = 1;
        int limit = 10;
        while (cur <= limit) { // validación antes de cada iteración
            System.out.print(cur + (cur < limit ? ", " : "\n"));
            cur++;
        }

        System.out.println("\nWHILE: Sumar de 1 a n");
        System.out.print("Ingrese n (entero positivo): ");
        int n = 0;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else {
            sc.next(); // consumir entrada inválida
        }
        int i = 1;
        long suma = 0;
        while (i <= n) {
            suma += i;
            i++;
        }
        System.out.println("Suma 1 a " + n + " = " + suma);

        System.out.println("\nWHILE: Buscar número en arreglo (detenerse al encontrarlo)");
        int[] arr = {3, 7, 9, 1, 5, 11};
        System.out.print("Número a buscar: ");
        int buscado = 0;
        if (sc.hasNextInt()) {
            buscado = sc.nextInt();
        } else {
            sc.next();
        }
        int idx = 0;
        boolean encontrado = false;
        while (idx < arr.length) {
            if (arr[idx] == buscado) {
                encontrado = true;
                System.out.println("Encontrado en índice: " + idx);
                break; // detener al encontrarlo
            }
            idx++;
        }
        if (!encontrado) System.out.println("No se encontró el número en el arreglo.");

        // consumir fin de línea antes de entradas con nextLine()
        sc.nextLine();

        // DO-WHILE
        System.out.println("\nDO-WHILE: Menú interactivo (se muestra al menos una vez). Elija 'Salir' para terminar.");
        String opcion;
        do {
            System.out.println("Menu: 1) Saludar  2) Mostrar fecha  3) Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine().trim();
            if ("1".equals(opcion)) {
                System.out.println("Hola!");
            } else if ("2".equals(opcion)) {
                System.out.println("Fecha: " + java.time.LocalDate.now());
            } else if ("3".equals(opcion) || "Salir".equalsIgnoreCase(opcion)) {
                System.out.println("Saliendo del menú...");
            } else {
                System.out.println("Opción no reconocida.");
            }
        } while (!"3".equals(opcion) && !"Salir".equalsIgnoreCase(opcion));

        System.out.println("\nDO-WHILE: Leer números hasta ingresar 0; mostrar suma acumulada");
        long sumaNums = 0;
        int val;
        do {
            System.out.print("Ingrese número (0 para terminar): ");
            while (!sc.hasNextInt()) {
                sc.next(); // descartar
                System.out.print("Ingrese un entero válido: ");
            }
            val = sc.nextInt();
            sumaNums += val;
        } while (val != 0);
        System.out.println("Suma acumulada (incluyendo 0) = " + sumaNums);

        sc.nextLine(); // limpiar

        System.out.println("\nDO-WHILE: Validación de contraseña (al menos una ejecución)");
        final String PASSWORD = "secreto";
        String intento;
        do {
            System.out.print("Ingrese contraseña: ");
            intento = sc.nextLine();
            if (!PASSWORD.equals(intento)) {
                System.out.println("Contraseña incorrecta, intente otra vez.");
            }
        } while (!PASSWORD.equals(intento));
        System.out.println("Contraseña correcta.");

        // FOR
        System.out.println("\nFOR: Imprimir números pares del 2 al 20");
        for (int p = 2; p <= 20; p += 2) { // incremento apropiado
            System.out.print(p + (p < 20 ? ", " : "\n"));
        }

        System.out.println("\nFOR: Calcular factorial de un número");
        System.out.print("Ingrese entero no negativo para factorial: ");
        int factN = 0;
        if (sc.hasNextInt()) {
            factN = sc.nextInt();
        } else {
            sc.next();
        }
        long fact = 1;
        if (factN < 0) {
            System.out.println("Factorial no definido para negativos.");
        } else {
            for (int j = 1; j <= factN; j++) {
                fact *= j;
            }
            System.out.println(factN + "! = " + fact);
        }

        System.out.println("\nFOR: Sumar elementos de un arreglo usando contador en el ciclo");
        int[] nums = {2, 4, 6, 8, 10};
        int sumaArr = 0;
        for (int k = 0; k < nums.length; k++) { // uso de contador
            sumaArr += nums[k];
        }
        System.out.println("Suma arreglo = " + sumaArr);

        // FOR-EACH
        System.out.println("\nFOR-EACH: Recorrer arreglo y calcular suma");
        int[] valores = {5, 3, 7, 1};
        int sumaForEach = 0;
        for (int v : valores) {
            sumaForEach += v;
        }
        System.out.println("Suma = " + sumaForEach);

        System.out.println("\nFOR-EACH: Listar cada palabra de colección de cadenas");
        String[] palabras = {"uno", "dos", "tres", "cuatro"};
        for (String palabra : palabras) {
            System.out.println("- " + palabra);
        }

        System.out.println("\nFOR-EACH: Calcular promedio de calificaciones (2 decimales)");
        double[] notas = {8.5, 7.75, 9.0, 6.25};
        double sumaNotas = 0;
        for (double nota : notas) {
            sumaNotas += nota;
        }
        double promedio = notas.length > 0 ? sumaNotas / notas.length : 0.0;
        System.out.printf("Promedio = %.2f%n", promedio);

        // BREAK y CONTINUE
        System.out.println("\nBREAK: Detener for al cumplir condición (primera múltiplo de 13)");
        for (int t = 1; t <= 100; t++) {
            if (t % 13 == 0) {
                System.out.println("Primer múltiplo de 13 en 1..100 = " + t);
                break;
            }
        }

        System.out.println("\nCONTINUE: Omitir procesamiento para números impares (mostrar solo pares)");
        for (int t = 1; t <= 10; t++) {
            if (t % 2 != 0) continue;
            System.out.print(t + (t < 10 ? ", " : "\n"));
        }

        System.out.println("\nCOMBINAR BREAK y CONTINUE: manejar casos y detener al alcanzar umbral");
        int[] datos = {2, 4, -1, 6, 8, 10, 12};
        int sumaComb = 0;
        for (int d : datos) {
            if (d < 0) { // ignorar negativos
                System.out.println("Valor negativo encontrado, se omite: " + d);
                continue;
            }
            sumaComb += d;
            if (sumaComb >= 20) { // detener al alcanzar umbral
                System.out.println("Umbral alcanzado con suma = " + sumaComb + ", deteniendo.");
                break;
            }
        }

        sc.close();
        System.out.println("\nEjecución finalizada.");
    }
}
