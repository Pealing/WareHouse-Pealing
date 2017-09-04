package com.sell.dao.impl;

import com.entity.SellEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sell.dao.sellDAO;

import java.util.List;

/**
 * Created by Pealing on 2017/8/30.
 */
@Repository
@Transactional
public class sellDAOImpl implements sellDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public sellDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public void create ( SellEntity sell ) {
        getSession().save(sell);
    }

    @Override
    public List<SellEntity> getAllSellEntities () {

        return (List<SellEntity>) getSession()
                .createQuery("from SellEntity ").getResultList();
    }

    @Override
    public List<SellEntity> getSellByCustomername ( int customerid ) {

        return (List<SellEntity>) getSession()
                .createQuery("from SellEntity u where u.customerId = :customerid")
                .setParameter("customerid", customerid)
                .getResultList();
    }

    @Override
    public List<SellEntity> getSellByTime ( String time ) {
        return (List<SellEntity>) getSession()
                .createQuery("from SellEntity u where u.data = :time")
                .setParameter("time", time)
                .getResultList();
    }

    @Override
    public List<SellEntity> getSellByCargo ( int cargoid ) {
        return (List<SellEntity>) getSession()
                .createQuery("from SellEntity u where u.cargoId = :cargoid")
                .setParameter("cargoid", cargoid)
                .getResultList();
    }
}
