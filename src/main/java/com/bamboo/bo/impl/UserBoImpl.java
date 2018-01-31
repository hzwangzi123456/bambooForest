package com.bamboo.bo.impl;

import com.bamboo.bo.UserBo;
import com.bamboo.dao.UserDao;
import com.bamboo.vo.User;
import com.common.system.SysRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzi
 * @date 17/10/19 下午11:25.
 */
@Service
public class UserBoImpl implements UserBo {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUserByPojo(User vo) throws SysRuntimeException {
        return userDao.findUserByPojo(vo);
    }

}
