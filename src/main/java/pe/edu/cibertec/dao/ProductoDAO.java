package pe.edu.cibertec.dao;

import jakarta.persistence.EntityManager;
import pe.edu.cibertec.entity.Producto;
import pe.edu.cibertec.util.JPAUtil;

import java.util.List;

public class ProductoDAO {
    public void guardarProducto(Producto producto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Producto> listarProductos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Producto", Producto.class).getResultList();
        } finally {
            em.close();
        }
    }
}
