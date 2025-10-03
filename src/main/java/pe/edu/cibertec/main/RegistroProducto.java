package pe.edu.cibertec.main;

import pe.edu.cibertec.dao.ProductoDAO;
import pe.edu.cibertec.dao.CategoriaDAO;
import pe.edu.cibertec.entity.Categoria;
import pe.edu.cibertec.entity.Producto;

import java.util.Scanner;

public class RegistroProducto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoriaDAO catDao = new CategoriaDAO();
        ProductoDAO prodDao = new ProductoDAO();

        System.out.print("Ingrese nombre de la categoría: ");
        String nomCat = sc.nextLine();
        Categoria cat = new Categoria();
        cat.setNombre(nomCat);
        catDao.guardarCategoria(cat);

        System.out.print("Ingrese nombre del producto: ");
        String nomProd = sc.nextLine();
        System.out.print("Ingrese precio del producto: ");
        float precio = sc.nextFloat();

        Producto prod = new Producto();
        prod.setNombre(nomProd);
        prod.setPrecio(precio);
        prod.setCategoria(cat);

        prodDao.guardarProducto(prod);

        System.out.println("Producto registrado correctamente con su categoría.");
    }
}
