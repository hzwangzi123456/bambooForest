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
public abstract class GenericService<T> {
    @Autowired
    protected GenericMapper<T> mapper;

    public abstract Integer insert(T vo) throws SysRuntimeException;

    public abstract Integer findCountByVo(T vo) throws SysRuntimeException;

    public abstract List<T> findByPojo(T vo) throws SysRuntimeException;

    public abstract List<T> findByPage(Map<String, Object> map) throws SysRuntimeException;


}
