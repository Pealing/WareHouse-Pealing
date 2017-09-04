package com.customer.action;

import com.customer.customerService.customerService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class setPhone extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final customerService customerservice;


    @Autowired
    public setPhone(customerService customerservice) {
        this.customerservice = customerservice;
    }

    // 修改最小库存
    public String execute() throws Exception {
        String customername = httpServletRequest.getParameter("customername");
        String newphone = httpServletRequest.getParameter("newphone");
        if(newphone.equals(""))
        {
            return SUCCESS;
        }
        customerservice.setnewPhone(customername, newphone);
        return SUCCESS;
    }
}
