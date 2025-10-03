package pe.edu.cibertec.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Producto;
import pe.edu.cibertec.entity.Categoria;
import java.util.Scanner;

public class RegistroProducto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_PU");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio del producto: ");
        double precio = sc.nextDouble();

        try {
            em.getTransaction().begin();
            Categoria cat = em.find(Categoria.class, 1);
            Producto p = new Producto();
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCategoria(cat);
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Producto registrado con éxito!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al registrar el producto.");
        } finally {
            em.close();
            emf.close();
        }
    }
}

