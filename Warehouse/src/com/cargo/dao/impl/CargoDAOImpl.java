package com.cargo.dao.impl;

import com.cargo.dao.CargoDAO;
import com.entity.CargoEntity;
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
public class CargoDAOImpl implements CargoDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CargoDAOImpl(SessionFactory sessionFactory) {
        System.out.println(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public void create ( CargoEntity cargo ) {
        assert !"".equals(cargo.getName());
        assert !"".equals(cargo.getStock());
        assert !"".equals(cargo.getPrice());
        assert !"".equals(cargo.getMinstock());
        getSession().save(cargo);
    }

    @Override
    public void delete ( String cargoname ) {
        getSession()
                .createQuery("delete from CargoEntity u where u.name = :cargoname")
                .setParameter("cargoname", cargoname)
                .executeUpdate();
    }

    @Override
    public void setMinstock ( String cargoname, int MinStock ) {
        CargoEntity cargo = getByCargoname(cargoname);
        cargo.setMinstock(MinStock);
    }

    @Override
    public void setPrice ( String cargoname, int price ) {
        CargoEntity cargo = getByCargoname(cargoname);
        cargo.setPrice(price);
    }


    @Override
    public boolean needpurchased ( int id ) {
        CargoEntity cargo = getById(id);
        int minstock = cargo.getMinstock();
        int stock = cargo.getStock();
        if(minstock < stock)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public List<CargoEntity> getAllCargoEntity () {
        return (List<CargoEntity>) getSession().createQuery("from CargoEntity").getResultList();
    }

    @Override
    public void update ( CargoEntity cargoEntity ) {
        getSession().update(cargoEntity);
    }

    @Override
    public CargoEntity getById ( int id ) {
        return (CargoEntity) getSession()
                .createQuery("from CargoEntity where id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public CargoEntity getByCargoname ( String cargoname ) {
        return (CargoEntity) getSession()
                .createQuery("from CargoEntity u where u.name = :cargoname")
                .setParameter("cargoname", cargoname)
                .getSingleResult();
    }

    @Override
    public boolean chkCargoname ( String cargoname ) {
        try{
            getByCargoname(cargoname);
            System.out.println("true");
            return true;
        }catch (NoResultException e)
        {
            System.out.println("false");
            return false;
        }
    }
}
