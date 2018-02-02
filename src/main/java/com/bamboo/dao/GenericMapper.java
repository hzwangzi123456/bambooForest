package com.bamboo.dao;

import java.util.List;
import java.util.Map;

/**
 * @author wangzi
 * @date 18/2/2 上午6:05.
 */
public interface GenericMapper<T> {
    Integer insert(T vo);

    Integer findCountByVo(T vo);

    List<T> findByPojo(T vo);

    List<T> findByPage(Map<String, Object> map);
}