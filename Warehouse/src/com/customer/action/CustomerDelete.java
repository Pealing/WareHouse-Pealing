package com.customer.action;

import com.customer.customerService.customerService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class CustomerDelete extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final customerService customerservice;

    @Autowired
    public CustomerDelete(customerService customerservice) {
        this.customerservice = customerservice;
    }

    // 删除
    public String execute() throws Exception {
        String customername = httpServletRequest.getParameter("customername");
        customerservice.delete(customername);
        return SUCCESS;
    }
}
