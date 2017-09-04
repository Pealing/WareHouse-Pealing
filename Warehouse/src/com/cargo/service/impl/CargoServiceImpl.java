package com.cargo.service.impl;

import com.cargo.dao.CargoDAO;
import com.cargo.service.CargoService;
import com.entity.CargoEntity;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pealing on 2017/8/31.
 */
@Service
public class CargoServiceImpl implements CargoService {
    /**
     * 使用User的DAO实现事务请求
     */
    private final CargoDAO cargoDAO;

    @Autowired
    public CargoServiceImpl(CargoDAO cargoDAO) {
        System.out.println(cargoDAO);
        this.cargoDAO = cargoDAO;
    }

    @Override
    public void create ( CargoEntity cargoentity ) {
        System.out.println("this is service");
        cargoDAO.create(cargoentity);
    }

    @Override
    public void delete ( String cargoname ) {
        cargoDAO.delete(cargoname);
    }

    @Override
    public void setMinstock ( String cargoname, int MinStock ) {
        cargoDAO.setMinstock(cargoname, MinStock);
    }

    @Override
    public void setPrice ( String cargoname, int price ) {
        cargoDAO.setPrice(cargoname, price);
    }

    @Override
    public boolean needpurchased ( int id ) {
        return cargoDAO.needpurchased(id);
    }

    @Override
    public boolean chkCargoname ( String cargoname ) {
        return cargoDAO.chkCargoname(cargoname);
    }

    @Override
    public CargoEntity getById ( int id ) {
        return cargoDAO.getById(id);
    }

    @Override
    public CargoEntity getByCargoname ( String cargoname ) {
        return cargoDAO.getByCargoname(cargoname);
    }

    @Override
    public List<CargoEntity> getAllCargoEntity () { return cargoDAO.getAllCargoEntity();}

    @Override
    public void update ( CargoEntity cargoEntity ) {
        cargoDAO.update(cargoEntity);
    }
}
