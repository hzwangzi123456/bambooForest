package com.bamboo.bo.impl;

import com.bamboo.bo.GenericService;
import com.bamboo.vo.User;
import com.common.system.SysRuntimeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangzi
 * @date 17/10/19 下午11:25.
 */
@Service
public class UserBoImpl extends GenericService<User> {

    @Override
    public Integer insert(User vo) throws SysRuntimeException {
        return mapper.insert(vo);
    }

    @Override
    public Integer findCountByVo(User vo) throws SysRuntimeException {
        return mapper.findCountByVo(vo);
    }

    @Override
    public List<User> findByPojo(User vo) throws SysRuntimeException {
        return mapper.findByPojo(vo);
    }

    @Override
    public List<User> findByPage(Map<String, Object> map) throws SysRuntimeException {
        return mapper.findByPage(map);
    }
}
