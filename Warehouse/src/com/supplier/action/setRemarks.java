package com.supplier.action;

import com.supplier.service.SupplierService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class setRemarks extends ActionVariableSupport {
    // 使supplierService进行事务请求
    protected final SupplierService supplierService;


    @Autowired
    public setRemarks(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    // 修改最小库存
    public String execute() throws Exception {
        String suppliername = httpServletRequest.getParameter("suppliername");
        String newremarks = httpServletRequest.getParameter("newremarks");
        supplierService.setRemark(suppliername, newremarks);
        return SUCCESS;
    }
}
