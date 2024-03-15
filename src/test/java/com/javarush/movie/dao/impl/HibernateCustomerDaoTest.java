package com.javarush.movie.dao.impl;

import com.javarush.movie.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


//https://www.javaguides.net/2019/11/hibernate-h2-database-example-tutorial.html?utm_content=cmp-true
class HibernateCustomerDaoTest extends AbstractBaseDaoTest {

    private final HibernateCustomerDao hibernateCustomerDao = new HibernateCustomerDao(sessionFactory);

    @Test
    void findByIdShouldReturnItem() {
        Customer actual = hibernateCustomerDao.findById(1).orElse(null);

        Customer expected = new Customer();

        Assertions.assertEquals(expected, actual);

        Assertions.assertTrue(expected.equals(actual));
        assertThat(actual, is(notNullValue()));

        assertThat(actual, is(expected));

        assertThat(actual.getId(), is(1));
    }
}