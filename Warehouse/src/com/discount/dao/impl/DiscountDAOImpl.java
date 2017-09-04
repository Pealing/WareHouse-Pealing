package com.discount.dao.impl;

import com.discount.dao.DiscountDAO;
import com.entity.DiscountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pealing on 2017/9/4.
 */
@Repository
@Transactional
public class DiscountDAOImpl implements DiscountDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public DiscountDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public DiscountEntity getById ( int id ) {
        return (DiscountEntity) getSession().
                createQuery("from DiscountEntity u where u.id = :id")
                .setParameter("id", 3)
                .getSingleResult();
    }

    @Override
    public void setSetting ( int id, double totalfirst, double totalsecond, double totalthird, double discountfirst, double discountsecond, double discountthird ) {
        DiscountEntity discountEntity = getById(3);
        discountEntity.setDiscountFirst(discountfirst);
        discountEntity.setDiscountSecond(discountsecond);
        discountEntity.setDiscountThird(discountthird);
        discountEntity.setTotalFirst(totalfirst);
        discountEntity.setTotalSecond(totalsecond);
        discountEntity.setTotalThird(totalthird);
    }

    @Override
    public double getTotalFirst ( int id ) {
        DiscountEntity discountEntity = getById(3);
        return discountEntity.getTotalFirst();
    }

    @Override
    public double getTotalSecond ( int id ) {
        DiscountEntity discountEntity = getById(3);
        return  discountEntity.getTotalSecond();
    }

    @Override
    public double getTotalThird ( int id ) {
        DiscountEntity discountEntity = getById(3);
        return discountEntity.getTotalThird();
    }

    @Override
    public double getDiscountFirst ( int id ) {
        DiscountEntity discountEntity = getById(3);
        return discountEntity.getDiscountFirst();
    }

    @Override
    public double getDiscountSecond ( int id ) {
        DiscountEntity discountEntity = getById(3);
        return discountEntity.getDiscountSecond();
    }

    @Override
    public double getDiscountThird ( int id ) {
        DiscountEntity discountEntity = getById(3);
        return discountEntity.getDiscountThird();
    }
}
