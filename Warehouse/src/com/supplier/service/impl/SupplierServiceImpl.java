package com.supplier.service.impl;

import com.customer.dao.customerDAO;
import com.entity.SupplierEntity;
import com.supplier.dao.supplierDAO;
import com.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pealing on 2017/9/3.
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    /**
     * 使用Customer的DAO实现事务请求
     */
    private final supplierDAO supplierdao;

    @Autowired
    public SupplierServiceImpl(supplierDAO supplierdao) {
        System.out.println(supplierdao);
        this.supplierdao = supplierdao;
    }
    @Override
    public void create ( SupplierEntity supplier ) {
        supplierdao.create(supplier);
    }

    @Override
    public void delete ( String suppliername ) {
        supplierdao.delete(suppliername);
    }

    @Override
    public List<SupplierEntity> getAllSupplierEntities () {
        return supplierdao.getAllSupplierEntities();
    }

    @Override
    public SupplierEntity getBySuppliername ( String suppliername ) {
        return supplierdao.getBySuppliername(suppliername);
    }

    @Override
    public boolean chkSupplierrname ( String suppliername ) {
        return supplierdao.chkSupplierrname(suppliername);
    }

    @Override
    public void update ( SupplierEntity supplierEntity ) {
        supplierdao.update(supplierEntity);
    }

    @Override
    public SupplierEntity getById ( int id ) {
        return supplierdao.getById(id);
    }

    @Override
    public void setPhone ( String suppliername, String phone ) {
        supplierdao.setPhone(suppliername, phone);
    }

    @Override
    public void setRemark ( String suppliername, String remark ) {
        supplierdao.setRemark(suppliername, remark);
    }
}
