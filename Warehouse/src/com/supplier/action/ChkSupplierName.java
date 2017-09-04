package com.supplier.action;

import com.supplier.service.SupplierService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class ChkSupplierName extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final SupplierService supplierService;


    @Autowired
    public ChkSupplierName(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    // 判断
    public String execute() throws Exception {
        String suppliername = httpServletRequest.getParameter("suppliername");
        httpServletRequest.setAttribute("result", supplierService.chkSupplierrname(suppliername));
        return SUCCESS;
    }
}
