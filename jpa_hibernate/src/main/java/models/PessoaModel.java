package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("administrativo-jpa");
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    public void create(Pessoa pessoa) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(pessoa);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();

        }
    }

    public void update(Pessoa pessoa) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(pessoa);
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }

    }

    public void delete(Pessoa pessoa) {
        Pessoa pessoa_sair = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoa_sair = entityManager.find(Pessoa.class,pessoa.getId());
            entityManager.remove(pessoa_sair);
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    public Pessoa findById(Pessoa pessoa) {
        Pessoa p = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            p = entityManager.find(Pessoa.class,pessoa.getId());
            entityTransaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return p;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoas = entityManager.createQuery("SELECT * FROM" + Pessoa.class.getName()).getResultList();
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return pessoas;
    }

}
