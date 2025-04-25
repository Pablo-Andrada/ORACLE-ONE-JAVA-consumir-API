/**
 * Representa una compra con un valor monetario y una descripción.
 * Implementa Comparable para permitir ordenar compras por valor.
 */
public class Compra implements Comparable<Compra> {
    // Monto o valor de la compra
    private double valor;
    // Descripción o detalle de la compra
    private String descripcion;

    /**
     * Constructor de la clase Compra.
     * @param valor      el monto de la compra
     * @param descripcion breve texto que describe la compra
     */
    public Compra(double valor, String descripcion) {
        this.valor = valor;               // Asignar el valor de la compra
        this.descripcion = descripcion;   // Asignar la descripción de la compra
    }

    /**
     * Obtiene el valor de la compra.
     * @return el valor monetario almacenado
     */
    public double getValor() {
        return valor;
    }

    /**
     * Obtiene la descripción de la compra.
     * @return el texto descriptivo almacenado
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Representación en texto de la compra,
     * útil para depuración o impresión rápida.
     * @return cadena con valor y descripción de la compra
     */
    @Override
    public String toString() {
        // Concatenar valor y descripción en una sola línea
        return "Compra: valor=" + valor +
                ", descripcion='" + descripcion + "'";
    }

    /**
     * Método requerido por la interfaz Comparable,
     * define el orden natural de Compra comparando los valores.
     * @param otraCompra la otra instancia de Compra a comparar
     * @return un número negativo si this.valor < otraCompra.valor,
     *         cero si son iguales, o positivo si this.valor > otraCompra.valor
     */
    @Override
    public int compareTo(Compra otraCompra) {
        // Convertir los valores a Double y usar su comparación
        return Double.valueOf(this.valor)
                .compareTo(Double.valueOf(otraCompra.getValor()));
    }
}
