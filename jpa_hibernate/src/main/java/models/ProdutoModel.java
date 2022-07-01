package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("administrativo-jpa");
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    public void create(Produto p) {

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(p);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();

        }
    }

    public void update(Produto p) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(p);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();

        }

    }

    public void delete(Produto p) {
        Produto produto_remover = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            produto_remover = entityManager.find(Produto.class, p.getId());
            entityManager.remove(produto_remover);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Produto findById(Produto p) {
        Produto produto = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            produto = entityManager.find(Produto.class, p.getId());
            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return produto;

    }

    public List<Produto> findAll() {

        List<Produto> produtos = new ArrayList<Produto>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            produtos = entityManager.createQuery("SELECT * FROM" + Produto.class.getName()).getResultList();
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return produtos;

    }
}
