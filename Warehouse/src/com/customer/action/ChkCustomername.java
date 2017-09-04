package com.customer.action;

import com.customer.customerService.customerService;
import com.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pealing on 2017/9/3.
 */
public class ChkCustomername extends ActionVariableSupport {

    // 使用CargoService进行事务请求
    private final customerService customerservice;


    @Autowired
    public ChkCustomername(customerService customerservice) {
        this.customerservice = customerservice;
    }

    // 判断
    public String execute() throws Exception {
        String customername = httpServletRequest.getParameter("customername");
        httpServletRequest.setAttribute("result", customerservice.chkCustomerrname(customername));
        return SUCCESS;
    }
}
