package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.SavepointManager;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserSerivceImpl implements IUserService{
@Autowired
private UserMapper userMapper;
@Override
public List<User> findAll() throws Exception{
	UserExample example=new UserExample();
	return userMapper.selectByExample(example);
}
@Override
public List<User> query(String keywords) throws Exception {
	// TODO Auto-generated method stub
	UserExample example=new UserExample();
	example.createCriteria().andNameLike(keywords);
	return userMapper.selectByExample(example);
	}
@Override
public void save(User user) throws Exception {
	// TODO Auto-generated method stub
	userMapper.insert(user);
}
@Override
public void update(User user) throws Exception {
	// TODO Auto-generated method stub
	userMapper.updateByPrimaryKey(user);
}
@Override
public void deleById(long id) throws Exception {
	// TODO Auto-generated method stub
	userMapper.deleteByPrimaryKey(id);
}
@Override
public void batchDelete(Long[] ids) throws Exception {
	// TODO Auto-generated method stub
	for(long id:ids){
		userMapper.deleteByPrimaryKey(id);
	}
}
}