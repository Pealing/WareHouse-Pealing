package com.supplier.action;

import com.entity.SupplierEntity;
import com.supplier.service.SupplierService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Pealing on 2017/9/3.
 */
public class getAllSupplier extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final SupplierService supplierService;


    @Autowired
    public getAllSupplier(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    // 获取所有货物实体
    public String execute() throws Exception {
        System.out.println("12345");
        List<SupplierEntity> supplierEntitylist =  supplierService.getAllSupplierEntities();
        httpServletRequest.setAttribute("supplierList", supplierEntitylist);
        return SUCCESS;
    }
}
