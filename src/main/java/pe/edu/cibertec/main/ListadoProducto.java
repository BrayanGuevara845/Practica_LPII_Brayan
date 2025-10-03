package pe.edu.cibertec.main;

import pe.edu.cibertec.dao.ProductoDAO;
import pe.edu.cibertec.entity.Producto;

import java.util.List;

public class ListadoProducto {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> productos = dao.listarProductos();

        System.out.println("N°\tNombre\t\tPrecio\t\tCategoría");
        for (Producto p : productos) {
            System.out.println(p.getId() + "\t" + p.getNombre() + "\t" + p.getPrecio() + "\t" + p.getCategoria().getNombre());
        }
    }
}
