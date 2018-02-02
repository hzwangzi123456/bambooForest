package com.bamboo.bo.impl;

import com.bamboo.bo.GenericService;
import com.bamboo.vo.Datas;
import com.common.system.SysRuntimeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangzis
 * @date 18/1/25 上午5:08.
 */
@Service
public class DatasBoImpl extends GenericService<Datas> {

    @Override
    public Integer insert(Datas vo) throws SysRuntimeException {
        return mapper.insert(vo);
    }

    @Override
    public Integer findCountByVo(Datas vo) throws SysRuntimeException {
        return mapper.findCountByVo(vo);
    }

    @Override
    public List<Datas> findByPojo(Datas vo) throws SysRuntimeException {
        return mapper.findByPojo(vo);
    }

    @Override
    public List<Datas> findByPage(Map<String, Object> map) throws SysRuntimeException {
        return mapper.findByPage(map);
    }
}
