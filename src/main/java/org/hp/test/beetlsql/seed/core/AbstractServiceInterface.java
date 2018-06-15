package org.hp.test.beetlsql.seed.core;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础service类
 *
 * @author hepan
 * @create 2018-03-18 下午9:00
 **/

public abstract class AbstractServiceInterface<T> implements ServiceInterface<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    private Class<T> modelClass;

    public AbstractServiceInterface() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T model) {
        mapper.insert(model);
    }

    @Override
    public void save(List<T> models) {
        mapper.insertBatch(models);
    }

    @Override
    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }

    @Override
    public void update(T model) {
        mapper.updateTemplateById(model);
    }

    @Override
    public T findById(Integer id) {
        return mapper.unique(id);
    }

    @Override
    public T findById(String id) {
        return mapper.unique(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws ServiceException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.templateOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> findAll() {
        return mapper.all();
    }


    @Override
    public PageQuery<T> pageQuery(long page, long size)  {
        PageQuery<T> pq = new PageQuery(page, size);
        String className = modelClass.getSimpleName();
        String sqlId= className.toLowerCase()+".queryPage"+className;
        return mapper.getSQLManager().pageQuery(sqlId, modelClass, pq);
    }

}
