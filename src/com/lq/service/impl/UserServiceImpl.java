package com.lq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lq.dao.IUserDao;
import com.lq.dao.impl.UserDaoImpl;
import com.lq.po.User;
import com.lq.service.IUserService;

@Component("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource
	private IUserDao userDao;
	
	public void add(String uname){
		System.out.println("UserService.add()");
		User u = new User();
		u.setUsername(uname);
		userDao.save(u);
	}
	
	public void sayHello()
	{
		System.out.println("hello");
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	public User loadById(int id) {
		// TODO Auto-generated method stub
		return userDao.loadById(id);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	
	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	
	public int getTotalCount(int con, String convalue, User userRole,int type, int queryState, String starttime, String endtime) {
		String queryString = "select count(*) from User mo where 1=1 ";
		Object[] p = null;
		
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			if(con==2){
				queryString += "and mo.number like ? "; 
			}
			if(con==3){
				queryString += "and mo.idcard like ? "; 
			}
			if(con==4){
				queryString += "and mo.userRole.realname like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		if(type!=0){
			queryString += " and mo.type ="+type;
		}
		if(queryState!=0){
			queryString += " and mo.handleState ="+queryState;
		}
		if(starttime!=null&&!starttime.equals("")){
			queryString += " and mo.joinDate>='"+starttime+"'";
		}
		if(endtime!=null&&!endtime.equals("")){
			queryString += " and mo.joinDate<='"+endtime+"'";
		}
		
		
		return userDao.getUniqueResult(queryString,p);
	}
	
	
	public List<User> queryList(int con, String convalue, User userRole, int page, int size,int type, int queryState, String starttime, String endtime) {
		String queryString = "from User mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			if(con==2){
				queryString += "and mo.number like ? "; 
			}
			if(con==3){
				queryString += "and mo.idcard like ? "; 
			}
			if(con==4){
				queryString += "and mo.userRole.realname like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		if(type!=0){
			queryString += " and mo.type ="+type;
		}
		if(queryState!=0){
			queryString += " and mo.handleState ="+queryState;
		}
		if(starttime!=null&&!starttime.equals("")){
			queryString += " and mo.joinDate>='"+starttime+"'";
		}
		if(endtime!=null&&!endtime.equals("")){
			queryString += " and mo.joinDate<='"+endtime+"'";
		}
		return userDao.pageList(queryString,p,page,size);
	}


	
}
