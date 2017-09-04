package com.supplier.action;

import com.entity.SupplierEntity;
import com.opensymphony.xwork2.ModelDriven;
import com.supplier.service.SupplierService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Pealing on 2017/9/3.
 */
@Controller
public class SupplierCreate extends ActionVariableSupport implements ModelDriven<SupplierEntity>{
    // SupplierService
    private final SupplierService supplierService;

    // Action所涉及的用户实体
    private SupplierEntity supplierEntity;

    @Autowired
    public SupplierCreate ( SupplierService supplierService ) {
        this.supplierService = supplierService;
        supplierEntity = new SupplierEntity();
    }

    public String execute()
    {
        if(supplierService.chkSupplierrname(supplierEntity.getName()))
        {
            return ERROR;
        }
        try {
            supplierService.create(supplierEntity);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
    @Override
    public SupplierEntity getModel () {
        return supplierEntity;
    }
}
