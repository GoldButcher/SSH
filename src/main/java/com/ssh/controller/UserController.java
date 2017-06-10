package com.ssh.controller;

import com.ssh.model.UserVO;
import com.ssh.service.IUserService;
import org.springframework.stereotype.Controller;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);//record log
    private static final String USER = "user";//page name

    public UserController() {
        System.out.println("UserController()");
    }

    @Resource
    private IUserService userService;

	@RequestMapping(value = "/user")
	@ResponseBody
	public UserVO getUser(Integer id){
		return userService.getByKey(id);
	}

}