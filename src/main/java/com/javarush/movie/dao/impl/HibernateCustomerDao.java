package com.javarush.movie.dao.impl;

import com.javarush.movie.dao.CustomerDao;
import com.javarush.movie.entity.Customer;

import java.util.List;
import java.util.Optional;

public class HibernateCustomerDao implements CustomerDao {
    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public <S extends Customer> S save(Customer entity) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }
}
