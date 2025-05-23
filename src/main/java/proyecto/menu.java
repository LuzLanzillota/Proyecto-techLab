package proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Producto producto1 = new Producto(1,"Powder Kiss Lipstick Style Shocked",81.840f,20);
        Producto producto2 = new Producto(2,"Studio Finish SPF35 Concealer NW35",67.010f,5);
        Producto producto3 = new Producto(3,"Squirt Plumping Gloss Stick",77.500f,16);
        Producto producto4 = new Producto(4,"Extra Dimension Skinfinish Double Gleam",116.390f,35);
        Producto producto5 = new Producto(5,"Dazzleshadow Liquid Ever",90.600f,3);

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Pedido nuevoPedido = new Pedido();

        int usuarioElige;

        do {
            System.out.println("""
                    Menú Principal:
                    1) Agregar producto
                    2) Lista productos
                    3) Buscar/Actualizar producto
                    4) Eliminar producto
                    5) Crear un pedido
                    6) Lista de pedidos
                    7) Salir
                    
                    Elija una opción (Escriba el número):
                    """);
            usuarioElige = entrada.nextInt();

            switch (usuarioElige) {
                case 1:
                    int opcion;
                    System.out.println("Entrando a agregar productos...");
                    do {
                        System.out.println("Ingrese ID del producto:");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        System.out.println("Ingrese nombre del producto:");
                        String nombre = entrada.nextLine();

                        System.out.println("Ingrese precio del producto:");
                        float precio = entrada.nextFloat();

                        System.out.println("Ingrese stock disponible:");
                        int stock = entrada.nextInt();

                        Producto nuevoProducto = new Producto(id, nombre, precio, stock);
                        productos.add(nuevoProducto);

                        System.out.println("Producto agregado con éxito");

                        System.out.println("¿Desea agregar otro producto?");
                        System.out.println("""
                                1. Sí
                                2. No
                                """);
                        opcion = entrada.nextInt();
                    } while (opcion != 2);
                    break;

                case 2:
                    System.out.println("Mostrando lista de productos...");
                    for (Producto p : productos) {
                        p.mostrarProducto();
                    }
                    break;

                case 3:
                    System.out.println("Entrando a buscar/Actualizar producto...");
                    do {
                        System.out.println("Indique el número de id del producto que desea buscar/actualizar");
                        int usuarioEligeid = entrada.nextInt();
                        boolean encontrado = false;

                        for (Producto p : productos) {
                            if (p.getId() == usuarioEligeid) {
                                encontrado = true;
                                System.out.println("""
                                    Indique que se quiere modificar:
                                    1. ID
                                    2. Nombre
                                    3. Precio
                                    4. Stock
                                    """);
                                int usuariOpcion = entrada.nextInt();
                                entrada.nextLine(); // limpiar buffer

                                switch (usuariOpcion) {
                                    case 1:
                                        System.out.println("Ingrese nuevo ID:");
                                        int nuevoId = entrada.nextInt();
                                        p.setId(nuevoId);
                                        System.out.println("ID actualizado correctamente.");
                                        break;
                                    case 2:
                                        System.out.print("Ingrese nuevo nombre: ");
                                        String nuevoNombre = entrada.nextLine();
                                        p.setNombreProducto(nuevoNombre);
                                        System.out.println("Nombre actualizado correctamente");
                                        break;
                                    case 3:
                                        System.out.print("Ingrese nuevo precio: ");
                                        float nuevoPrecio = entrada.nextFloat();
                                        p.setPrecio(nuevoPrecio);
                                        System.out.println("Precio actualizado correctamente");
                                        break;
                                    case 4:
                                        System.out.print("Ingrese nuevo stock: ");
                                        int nuevoStock = entrada.nextInt();
                                        p.setStock(nuevoStock);
                                        System.out.println("Stock actualizado correctamente");
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta.");
                                }
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Producto con ese ID no encontrado.");
                        }

                        System.out.println("¿Desea buscar/actualizar otro producto?");
                        System.out.println("""
                                1. Sí
                                2. No
                                """);
                        opcion = entrada.nextInt();
                    } while (opcion != 2);
                    break;

                case 4:
                    System.out.println("Entrando a eliminar producto...");
                    System.out.println("Indique el número de ID del producto: ");
                    int idEliminar = entrada.nextInt();
                    Producto productoAEliminar = null;
                    for (Producto p : productos) {
                        if (p.getId() == idEliminar) {
                            productoAEliminar = p;
                            break;
                        }
                    }
                    if (productoAEliminar != null) {
                        productos.remove(productoAEliminar);
                        System.out.println("El producto se eliminó con éxito");
                    } else {
                        System.out.println("No se encontró un producto con ese ID");
                    }
                    break;

                case 5:
                    System.out.println("Entrando a crear un pedido...");
                    nuevoPedido = new Pedido();

                    String continuarCompra;
                    do {
                        for (Producto p : productos) {
                            p.mostrarProducto();
                        }

                        System.out.println("Indique el ID del producto que desea comprar: ");
                        int productoAComprarId = entrada.nextInt();

                        Producto productoSeleccionado = null;
                        for (Producto p : productos) {
                            if (p.getId() == productoAComprarId) {
                                productoSeleccionado = p;
                                break;
                            }
                        }

                        if (productoSeleccionado == null) {
                            System.out.println("Producto no encontrado");
                        } else {
                            System.out.println("Ingrese la cantidad que desea comprar del producto:");
                            int cantidad = entrada.nextInt();

                            if (cantidad > productoSeleccionado.getStock()) {
                                System.out.println("No hay suficientes existencias del producto");
                            } else {
                                productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
                                nuevoPedido.agregarProductoAPedido(productoSeleccionado, cantidad);
                                System.out.println("Producto agregado al pedido con éxito.");
                            }
                        }

                        System.out.print("¿Desea agregar otro producto al pedido? (S/N): ");
                        entrada.nextLine();
                        continuarCompra = entrada.nextLine();

                    } while (continuarCompra.equalsIgnoreCase("S"));

                    listaPedidos.add(nuevoPedido);
                    System.out.println("Pedido creado con éxito.");
                    nuevoPedido.mostrarPedido();
                    break;

                case 6:
                    System.out.println("Entrando a la lista de pedidos...");
                    if (listaPedidos.isEmpty()) {
                        System.out.println("No hay pedidos registrados.");
                    } else {
                        int numeroPedido = 1;
                        for (Pedido p : listaPedidos) {
                            System.out.println("Pedido #" + numeroPedido);
                            p.mostrarPedido();
                            System.out.println("---------------------------");
                            numeroPedido++;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Muchas gracias por su compra");
                    break;

                default:
                    System.out.println("Opción inexistente");
            }

        } while (usuarioElige != 7);
    }
}


