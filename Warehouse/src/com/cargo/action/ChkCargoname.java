package com.cargo.action;

import com.cargo.service.CargoService;
import com.entity.CargoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.utils.action.ActionVariableSupport;

/**
 * Created by Pealing on 2017/9/1.
 */
@Controller
public class ChkCargoname extends ActionVariableSupport {

    // 使用CargoService进行事务请求
    private final CargoService cargoService;


    @Autowired
    public ChkCargoname(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 判断
    public String execute() throws Exception {
        String cargoname = httpServletRequest.getParameter("cargoname");
        httpServletRequest.setAttribute("result", cargoService.chkCargoname(cargoname));
        return SUCCESS;
    }
}
