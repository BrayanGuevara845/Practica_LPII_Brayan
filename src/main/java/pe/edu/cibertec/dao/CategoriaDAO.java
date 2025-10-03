package pe.edu.cibertec.dao;

import jakarta.persistence.EntityManager;
import pe.edu.cibertec.entity.Categoria;
import pe.edu.cibertec.util.JPAUtil;

import java.util.List;

public class CategoriaDAO {
    public void guardarCategoria(Categoria categoria) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Categoria> listarCategorias() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Categoria", Categoria.class).getResultList();
        } finally {
            em.close();
        }
    }
}
