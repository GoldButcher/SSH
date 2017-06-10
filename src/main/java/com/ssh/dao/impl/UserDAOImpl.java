package com.ssh.dao.impl;

import com.ssh.dao.IUserDAO;
import com.ssh.model.UserVO;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/7/28.
 */
@Repository
public class UserDAOImpl extends BaseDaoImpl<Integer,UserVO> implements IUserDAO {

}
