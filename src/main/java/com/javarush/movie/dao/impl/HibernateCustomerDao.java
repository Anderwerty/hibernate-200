package com.javarush.movie.dao.impl;

import com.javarush.movie.dao.CustomerDao;
import com.javarush.movie.entity.Customer;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class HibernateCustomerDao implements CustomerDao {
    private final SessionFactory sessionFactory;

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> customerQuery = session.createQuery("FROM Client", Customer.class);
            return customerQuery.list();
        }
    }

    @Override
    public boolean deleteById(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, id);

            return Optional.ofNullable(customer);
        }
    }

    public List<Customer> findByName(String name, int limit, int offset) {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("from Client where customerName = :name", Customer.class);

            query.setParameter("name", name);
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            return query.getResultList();
        }
    }

    @Override
    public Customer save(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return customer;
    }
}
