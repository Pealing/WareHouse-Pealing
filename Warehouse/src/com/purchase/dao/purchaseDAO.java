package com.purchase.dao;

import com.entity.PurchaseEntity;

import java.util.List;

/**
 * Created by Pealing on 2017/8/30.
 */
public interface purchaseDAO {
    /**
     * 创建新订单
     *
     * @param putchase 进货单实体
     */
    void create( PurchaseEntity putchase);

    /**
     * 获取所有进货单实体
     *
     * @return 所有的进货单实体
     */
    List<PurchaseEntity> getAllPurchaseEntities();

    /**
     * 根据供货商获取进货单实体
     *
     * @param supplierid 供货商ID
     * @return 进货单实体
     */
    List<PurchaseEntity> getPurchaseBySupplier(int supplierid);

    /**
     * 根据供货商获取进货单实体
     *
     * @param time 时间
     * @return 进货单实体
     */
    List<PurchaseEntity> getPurchaseByTime(String time);
    /**
     * 根据货物获取进货单实体
     *
     * @param cargoid 货物ID
     * @return 进货单实体
     */
    List<PurchaseEntity> getPurchaseByCargo(int cargoid);

}
