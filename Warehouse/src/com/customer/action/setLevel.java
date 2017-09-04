package com.customer.action;

import com.cargo.service.CargoService;
import com.customer.customerService.customerService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class setLevel extends ActionVariableSupport{
    // 使用CargoService进行事务请求
    private final customerService customerservice;


    @Autowired
    public setLevel(customerService customerservice) {
        this.customerservice = customerservice;
    }

    // 修改等级
    public String execute() throws Exception {
        String customername = httpServletRequest.getParameter("customername");
        if(httpServletRequest.getParameter("newlevel").equals(""))
        {
            return SUCCESS;
        }
        int newlevel = Integer.parseInt(httpServletRequest.getParameter("newlevel"));
        System.out.println(newlevel);
        if(newlevel > 3 )
        {
            return SUCCESS;
        }
        customerservice.setFirstLevel(customername, newlevel);
        return SUCCESS;
    }
}
