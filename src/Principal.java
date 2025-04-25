import java.util.Collections;     // Utilidades para operar sobre colecciones, como ordenar listas
import java.util.Scanner;         // Permite leer entrada de texto desde la consola

public class Principal {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer lo que el usuario escribe en la consola
        Scanner lectura = new Scanner(System.in);

        // Pedir al usuario que ingrese el límite de crédito de la tarjeta
        System.out.println("Escriba el límite de la tarjeta: ");
        // Leer un valor de tipo double desde la entrada del usuario
        double limite = lectura.nextDouble();

        // Crear una instancia de TarjetaDeCredito usando el límite proporcionado
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        // Variable de control para el bucle: 1 = seguir, 0 = salir
        int salir = 1;

        // Bucle que se repite hasta que el usuario decida salir (salir == 0)
        while (salir != 0) {
            // Pedir al usuario la descripción de la compra
            System.out.println("Escriba la descripción de la compra:");
            // Leer la descripción como cadena de texto
            String descripcion = lectura.next();

            // Pedir al usuario el monto de la compra
            System.out.println("Escriba el valor de la compra:");
            // Leer el valor de la compra y convertirlo a double
            double valor = Double.valueOf(lectura.next());

            // Crear un objeto Compra con el valor y la descripción ingresados
            Compra compra = new Compra(valor, descripcion);

            // Intentar realizar la compra en la tarjeta
            // lanzarCompra devuelve true si hay saldo suficiente y la agrega a la lista de compras
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                // Si la compra fue exitosa, informar al usuario
                System.out.println("Compra realizada!");
                // Preguntar si desea seguir realizando compras o salir
                System.out.println("Escriba 0 para salir o 1 para continuar");
                // Actualizar la variable de control según la respuesta del usuario
                salir = lectura.nextInt();
            } else {
                // Si no hay saldo suficiente, informar y forzar la salida del bucle
                System.out.println("Saldo insuficiente!");
                salir = 0;
            }
        }

        // Al salir del bucle, mostrar un resumen de todas las compras realizadas
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        // Ordenar la lista de compras (suponiendo que Compra implementa Comparable)
        Collections.sort(tarjeta.getListaDeCompras());

        // Recorrer la lista ordenada e imprimir descripción y valor de cada compra
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + " - " + compra.getValor());
        }

        System.out.println("\n***********************");

        // Mostrar el saldo restante en la tarjeta
        System.out.println("\nSaldo de la tarjeta: " + tarjeta.getSaldo());
    }
}
