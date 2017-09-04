package com.cargo.action;

import com.cargo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.utils.action.ActionVariableSupport;

/**
 * Created by Pealing on 2017/9/1.
 */
@Controller
public class Login extends ActionVariableSupport  {

    // 使用cargoService进行事务请求
    private final CargoService cargoService;

    @Autowired
    public Login (CargoService cargoService) {
        this.cargoService = cargoService;
    }
    public String execute() throws Exception{
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        if (username.equals("cpx") && password.equals("llr")) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
