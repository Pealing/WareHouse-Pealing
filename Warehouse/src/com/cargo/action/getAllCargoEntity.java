package com.cargo.action;

import com.cargo.service.CargoService;
import com.entity.CargoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.utils.action.ActionVariableSupport;

import java.util.List;

/**
 * Created by Pealing on 2017/9/1.
 */
@Controller
public class getAllCargoEntity extends ActionVariableSupport {

    // 使用CargoService进行事务请求
    private final CargoService cargoService;


    @Autowired
    public getAllCargoEntity(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 获取所有货物实体
    public String execute() throws Exception {
        List<CargoEntity> cargoEntitylist =  cargoService.getAllCargoEntity();
        httpServletRequest.setAttribute("cargoList", cargoEntitylist);
        return SUCCESS;
    }
}
