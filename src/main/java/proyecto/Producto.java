package proyecto;

import java.text.DecimalFormat;

public class Producto {
    int id;
    String nombreProducto;
    float precio;
    int stock;

    public Producto(int id, String nombreProducto, float precio, int stock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public float getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
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

    public void mostrarProducto() {
        DecimalFormat formato = new DecimalFormat("#,##0.000");
        System.out.println("ID: " + id);
        System.out.println("Nombre del producto: " + nombreProducto);
        System.out.println("Precio: $" + formato.format(precio));
        System.out.println("Stock disponible: " + stock + " unidades");
        System.out.println("---------------");
    }

    @Override
    public String toString() {
        return nombreProducto + " ($" + precio + ")";
    }
}
