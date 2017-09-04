package com.customer.customerService.Impl;

import com.customer.customerService.customerService;
import com.customer.dao.customerDAO;
import com.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pealing on 2017/9/3.
 */
@Service
public class customerServiceImpl implements customerService {
    /**
     * 使用Customer的DAO实现事务请求
     */
    private final customerDAO customerdao;

    @Autowired
    public customerServiceImpl(customerDAO customerdao) {
        System.out.println(customerdao);
        this.customerdao = customerdao;
    }

    @Override
    public void create ( CustomerEntity customerentity ) {
        customerdao.create(customerentity);
    }

    @Override
    public void delete ( String customername ) {
        customerdao.delete(customername);
    }

    @Override
    public void setLevel ( String custmoername, int level ) {
        customerdao.setLevel(custmoername,level);
    }

    @Override
    public void setFirstLevel ( String custmoername, int level ) {
        customerdao.setFirstLevel(custmoername,level);
    }

    @Override
    public void setnewPhone ( String custmoername, String phone ) {
        customerdao.setnewPhone(custmoername, phone);
    }

    @Override
    public List<CustomerEntity> getAllCustomerEntities () {
        return customerdao.getAllCustomerEntities();
    }

    @Override
    public CustomerEntity getByCustomername ( String customername ) {
        return customerdao.getByCustomername(customername);
    }

    @Override
    public boolean chkCustomerrname ( String customername ) {
        return customerdao.chkCustomerrname(customername);
    }

    @Override
    public void update ( CustomerEntity customerEntity ) {
        customerdao.update(customerEntity);
    }

    @Override
    public CustomerEntity getById ( int id ) {
        return customerdao.getById(id);
    }

}
