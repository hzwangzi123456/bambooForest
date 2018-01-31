package com.bamboo.bo;

import com.bamboo.vo.Datas;

import java.util.List;
import java.util.Map;

/**
 * @author wangzi
 * @date 18/1/25 上午5:05.
 */
public interface DatasBo {
    Integer insertDatas(Datas vo);

    Integer findDatasCountByVo(Datas vo);

    List<Datas> findDatasByPojo(Datas vo);

    List<Datas> findDatasByPage(Map<String, Object> map);
}
