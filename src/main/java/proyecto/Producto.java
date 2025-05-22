package proyecto;

import java.text.DecimalFormat;

public class Producto {
    int id;
    String nombreProducto;
    float precio;
    int stock;
    public int getId() {
        return this.id;
    }
    public Producto(int id, String nombreProducto, float precio, int stock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;

    }

    public void mostrarProducto() {
        DecimalFormat formato = new DecimalFormat("#,##0.000");
        System.out.println("ID: " + id);
        System.out.println("Nombre del producto: " + nombreProducto);
        System.out.println("Precio: $" + formato.format(precio));
        System.out.println("Stock disponible: " + stock + " unidades");
        System.out.println("---------------");

    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
