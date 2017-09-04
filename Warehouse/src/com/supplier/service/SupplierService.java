package com.supplier.service;

import com.entity.SupplierEntity;

import java.util.List;

/**
 * Created by Pealing on 2017/9/3.
 */
public interface SupplierService {
    /**
     * 创建新供货商
     *
     * @param supplier 供货商实体
     */
    void create( SupplierEntity supplier);

    /**
     * 删除供货商
     *
     * @param suppliername 供货商实体
     */
    void delete( String suppliername);


    /**
     * 获取所有供货商实体
     *
     * @return 所有的供货商实体
     */
    List<SupplierEntity> getAllSupplierEntities();

    /**
     * 根据供货商名获取实体
     *
     * @param suppliername 供货商名
     * @return 客户实体
     */
    SupplierEntity getBySuppliername(String suppliername);

    /**
     * 检测供货商是否存在
     *
     * @param suppliername 供货商名
     * @return 是否存在
     */
    boolean chkSupplierrname(String suppliername);

    /**
     * 更新用户
     *
     * @param supplierEntity 供货商实体
     */
    void update(SupplierEntity supplierEntity);

    /**
     * 根据ID获取用户
     *
     * @param id 供货商ID
     * @return 供货商实体
     */
    SupplierEntity getById(int id);
    /**
     * @param suppliername 供货商姓名
     * @param phone 供货商电话
     */
    void setPhone(String suppliername, String phone);

    /**
     * @param suppliername 供货商姓名
     * @param remark 备注
     */
    void setRemark(String suppliername, String remark);
}
