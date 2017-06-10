package com.ssh.service.impl;

import com.ssh.dao.IUserDAO;
import com.ssh.model.UserVO;
import com.ssh.service.IUserService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/28.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<Integer,UserVO> implements IUserService {
	@Resource
	private IUserDAO userDAO;

	@Resource
    public void setUserDAO(IUserDAO userDAO) {
		super.setBaseDao(userDAO);
    }
}
