package com.bamboo.bo;

import com.bamboo.vo.User;
import com.common.system.SysRuntimeException;

import java.util.List;

/**
 * @author wangzi
 * @date 17/10/19 下午11:25.
 */
public interface UserBo {
    /**
     * find User by pojo
     * @param vo pojo
     * @return User List
     * @throws SysRuntimeException
     */
    List<User> findUserByPojo(User vo) throws SysRuntimeException;
}
