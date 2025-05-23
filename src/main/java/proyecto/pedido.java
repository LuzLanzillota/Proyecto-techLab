
package proyecto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items;

    public Pedido() {
        items = new ArrayList<>();
    }

    public void agregarProductoAPedido(Producto producto, int cantidad) {
        items.add(new ItemPedido(producto, cantidad));
    }

    public void mostrarPedido() {
        float total = 0;
        System.out.println("Resumen del pedido:");
        for (ItemPedido item : items) {
            float subtotal = item.getProducto().getPrecio() * item.getCantidad();
            total += subtotal;
            System.out.println("- " + item.getProducto().getNombreProducto() + " x" + item.getCantidad() +
                    " = $" + String.format("%.2f", subtotal));
        }
        System.out.println("Total del pedido: $" + String.format("%.2f", total));
    }
}
