package application;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] productos = {
                "Hamburguesa",
                "Perro caliente",
                "Papas fritas"
        };

        String[] turnos = {
                "Almuerzo",
                "Tarde",
                "Noche",
                "Madrugada"
        };

        double[][] ventas = new double[3][4];

        System.out.println("FOOD TRUCK EXPRESS");
        System.out.println("Sistema de registro de ventas");

        registrarVentas(ventas, productos, turnos);
        reporteVentas(ventas, productos, turnos);
    }

    public static void registrarVentas(double[][] ventas, String[] productos, String[] turnos) {

        for (int i = 0; i < productos.length; i++) {

            for (int j = 0; j < turnos.length; j++) {

                System.out.println("Ingrese el valor de la venta de "
                        + productos[i] + " en el turno de " + turnos[j] + ": ");

                ventas[i][j] = validarDato();
            }
        }
    }

    public static void reporteVentas(double[][] ventas, String[] productos, String[] turnos) {

        double[] totalProductos = new double[productos.length];
        double[] totalTurnos = new double[turnos.length];

        double totalGeneral = 0;

        // CALCULAR TOTALES
        for (int i = 0; i < productos.length; i++) {

            for (int j = 0; j < turnos.length; j++) {

                totalProductos[i] += ventas[i][j];
                totalTurnos[j] += ventas[i][j];
                totalGeneral += ventas[i][j];
            }
        }

        // MOSTRAR VENTAS POR PRODUCTO
        System.out.println("\n--- VENTAS POR PRODUCTO ---");

        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i] + ": $" + totalProductos[i]);
        }

        // MOSTRAR VENTAS POR TURNO
        System.out.println("\n--- VENTAS POR TURNO ---");

        for (int j = 0; j < turnos.length; j++) {
            System.out.println(turnos[j] + ": $" + totalTurnos[j]);
        }

        // MAYOR Y MENOR PRODUCTO
        int mayorProducto = 0;
        int menorProducto = 0;

        for (int i = 1; i < productos.length; i++) {

            if (totalProductos[i] > totalProductos[mayorProducto]) {
                mayorProducto = i;
            }

            if (totalProductos[i] < totalProductos[menorProducto]) {
                menorProducto = i;
            }
        }

        // MAYOR Y MENOR TURNO
        int mayorTurno = 0;
        int menorTurno = 0;

        for (int j = 1; j < turnos.length; j++) {

            if (totalTurnos[j] > totalTurnos[mayorTurno]) {
                mayorTurno = j;
            }

            if (totalTurnos[j] < totalTurnos[menorTurno]) {
                menorTurno = j;
            }
        }

        // MOSTRAR RESULTADOS
        System.out.println("\n--- REPORTE FINAL ---");

        System.out.println("Total general: $" + totalGeneral);

        System.out.println("Producto con mayor venta: "
                + productos[mayorProducto] + " $" + totalProductos[mayorProducto]);

        System.out.println("Producto con menor venta: "
                + productos[menorProducto] + " $" + totalProductos[menorProducto]);

        System.out.println("Turno con mayor venta: "
                + turnos[mayorTurno] + " $" + totalTurnos[mayorTurno]);

        System.out.println("Turno con menor venta: "
                + turnos[menorTurno] + " $" + totalTurnos[menorTurno]);
    }



    public static double validarDato() {

        double dato = 0;

        while (true) {

            if (!sc.hasNextDouble()) {

                System.out.println("Error: Ingrese un numero valido.");

                sc.next();

                continue;
            }

            dato = sc.nextDouble();

            if (dato < 0) {

                System.out.println("Error: Ingrese un numero mayor o igual a 0.");

                continue;
            }

            return dato;
        }
    }
}

