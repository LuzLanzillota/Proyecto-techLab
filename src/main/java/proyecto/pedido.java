package proyecto;
import java.util.List;
import java.util.ArrayList;

public class pedido {
    private List<Producto> productos;

    public pedido() {
        this.productos = new ArrayList<>();
    }

    public void agregarProductoAPedido(Producto producto){
        this.productos.add(producto);
    }
}

