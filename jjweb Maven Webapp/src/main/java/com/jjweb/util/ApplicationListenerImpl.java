package com.jjweb.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import com.jjweb.model.User;
import com.jjweb.service.UserService;

@Repository
// 交给Spring管理，如果不是自动扫描加载bean的方式，则在xml里配一个即可
public class ApplicationListenerImpl implements ApplicationListener {
	@Resource
	private UserService userService;

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		// TODO Auto-generated method stub
		List<User> list = userService.findAll();
		if (list.size() <= 0) {
			User user = new User();
			user.setName("jiaozn");
			user.setPassword("jiaozn");
			user.setAuthority(7);
			user.setTime(new Timestamp(new Date().getTime()));
			userService.save(user);
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}