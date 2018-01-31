package com.bamboo.bo.impl;

import com.bamboo.bo.DatasBo;
import com.bamboo.dao.DatasDao;
import com.bamboo.vo.Datas;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangzi
 * @date 18/1/25 上午5:08.
 */
@Service
public class DatasBoImpl implements DatasBo {

    @Autowired
    private DatasDao datasDao;

    @Override
    public Integer insertDatas(Datas vo) throws SystemException {
        return datasDao.insertDatas(vo);
    }

    @Override
    public Integer findDatasCountByVo(Datas vo) {
        return datasDao.findDatasCountByVo(vo);
    }

    @Override
    public List<Datas> findDatasByPojo(Datas vo) {
        return datasDao.findDatasByPojo(vo);
    }

    @Override
    public List<Datas> findDatasByPage(Map<String, Object> map) {
        return datasDao.findDatasByPage(map);
    }
}
