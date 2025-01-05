package com.example.repo;

import com.example.connection.DatabaseConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class ModelRepository<T>{
    private static Session session;
    private final Class<T> clazz;

    public ModelRepository(Class<T> clazz) {
        this.clazz = clazz;
        session = ModelRepository.getSession();
    }

    private static synchronized Session getSession(){
        if (session == null){
            session = DatabaseConnection.createSession();
        }

        return session;
    }

    public void create(T entity){
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            System.out.println(entity.getClass().getName() + " created successfully!");
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            System.err.println("Failed to create " + entity.getClass().getSimpleName() +
                    ": " + e.getMessage());
        }finally {
            session.close();
        }
    }

    public List<T> findAll(){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<T> query = session.createQuery("FROM " + this.clazz.getName(),
                    this.clazz);

            List<T> entities = query.getResultList();
            transaction.commit();

            return entities;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            System.err.println("Failed to get all " + this.clazz.getSimpleName() +
                    ": " + e.getMessage());
            return Collections.emptyList();
        }finally {
            session.close();
        }
    }

    public T findById(int id){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<T> query = session.createQuery("FROM " + this.clazz.getName() + " WHERE id = :id", this.clazz)
                    .setParameter("id", id);

            transaction.commit();
            return query.getSingleResult();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            System.err.println("Failed to get " + this.clazz.getSimpleName() +
                    ": " + e.getMessage());
            return null;
        }finally {
            session.close();
        }
    }

}
