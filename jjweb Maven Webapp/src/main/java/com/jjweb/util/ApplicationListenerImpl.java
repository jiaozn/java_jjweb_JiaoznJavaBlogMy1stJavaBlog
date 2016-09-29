package com.jjweb.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import com.jjweb.model.Category;
import com.jjweb.model.Introduction;
import com.jjweb.model.IntroductionDAO;
import com.jjweb.model.User;
import com.jjweb.service.CategoryService;
import com.jjweb.service.IntroductionService;
import com.jjweb.service.UserService;

@Repository
// 交给Spring管理，如果不是自动扫描加载bean的方式，则在xml里配一个即可
public class ApplicationListenerImpl implements ApplicationListener {
	@Resource
	private UserService userService;
	//@Resource
	//private IntroductionService introductionService;
	@Resource
	private IntroductionDAO introductionDAO;
	@Resource
	private CategoryService categoryService;
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
		Category category=new Category();
		category.setName("主页文字");
		category.setArticals(null);
		category.setId(1);
		categoryService.save(category);
		
		category.setId(2);
		category.setArticals(null);
		category.setName("编程学习");
		categoryService.save(category);
		
		Introduction introduction=new Introduction();
		introduction.setId(1);
		introduction.setAccess("0");
		introduction.setContent(
				"<p>This is a JWeb application!</p>" +
				"<p>Init Introduction by Jiaozn.</p>");
		introduction.setTime(new Timestamp(new Date().getTime()));
		introductionDAO.merge(introduction);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}