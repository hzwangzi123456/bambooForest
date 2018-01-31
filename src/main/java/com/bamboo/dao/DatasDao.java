package com.bamboo.dao;

import com.bamboo.vo.Datas;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wangzi
 * @date 18/1/25 上午5:05.
 */
@Repository
public interface DatasDao {
    Integer insertDatas(Datas vo);

    Integer findDatasCountByVo(Datas vo);

    List<Datas> findDatasByPojo(Datas vo);

    List<Datas> findDatasByPage(Map<String, Object> map);
}
