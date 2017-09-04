package com.customer.dao.impl;

import com.entity.CustomerEntity;
import com.customer.dao.customerDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Pealing on 2017/8/30.
 */

@Repository
@Transactional
public class customerDAOImpl implements customerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public customerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void create( CustomerEntity customer) {
        assert !"".equals(customer.getName());
        getSession().save(customer);
    }

    @Override
    public void delete( String customername) {
        getSession()
                .createQuery("delete from CustomerEntity u where u.name = :customername")
                .setParameter("customername", customername)
                .executeUpdate();
    }

    @Override
    public void setLevel ( String custmoername, int level ) {
        CustomerEntity customer = getByCustomername(custmoername);
        customer.setLevel1(level);
    }

    @Override
    public void setFirstLevel ( String custmoername, int level ) {
        CustomerEntity customer = getByCustomername(custmoername);
        customer.setFirstlevel(level);
    }

    @Override
    public void setnewPhone ( String custmoername, String phone ) {
        CustomerEntity customer = getByCustomername(custmoername);
        customer.setPhone(phone);
    }

    @Override
    public List<CustomerEntity> getAllCustomerEntities () {
        return (List<CustomerEntity>) getSession().createQuery("from CustomerEntity").getResultList();
    }

    @Override
    public CustomerEntity getByCustomername ( String customername ) {
        return (CustomerEntity) getSession()
                .createQuery("from CustomerEntity u where u.name = :customername")
                .setParameter("customername", customername)
                .getSingleResult();
    }

    @Override
    public boolean chkCustomerrname ( String customername ) {
        try {
            getByCustomername(customername);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public void update ( CustomerEntity customerEntity ) {
        getSession().update(customerEntity);
    }

    @Override
    public CustomerEntity getById ( int id ) {
        return (CustomerEntity)getSession().
                createQuery("from CustomerEntity u where u.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

}
