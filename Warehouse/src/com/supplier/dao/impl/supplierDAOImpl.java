package com.supplier.dao.impl;

import com.entity.SupplierEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.supplier.dao.supplierDAO;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Pealing on 2017/8/30.
 */
@Repository
@Transactional
public class supplierDAOImpl implements supplierDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public supplierDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void create ( SupplierEntity supplier ) {
        assert !"".equals(supplier.getName());
        getSession().save(supplier);
    }

    @Override
    public void delete ( String suppliername ) {
        getSession()
                .createQuery("delete from SupplierEntity u where u.name = :suppliername")
                .setParameter("suppliername", suppliername)
                .executeUpdate();
    }

    @Override
    public List<SupplierEntity> getAllSupplierEntities () {
        return (List<SupplierEntity>) getSession().createQuery("from SupplierEntity ").getResultList();
    }

    @Override
    public SupplierEntity getBySuppliername ( String suppliername ) {
        return (SupplierEntity) getSession()
                .createQuery("from SupplierEntity u where u.name = :name")
                .setParameter("name", suppliername)
                .getSingleResult();
    }

    @Override
    public boolean chkSupplierrname ( String suppliername ) {
        try {
            getBySuppliername(suppliername);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public void update ( SupplierEntity supplierEntity ) {
        getSession().update(supplierEntity);
    }

    @Override
    public SupplierEntity getById ( int id ) {

        return (SupplierEntity) getSession()
                .createQuery("from SupplierEntity u where u.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void setPhone ( String suppliername, String phone ) {
        SupplierEntity supplierEntity = getBySuppliername(suppliername);
        supplierEntity.setPhone(phone);
    }

    @Override
    public void setRemark ( String suppliername, String remark ) {
        SupplierEntity supplierEntity = getBySuppliername(suppliername);
        supplierEntity.setRemarks(remark);
    }
}
