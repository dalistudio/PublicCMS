package com.wangdali.common.base;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务的基类
 * 
 * @author dali
 *
 * @param <E>
 */

@Transactional
public abstract class BaseService<E> extends Base {
    @Autowired
    protected BaseDao<E> dao;

    /**
     * 获得实体
     * 
     * @param id
     * @return
     */
    public E getEntity(Serializable id) {
        return dao.getEntity(id);
    }

    /**
     * 获得实体
     * 
     * @param id
     * @param pk
     * @return
     */
    public E getEntity(Serializable id, String pk) {
        return dao.getEntity(id, pk);
    }

    /**
     * 获得实体
     * 
     * @param id
     * @return
     */
    public List<E> getEntitys(Serializable[] ids, String pk) {
        return dao.getEntitys(ids, pk);
    }

    /**
     * 获得实体
     * 
     * @param id
     * @return
     */
    public List<E> getEntitys(Serializable[] ids) {
        return dao.getEntitys(ids);
    }

    /**
     * 删除
     * 
     * @param id
     * @return
     */
    public void delete(Serializable[] ids) {
        for (Serializable id : ids) {
            delete(id);
        }
    }

    /**
     * 删除
     * 
     * @param id
     * @return
     */
    public void delete(Serializable id) {
        dao.delete(id);
    }

    /**
     * 更新
     * 
     * @param id
     * @param newEntity
     * @param ignoreProperties
     * @return
     */
    public E update(Serializable id, E newEntity, String[] ignoreProperties) {
        E entity = getEntity(id);
        if (notEmpty(entity)) {
            copyProperties(dao.init(newEntity), entity, ignoreProperties);
        }
        return entity;
    }

    /**
     * 更新
     * 
     * @param id
     * @param newEntity
     * @return
     */
    public void update(Serializable id, E newEntity) {
        E entity = getEntity(id);
        if (notEmpty(entity)) {
            copyProperties(dao.init(newEntity), entity);
        }
    }

    /**
     * 保存
     * 
     * @param entity
     * @return
     */
    public Serializable save(E entity) {
        return dao.save(entity);
    }
}
