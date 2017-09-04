package com.supplier.action;

import com.entity.SupplierEntity;
import com.opensymphony.xwork2.ModelDriven;
import com.supplier.service.SupplierService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class SupplierDelete extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final SupplierService supplierService;

    @Autowired
    public SupplierDelete(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    // 删除
    public String execute() throws Exception {
        String cutomername = httpServletRequest.getParameter("cutomername");
        supplierService.delete(cutomername);
        return SUCCESS;
    }

}
