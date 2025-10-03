package pe.edu.cibertec;

import jakarta.persistence.*;
import pe.edu.cibertec.entity.Producto;
import pe.edu.cibertec.entity.Categoria;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Categoria catElectro = em.createQuery(
                    "SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
                    .setParameter("nombre", "Electrónica")
                    .getResultStream()
                    .findFirst()
                    .orElseGet(() -> {
                        Categoria nueva = new Categoria();
                        nueva.setNombre("Electrónica");
                        em.persist(nueva);
                        return nueva;
                    });

            Producto p1 = new Producto("Laptop", 3500.0, catElectro);
            Producto p2 = new Producto("Mouse", 50.0, catElectro);
            Producto p3 = new Producto("Teclado", 120.0, catElectro);

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            em.getTransaction().commit();

            List<Producto> productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
            for (Producto p : productos) {
                String nombreCat = (p.getCategoria() != null) ? p.getCategoria().getNombre() : "Sin categoría";
                System.out.println("Producto: " + p.getNombre() + ", Precio: " + p.getPrecio() + ", Categoría: " + nombreCat);
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
