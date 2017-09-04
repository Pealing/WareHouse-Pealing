package com.cargo.action;

import com.cargo.service.CargoService;
import com.entity.CargoEntity;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.utils.action.ActionVariableSupport;

/**
 * Created by Pealing on 2017/8/31.
 */
@Controller
public class CargoCreate extends ActionVariableSupport implements ModelDriven<CargoEntity> {
    // 使用CargoService进行事务请求
    private final CargoService cargoService;

    // Action所涉及的用户实体
    private CargoEntity cargoEntity;

    @Autowired
    public CargoCreate(CargoService cargoService) {
        this.cargoService = cargoService;
        cargoEntity = new CargoEntity();
    }

    public String execute()
    {
        if(cargoService.chkCargoname(cargoEntity.getName()))
        {
            return ERROR;
        }
        try {
            cargoService.create(cargoEntity);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public CargoEntity getModel () {
        return cargoEntity;
    }
}
