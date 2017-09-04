package com.purchase.dao.impl;

import com.entity.PurchaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.purchase.dao.purchaseDAO;

import java.util.List;

/**
 * Created by Pealing on 2017/8/30.
 */
@Repository
@Transactional
public class purchaseDAOImpl implements purchaseDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public purchaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void create ( PurchaseEntity putchase ) {
        getSession().save(putchase);
    }

    @Override
    public List<PurchaseEntity> getAllPurchaseEntities () {
        return (List<PurchaseEntity>) getSession().createQuery("from PurchaseEntity").getResultList();
    }

    @Override
    public List<PurchaseEntity> getPurchaseBySupplier ( int supplierid ) {
        return (List<PurchaseEntity>) getSession()
                .createQuery("from PurchaseEntity u where u.supplierId = :supplierid")
                .setParameter("supplierid", supplierid)
                .getResultList();

    }

    @Override
    public List<PurchaseEntity> getPurchaseByTime ( String time ) {
        return (List<PurchaseEntity>) getSession()
                .createQuery("from PurchaseEntity  u where u.data = :time")
                .setParameter("time",time)
                .getResultList();
    }

    @Override
    public List<PurchaseEntity> getPurchaseByCargo ( int cargoid ) {
        return (List<PurchaseEntity>) getSession()
                .createQuery("from PurchaseEntity  u where u.cargoId = :cargoid")
                .setParameter("cargoid", cargoid)
                .getResultList();
    }
}
