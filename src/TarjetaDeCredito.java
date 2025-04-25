import java.util.ArrayList;  // Implementación de la interfaz List con array dinámico
import java.util.List;       // Interfaz que define una colección ordenada de elementos

/**
 * Representa una tarjeta de crédito con un límite y un saldo disponible,
 * así como un registro de las compras realizadas.
 */
public class TarjetaDeCredito {
    // Límite máximo de crédito asignado a la tarjeta
    private double limite;
    // Saldo disponible actualmente (inicialmente igual al límite)
    private double saldo;
    // Lista que guarda todas las compras aprobadas en esta tarjeta
    private List<Compra> listaDeCompras;

    /**
     * Constructor que inicializa la tarjeta con un límite dado.
     * @param limite el monto máximo de crédito permitido
     */
    public TarjetaDeCredito(double limite) {
        this.limite = limite;             // Guardar el límite proporcionado
        this.saldo = limite;              // Inicialmente el saldo disponible es igual al límite
        this.listaDeCompras = new ArrayList<>();  // Crear lista vacía para registrar compras
    }

    /**
     * Intenta procesar una compra restando su valor del saldo disponible.
     * @param compra el objeto Compra que contiene valor y descripción
     * @return true si la compra fue aprobada (hay saldo suficiente), false en caso contrario
     */
    public boolean lanzarCompra(Compra compra) {
        // Verificar si el saldo actual cubre el valor de la compra
        if (this.saldo >= compra.getValor()) {
            // Restar el valor de la compra al saldo disponible
            this.saldo -= compra.getValor();
            // Agregar la compra a la lista de compras realizadas
            this.listaDeCompras.add(compra);
            return true;  // Indicar que la compra se realizó con éxito
        }
        // Si no hay suficiente saldo, no modificar nada y devolver false
        return false;
    }

    /**
     * Obtiene el límite de crédito original de la tarjeta.
     * @return el límite de crédito
     */
    public double getLimite() {
        return limite;
    }

    /**
     * Obtiene el saldo disponible actualmente.
     * @return el saldo restante
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene la lista de todas las compras aprobadas,
     * en el orden en que se realizaron.
     * @return lista de objetos Compra
     */
    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }
}
