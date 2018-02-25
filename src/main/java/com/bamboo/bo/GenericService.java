package com.bamboo.bo;

import com.bamboo.dao.GenericMapper;
import com.bamboo.vo.Datas;
import com.common.system.SysRuntimeException;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangzi
 * @date 18/2/2 上午6:45.
 */
@Service
public abstract class GenericService<T> implements GenericServiceBo<T> {
    @Autowired
    protected GenericMapper<T> mapper;

    @Override
    public Integer insert(T vo) throws SysRuntimeException {
        return mapper.insert(vo);
    }

    @Override
    public T findByKey(T vo) {
        return mapper.findByKey(vo);
    }

    @Override
    public Integer findCountByVo(T vo) throws SysRuntimeException {
        return mapper.findCountByVo(vo);
    }

    @Override
    public List<T> findByPojo(T vo) throws SysRuntimeException {
        return mapper.findByPojo(vo);
    }

    @Override
    public List<T> findByPage(Map<String, Object> map) throws SysRuntimeException {
        return mapper.findByPage(map);
    }

    @Override
    public List<T> findByWhere(Map<String, Object> map) throws SysRuntimeException {
        return mapper.findByWhere(map);
    }

    @Override
    public List<T> findByQueryStr(String queryStr) throws SysRuntimeException {
        return mapper.findByQueryStr(queryStr);
    }

    @Override
    public Integer update(T vo) {
        return mapper.update(vo);
    }
}
